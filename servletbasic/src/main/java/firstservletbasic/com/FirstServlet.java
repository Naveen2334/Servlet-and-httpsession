package firstservletbasic.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet implements Servlet {
	ServletConfig con;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("initmaethod");
		con=config;
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		
		System.out.println("getServletConfig mwthod");
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" service method");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("welcome to servlet");
		out.print("Today"+new Date(0).toString());
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("my  servlet ");
		return "my first servlet program";
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy method");
		
	}
	

}
