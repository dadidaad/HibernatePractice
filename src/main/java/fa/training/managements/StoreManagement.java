package fa.training.managements;

import java.math.BigDecimal;
import java.util.Arrays;

import fa.training.dao.BrandDao;
import fa.training.dao.ProductDao;
import fa.training.dao.impl.BrandDaoImpl;
import fa.training.dao.impl.ProductDaoImpl;
import fa.training.entities.Brand;
import fa.training.entities.Product;
import fa.training.utils.PrintTable;
import fa.training.utils.ValidateData;

public class StoreManagement {
	final static ValidateData vd = new ValidateData();

	public static void showMainMenu() {
		System.out.println("1. Brand management");
		System.out.println("2. Product management");
		System.out.println("3. Exit");
	}

	public static void showBrandMenu() {
		System.out.println("1. Add new brand without product");
		System.out.println("2. Add new brand with products");
		System.out.println("3. Delete the brands");
		System.out.println("4. List all brands");
		System.out.println("5. Find a specific brand");
		System.out.println("6. Return");
	}

	public static void showProductMenu() {
		System.out.println("1. Update an existing product");
		System.out.println("2. List all product");
		System.out.println("3. Find all products by brand id");
		System.out.println("4. Find a specific product");
		System.out.println("5. Delete a product");
		System.out.println("5. Return");
	}

	public static int selectChoice() {
		return vd.inputInt("Choose your option: ");
	}

	public static char selectYesNo() {
		System.out.print("Do you want to continue(y/n): ");
		return vd.inputYesNo();
	}

	public static void notiPauseScreen() {
		System.out.print("Enter to continue!!");
		vd.pauseScreen();
	}

	public static void brandMenu() {
		BrandDao brandDao = new BrandDaoImpl();
		while (true) {
			showBrandMenu();
			int choice = selectChoice();
			if (choice == 6) {
				break;
			}
			switch (choice) {
				case 1:
					String brandName = vd.inputString("Enter brand name: ", true);
					Boolean brandStatus = vd.inputString("Enter status: ", true).equals("true");
					Brand newBrand = new Brand(brandName, brandStatus);
					System.out.println(brandDao.save(newBrand) ? "Add successfully" : "Add failed");
					break;
				case 2:
					String brandNameWithProduct = vd.inputString("Enter brand name: ", true);
					Boolean brandStatusWithProduct = vd.inputString("Enter status: ", true).equals("true");
					Brand newBrandWithProducts = new Brand(brandNameWithProduct, brandStatusWithProduct);
					Product[] products = new Product[3];
					for (int i = 0; i < products.length; i++) {
						String newProductId = vd.inputString("Enter product id: ", true);
						String newProductName = vd.inputString("Enter product name: ", true);
						String newModelYear = vd.inputString("Enter model year", true);
						BigDecimal newMoney = BigDecimal.valueOf(vd.inputDouble("Enter money: "));
						products[i] = new Product(newProductId, newProductName, newModelYear, newMoney, newBrandWithProducts);
					}
					newBrandWithProducts.setProducts(Arrays.asList(products));
					System.out.println(brandDao.save(newBrandWithProducts) ? "Add successfully" : "Add failed");
					break;
				case 3:
					int brandIdtoDelete = vd.inputInt("Enter brand id to delete: ");
					System.out.println(brandDao.delete(brandIdtoDelete) ? "Delete successfully" : "Delete failed");
					break;
				case 4:
					PrintTable.printBrandTable(brandDao.getAll());
					break;
				case 5:
					int brandIdToSearch = vd.inputInt("Enter brand id to search: ");
					PrintTable.printBrandTable(Arrays.asList(brandDao.getById(brandIdToSearch)));
					break;
				case 6:
					break;
				default:
					break;
			}
		}
	}

	public static void productMenu() {
		ProductDao productDao = new ProductDaoImpl();
		while (true) {
			showProductMenu();
			int choice = selectChoice();
			if (choice == 6) {
				break;
			}
			switch (choice) {
				case 1:
					String productIdtoUpdate = vd.inputString("Enter product id to find: ", true);
					Product productToUpdate = productDao.getById(productIdtoUpdate);
					if (productIdtoUpdate != null) {
						String productNameToUpdate = vd.inputString("Enter product name to update: ", true);
						String productModelYearToUpdate = vd.inputString("Enter model year: ", true);
						BigDecimal productMoneyToUpdate = BigDecimal.valueOf(vd.inputDouble("Enter price: "));
						Brand brandToUpdate = null;
						while (brandToUpdate == null) {
							int brandIdToUpdate = vd.inputInt("Enter brand id: ");
							brandToUpdate = new BrandDaoImpl().getById(brandIdToUpdate);
						}
						productToUpdate.setProductName(productNameToUpdate);
						productToUpdate.setModelYear(productModelYearToUpdate);
						productToUpdate.setMoney(productMoneyToUpdate);
						productToUpdate.setBrand(brandToUpdate);
						productDao.update(productToUpdate);
					}
					break;
				case 2:
					PrintTable.printProductTable(productDao.getAll());
					break;
				case 3:
					Brand brandToSearch = null;
					while (brandToSearch == null) {
						int brandIdToSearch = vd.inputInt("Enter brand id: ");
						brandToSearch = new BrandDaoImpl().getById(brandIdToSearch);
					}
					PrintTable.printProductTable(productDao.getByBrandId(brandToSearch.getBrandId()));
					break;
				case 4:
					String productIdToSearch = vd.inputString("Enter product id to search: ", true);
					Product productToSearch = productDao.getById(productIdToSearch);
					if (productToSearch != null) {
						PrintTable.printProductTable(Arrays.asList(productToSearch));
					}
					break;
				case 5:
					String productTodelete = vd.inputString("Enter product id to delete", true);
					productDao.delete(productTodelete);
					break;
				default:
					break;
			}
		}
	}
	public static void program() {
		while(true) {
			showMainMenu();
			int choice = selectChoice();
			if(choice == 3) {
				break;
			}
			switch (choice) {
				case 1:
					brandMenu();
					break;
				case 2:
					productMenu();
					break;
				case 3:
					break;
				default:
					break;
			}
		}
	}
	public static void main(String[] args) {
		program();
	}
}
