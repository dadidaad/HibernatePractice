package fa.training.dao;

import java.util.List;

import fa.training.entities.Brand;

public interface BrandDao {
	public boolean save(Brand brand);

	public boolean delete(int id);

	public boolean update(Brand brand);

	public List<Brand> getAll();

	public Brand getById(int id);

}
