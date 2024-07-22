package studentwithjspm12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjspm12.dao.StudentDao;
import studentwithjspm12.dto.Student;

public class SignUpServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String address=req.getParameter("address");
	long phone=Long.parseLong(req.getParameter("phone"));
	double fees=Double.parseDouble(getServletContext().getInitParameter("fees"));
	
	Student student=new Student();
	student.setAddress(address);
	student.setEmail(email);
	student.setFees(fees);
	student.setName(name);
	student.setPassword(password);
	student.setPhone(phone);
	
	StudentDao dao=new StudentDao();
	dao.saveStudent(student);
	req.setAttribute("message", "SIGNEDUPSUCCESSFULLY PLEASE LOGIN");
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
	dispatcher.forward(req, resp);
	
	
}
}
