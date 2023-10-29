import java.util.Scanner;

public class Aims {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		showMenu();
	}

	public static void showMenu() {
		boolean endMenu = false;
		int option;

		while (!endMenu) {
			System.out.println("-----------------------");
			System.out.println("Aims Menu:");
			System.out.println("1. Customer Menu.");
			System.out.println("2. Store Manager Menu.");
			System.out.println("3. Exit.");
			System.out.println("-----------------------");
			System.out.print("Choose an option: ");
			option = input.nextInt();

			switch (option) {
			case 1:
				showCustomerMenu();
				break;

			case 2:
				storeManagerMenu();
				break;

			case 3:
				endMenu = true;
				System.out.println(" --- Exit AIMS ---");
				break;

			default:
				break;
			}

		}
	}

	public static void showCustomerMenu() {
		boolean endCustomerMenu = false;
		int option;

		while (!endCustomerMenu) {
			System.out.println("---------------------");
			System.out.println("1. See all the DVDs. ");
			System.out.println("2. Search a DVD. ");
			System.out.println("3. Add a DVD to the cart. ");
			System.out.println("4. See current cart.");
			System.out.println("5. Sort the DVDs in current cart.");
			System.out.println("6. Exit Customer Menu.");
			System.out.println("---------------------");

			System.out.print("Choose an option: ");
			option = input.nextInt();

			switch (option) {
			case 1:
				DigitalVideoDisc.showAllDVDs();
				break;

			case 2:
				searchMenu();
				break;

			case 3:
				break;
				
			case 4:
				break;
				
			case 5:
				break;
				
			case 6:
				endCustomerMenu = true;
				break;

			default:
				break;
			}

		}
	}

	public static void searchMenu() {
		int option;
		System.out.println("-----------------------");
		System.out.println("1. Search by title.");
		System.out.println("2. Search by category.");
		System.out.println("3. Search by price.");
		System.out.println("-----------------------");
		System.out.println("Choose an option: ");
		option = input.nextInt();
		switch (option) {
		case 1:
			String inputString = input.nextLine();
			DigitalVideoDisc.searchDVD(inputString, 1);
			break;

		case 2:
			String inputString = input.nextLine();
			DigitalVideoDisc.searchDVD(inputString, 2);
			break;

		case 3:

			break;
		default:
			break;
		}
	}
	
	public static void storeManagerMenu() {
		int option;
		boolean endStoreMenu = false;
		
		while (!endStoreMenu) {
			System.out.println("-----------------");
			System.out.println("1. Add a DVD.");
			System.out.println("2. Remove a DVD.");
			System.out.println("3. Login");
			System.out.println("4. Exit");
			System.out.println("-----------------");
			System.out.println("Choose an option: ");
			option = input.nextInt();
			
			switch (option) {
			case 1:
				
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				endStoreMenu = true;
				break;
				
			default:
				break;
			}
		}
	}
}




























