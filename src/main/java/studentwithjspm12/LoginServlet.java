package studentwithjspm12;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjspm12.dao.StudentDao;
import studentwithjspm12.dto.Student;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	
	
	StudentDao dao=new StudentDao();
	List<Student> students=dao.getAllStudents();
	boolean value=false;
	String dbPassword=null;
	for(Student student:students) {
		if(email.equals(student.getEmail())) {
//			that student is present with that email
			value=true;
			dbPassword=student.getPassword();
			break;
		}
	}
	
	if(value) {
//		email is present
		if(dbPassword.equals(password)) {
//			i need to send a list of students 
//			how to send
			req.setAttribute("list", students);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}else {
			req.setAttribute("message", "INVALID PASSWORD!!!! LOGIN FAILURE");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
	}else {
		
		req.setAttribute("message", "INVALID EMAILLL!!!! LOGIN FAILURE");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
	
	
	
	
	
	
}
}
