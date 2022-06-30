package fa.training.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	private String productId;

	@Column(name = "ProductName")
	private String productName;

	@Column(name = "ModelYear")
	private String modelYear;

	@Column(name = "ListPrice")
	private BigDecimal money;

	@ManyToOne
	@JoinColumn(name = "BrandId", nullable = true)
	private Brand brand;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, String modelYear, BigDecimal money, Brand brand) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.modelYear = modelYear;
		this.money = money;
		this.brand = brand;
	}

	public Product(String productName, String modelYear, BigDecimal money, Brand brand) {
		super();
		this.productName = productName;
		this.modelYear = modelYear;
		this.money = money;
		this.brand = brand;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
