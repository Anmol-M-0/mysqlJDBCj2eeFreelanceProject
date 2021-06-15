package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentDao;
import dao.StudentDaoImpl;
import pojos.Student;

@WebServlet("/students")
public class GetViewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IStudentDao dao;
    public GetViewServlet() {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
         
        try {
            List<Student> students= dao.fetchStudents();
            request.setAttribute("students", students);
            String page = "/index.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);              
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
         
    }
}