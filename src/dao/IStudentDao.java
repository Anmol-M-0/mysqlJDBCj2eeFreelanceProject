package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Part;

import pojos.Student;

public interface IStudentDao {
	List<Student> fetchStudents() throws SQLException, IOException;
	void saveStudentData(String id, String name, Part part) throws SQLException, IOException;
}
