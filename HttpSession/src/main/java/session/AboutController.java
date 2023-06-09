package session;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AboutController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 HttpSession httpSession= req.getSession();
	 
	 if(httpSession.getAttribute("myName")!=null) {
		 RequestDispatcher dispatcher = req.getRequestDispatcher("about.jsp");
		 dispatcher.forward(req, resp);
	 }
	 else {
		 RequestDispatcher dispatcher= req.getRequestDispatcher("login-form.jsp");
		 dispatcher.include(req, resp);
	 }
	}
}
