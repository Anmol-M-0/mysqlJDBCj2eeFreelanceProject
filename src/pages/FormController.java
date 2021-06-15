package pages;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.IStudentDao;
import dao.StudentDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/image_uploading")
@MultipartConfig(maxFileSize = 16177216)
public class FormController extends HttpServlet {
	  private IStudentDao dao;
	    public FormController() {
	        super();
	    }
	    public void init() throws ServletException {
			try {
				System.out.println("in init");
				ServletConfig config = getServletConfig();
				ServletContext ctx = config.getServletContext();
				dao =new StudentDaoImpl(ctx.getInitParameter("drvr"), ctx.getInitParameter("url"), ctx.getInitParameter("user"), ctx.getInitParameter("password"));
			} catch (Exception e) {
				throw new ServletException("err in init : "+getClass().getName(), e);
			}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Part part = request.getPart("image");
		try {
			dao.saveStudentData(id, name, part);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/day6.2_1/students");
	}
}
