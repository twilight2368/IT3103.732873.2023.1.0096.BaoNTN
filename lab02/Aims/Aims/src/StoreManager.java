import java.util.Scanner;

public class StoreManager {
	private static final String PASSWORD = "123123";
	private static boolean login = false;
	
	//Login to the store
	public static void loginStore() {
		Scanner inputScanner = new Scanner(System.in);
		System.out.print("Input password: ");
		String inputPassword = inputScanner.nextLine();
		if (inputPassword.equals(PASSWORD)) {
			login = true;
			System.out.println("Login successfully");
		} else {
			System.out.println("Wrong password");
		}
	}
	
	//Show all DVDs in the store
	public static void seeAllDVDs() {
		DigitalVideoDisc.showAllDVDs();
	}
	
	//Add DVD to the store
	public static void addDVD() {
		if (!login) {
			System.out.println("You need to login");
			return;
		}

		Scanner inScanner = new Scanner(System.in);
		String titleString, categoryString, directorString;
		int length;
		float cost;

		System.out.println("Input title: ");
		titleString = inScanner.nextLine();
		System.out.println("Input category: ");
		categoryString = inScanner.nextLine();
		System.out.println("Input director: ");
		directorString = inScanner.nextLine();
		System.out.println("Input length: ");
		length = inScanner.nextInt();
		inScanner.nextLine();
		System.out.println("Input cost: ");
		cost = inScanner.nextFloat();
		inScanner.nextLine();

		DigitalVideoDisc newDisc = new DigitalVideoDisc(titleString, categoryString, directorString, length, cost);
		DigitalVideoDisc.allDVDs.add(newDisc);
		System.out.println("Add DVD successfully");
	}
	
	//Remove DVD from the store
	public static void removeDVD() {
		if (!login) {
			System.out.println("You need to login");
			return;
		}
		System.out.println("Input title: ");
		Scanner inScanner = new Scanner(System.in);
		String titleString = inScanner.nextLine();
		DigitalVideoDisc removeDVD = DigitalVideoDisc.searchDVD(titleString);

		if (removeDVD != null) {
			DigitalVideoDisc.allDVDs.remove(removeDVD);
			System.out.println("Remove DVD successfully");
		} else {
			System.out.println("DVD doesn't exist. ");
		}
	}

}
