import java.util.Scanner;

public class Aims {
	public static Cart customerCart = new Cart();
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		// Make the store not empty
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spider-Man", "Action", 20.99f);
		DigitalVideoDisc.allDVDs.add(dvd1);
		DigitalVideoDisc.allDVDs.add(dvd2);
		DigitalVideoDisc.allDVDs.add(dvd3);
		DigitalVideoDisc.allDVDs.add(dvd4);
		DigitalVideoDisc.allDVDs.add(dvd5);

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
			input.nextLine();


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
			System.out.println("4. Remove a DVD from the cart. ");
			System.out.println("5. See current cart.");
			System.out.println("6. Sort the DVDs in current cart.");
			System.out.println("7. Exit Customer Menu.");
			System.out.println("---------------------");

			System.out.print("Choose an option: ");
			option = input.nextInt();
			input.nextLine();
			
			switch (option) {
			case 1:
				DigitalVideoDisc.showAllDVDs();
				break;

			case 2:
				searchMenu();
				break;

			case 3:
				System.out.println("Input title to add: ");
				String titleDVDtoAddString = input.nextLine();
				customerCart.addToCart(DigitalVideoDisc.searchDVD(titleDVDtoAddString));
				break;

			case 4:
				System.out.println("Input title to remove: ");
				String titleDVDtoRemoveString = input.nextLine();
				customerCart.removeToCart(customerCart.searchDVDinCart(titleDVDtoRemoveString));
				break;

			case 5:
				customerCart.showDVDinCart();
				break;

			case 6:
				System.out.println("1. Sort by cost");
				System.out.println("2. Sort by title");
				System.out.print("Input option: ");
				int choice = input.nextInt();
				customerCart.sortTheCart(choice);
				break;

			case 7:
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
		System.out.print("Choose an option: ");
		option = input.nextInt();
		input.nextLine();

		switch (option) {
		case 1:
			System.out.println("Input: ");
			String inputString_1 = input.nextLine();
			DigitalVideoDisc.searchDVD(inputString_1, 1);
			break;

		case 2:
			System.out.println("Input: ");
			String inputString_2 = input.nextLine();
			DigitalVideoDisc.searchDVD(inputString_2, 2);
			break;

		case 3:
			Double price_less, price_more;
			System.out.print("Min price: ");
			price_less = input.nextDouble();
			System.out.print("Max price: ");
			price_more = input.nextDouble();
			DigitalVideoDisc.searchDVD(price_less, price_more);
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
			System.out.println("3. See all DVDs. ");
			System.out.println("4. Login");
			System.out.println("5. Exit");
			System.out.println("-----------------");
			System.out.println("Choose an option: ");
			option = input.nextInt();
			input.nextLine();


			switch (option) {
			case 1:
				StoreManager.addDVD();
				break;

			case 2:
				StoreManager.removeDVD();
				break;
				
			case 3:
				StoreManager.seeAllDVDs();
				break;

			case 4:
				StoreManager.loginStore();
				break;

			case 5:
				endStoreMenu = true;
				break;

			default:
				break;
			}
		}
	}
}
