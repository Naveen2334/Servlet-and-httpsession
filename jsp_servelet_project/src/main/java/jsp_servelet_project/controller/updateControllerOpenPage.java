package jsp_servelet_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_servelet_project.dao.ProductDao;
import jsp_servelet_project.dto.ProductDto;

public class updateControllerOpenPage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		int id = Integer.parseInt(req.getParameter(""));
		ProductDto productDto = productDao.get
		
	}
	
	
		
		
		
	
		
		
		
		
	

}
