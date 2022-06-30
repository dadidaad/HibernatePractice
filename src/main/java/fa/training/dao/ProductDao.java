package fa.training.dao;

import java.util.List;

import fa.training.entities.Product;

public interface ProductDao {
	public boolean update(Product product);
	
	public boolean save(Product product);
	
	public boolean delete(String id);
	
	public Product getById(String id);
	
	public List<Product> getAll();
	
	public List<Product> getByBrandId(int brandId);
}
