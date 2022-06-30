package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")
public class Brand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brandId;

	@Column(name = "BrandName", nullable = false)
	private String brandName;

	@Column(name = "Status", nullable = true)
	private boolean status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BrandId")
	private List<Product> products;

	public Brand() {
		products = new ArrayList<Product>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Brand(String brandName, boolean status, List<Product> products) {
		super();
		this.brandName = brandName;
		this.status = status;
		this.products = products;
	}

	public Brand(int brandId, String brandName, boolean status, List<Product> products) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.status = status;
		this.products = products;
	}

	
	public Brand(String brandName, boolean status) {
		super();
		this.brandName = brandName;
		this.status = status;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
