package fa.training.utils;

import java.util.ArrayList;
import java.util.List;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.ColumnData;

import fa.training.entities.Brand;
import fa.training.entities.Product;

public class PrintTable {

	public static void printBrandTable(List<Brand> brands) {
		List<ColumnData<Brand>> listData = new ArrayList<ColumnData<Brand>>();
		listData.add(new Column().header("Brand ID").with(Brand -> Integer.toString(Brand.getBrandId())));
		listData.add(new Column().header("Brand Name").with(Brand::getBrandName));
		listData.add(new Column().header("Status").with(Brand -> Brand.isStatus() ? "Active" : "Inactive"));
		System.out.println(AsciiTable.getTable(brands, listData));
	}
	
	public static void printProductTable(List<Product> products) {
		List<ColumnData<Product>> listData = new ArrayList<ColumnData<Product>>();
		listData.add(new Column().header("Product ID").with(Product::getProductId));
		listData.add(new Column().header("Product Name").with(Product::getProductName));
		listData.add(new Column().header("Model Year").with(Product::getModelYear));
		listData.add(new Column().header("List Price").with(Product -> Product.getMoney().toString()));
		listData.add(new Column().header("Brand").with(Product -> Product.getBrand().getBrandName()));
		System.out.println(AsciiTable.getTable(products, listData));
	}
}
