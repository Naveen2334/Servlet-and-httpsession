package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession httpSession = req.getSession();
		 String name =  req.getParameter("username");
		 String email = req.getParameter("email");
	      PrintWriter printWriter = resp.getWriter();
	      printWriter.write("<html><body>");
	      if((name.equalsIgnoreCase("root"))&&(email.equalsIgnoreCase("root@gmail.com"))){
	    	httpSession.setAttribute("myName",name);
	    	printWriter.write("<h1 style = 'color:green'>login-successfully</h1>");
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("profile-page.jsp");
	    	dispatcher.include(req, resp);
	      }
	      else {
	    	  printWriter.write("<h1 style = 'color:red'>check your user and email</h1>");
	    	  RequestDispatcher dispatcher = req.getRequestDispatcher("login-form.jsp");
	    	  dispatcher.include(req, resp); 
	     }
		 printWriter.write("</body></html>");
	}
}
