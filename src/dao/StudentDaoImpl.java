package dao;

import static utils.DBUtils.fetchDBConnection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.Part;

import pojos.Student;

public class StudentDaoImpl implements IStudentDao {
	private Connection cn;
	private PreparedStatement saveStudent;
	private PreparedStatement fetchStudentsData;
	private PreparedStatement saveStudent2;

	public StudentDaoImpl(String drvrClass, String url, String userName, String password) throws SQLException, ClassNotFoundException {
		cn = fetchDBConnection(drvrClass, url, userName, password);
		fetchStudentsData = cn.prepareStatement("SELECT * FROM student");
		saveStudent = cn.prepareStatement("insert into student (id, name, image) values (?,?,?)");
		saveStudent2 = cn.prepareStatement("insert into student (id, name) values (?,?)");
	}

	@Override
	public List<Student> fetchStudents() throws SQLException, IOException {

		List<Student> students = new ArrayList<>();

		ResultSet result = fetchStudentsData.executeQuery();
		while (result.next()) {
			Student student = new Student();
			String id = result.getString("id");
			String name = result.getString("name");
			Blob blob = result.getBlob("image");
			if (blob != null) {

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				student.setBase64Image(base64Image);
			} else {
				student.setBase64Image("");
			}
			student.setId(id);
			student.setName(name);

			students.add(student);

		}
		return students;
	}

	@Override
	public void saveStudentData(String id, String name, Part part) throws SQLException, IOException {
		InputStream is;
		if (part != null) {

			is = part.getInputStream();
			saveStudent.setBlob(3, is);
			saveStudent.setString(1, id);
			saveStudent.setString(2, name);
			saveStudent.executeUpdate();
		}else {
			saveStudent2.setString(1, id);
			saveStudent2.setString(2, name);
			saveStudent2.executeUpdate();
		}
	}

}
