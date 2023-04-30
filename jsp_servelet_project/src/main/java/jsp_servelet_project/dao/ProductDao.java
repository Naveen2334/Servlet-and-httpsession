package jsp_servelet_project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.sasl.Sasl;

import jsp_servelet_project.dto.ProductDto;

public class ProductDao<Product> {
	public ProductDto insertRecord(ProductDto product)
	{
		Connection connection =  ProductConnection.getConnection();
		
		
		
		String insert = "Insert into product values(?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(insert);
		
		preparedStatement.setInt(1, product.getIdproduct());
		preparedStatement.setString(2, product.getProquality());
		preparedStatement.setDouble(3,product.getProprice());
		preparedStatement.execute();
		return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
			
		}
	
public List <ProductDto> displayAll(){
	Connection connection = ProductConnection.getConnection();
	String display = "select * from product";
	List<ProductDto> products = new ArrayList<>();
	return products;

	
}
}

