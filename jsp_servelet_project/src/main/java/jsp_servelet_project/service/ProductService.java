package jsp_servelet_project.service;

import java.sql.SQLException;

import jsp_servelet_project.dao.ProductDao;
import jsp_servelet_project.dto.ProductDto;

public class ProductService {
	ProductDao productDao = new ProductDao();
	public ProductDto saveProduct(ProductDto product) throws SQLException {
		return productDao.insertRecord(product);
		
	}

}
