package fa.training.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ValidateData {
	static final Scanner sc = new Scanner(System.in);

	public String inputString(String message, boolean checkBlank) {
		while (true) {
			try {
				System.out.print(message);
				String input = sc.nextLine();
				if (checkBlank && (input == null || input.replaceAll("[ ]+", "").equals(""))) {
					System.out.println("Can not input blank value");
					continue;
				}
				return input;
			} catch (Exception e) {
				continue;
			}
		}
	}

	public int inputInt(String message) {
		while (true) {
			try {
				System.out.print(message);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Invalid data");
				continue;
			}
		}
	}

	public LocalDate inputDate(String message) {
		while (true) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf.setLenient(false);
			System.out.print(message);
			String inputDate = sc.nextLine();
			try {
				java.util.Date parsed = sdf.parse(inputDate); // parse to format MM/dd/yyyy
				java.sql.Date dateConvert = new java.sql.Date(parsed.getTime()); // try to convert to sql Date
				return dateConvert.toLocalDate();
			} catch (Exception e) {
				System.err.println(inputDate + " is not a valid Date");
				continue;
			}
		}
	}

	public char inputYesNo() {
		while (true) {
			char choice = sc.next(".").toLowerCase().charAt(0);
			if (choice == 'y' || choice == 'n') {
				sc.nextLine();
				return choice;
			}
			System.err.println("Y/y or N/n only");
		}
	}

	public char inputChar(String message) {
		while (true) {
			System.out.print(message);
			char choice = sc.next(".").toLowerCase().charAt(0);
			if (choice == 'f' || choice == 'm') {
				sc.nextLine();
				return choice;
			}
		}
	}

	public String pauseScreen() {
		return sc.nextLine();
	}

	public boolean checkFromDateAndToDate(LocalDate fromDate, LocalDate toDate) {
		if (fromDate.isAfter(toDate)) {
			return true;
		}
		return false;
	}
	public double inputDouble(String message) {
		while(true) {
			try {
				System.out.println(message);
				return Double.parseDouble(sc.nextLine());
			}catch(NumberFormatException e) {
				System.err.println("Invalid data");
				continue;
			}
		}
	}
}
