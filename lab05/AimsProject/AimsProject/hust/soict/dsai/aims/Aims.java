package hust.soict.dsai.aims;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
//		// Create a new cart
//		Cart anOrder = new Cart();
//		// Create a new dvd object and add them to the cart
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "", 90, 18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);
//		
//		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin", "Animation", "", 90, 18.99f);
//		anOrder.addDigitalVideoDisc(dvd4);
//		
//		// Remove dvd from the cart
//		anOrder.removeDigitalVideoDisc(dvd3);
//		DigitalVideoDisc dvdList[] = {dvd1, dvd2, dvd3, dvd4};
//		anOrder.addDigitalVideoDisc(dvdList);
//		anOrder.addDigitalVideoDisc(dvd4, dvd2);
//		anOrder.addDigitalVideoDisc(dvd1, 4);
//		anOrder.addDigitalVideoDisc(dvd1, 4);
////		anOrder.addDigitalVideoDisc(dvd1, 4);
////		anOrder.addDigitalVideoDisc(dvd1, 4);
//		
//		// print total cost of the items in the cart
//		System.out.println("Total Cost is: ");
//		System.out.println(anOrder.totalCost());
//		anOrder.print();
//		anOrder.sortByCost();
//		anOrder.sortByTitle();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("King Kong", "Action", 20.99f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Spider-Man", "Action", 20.99f);
		Store.addMedia(dvd1);
		Store.addMedia(dvd2);
		Store.addMedia(dvd3);
		Store.addMedia(dvd4);
		Store.addMedia(dvd5);
		
		boolean stopMenu = false;
		boolean stopStoreMenu = false;
		boolean stopUpdateStore = false;
		boolean stopCartMenu = false;
		int menuOption, storeMenuOption, updateStoreOption, cartMenuOption, filterCartOption, sortCartOption;
		String tempStr1, tempStr2;
		float tempFloat;
		Cart anOrder = new Cart();
		Scanner sc = new Scanner(System.in);
		DigitalVideoDisc tempDVD = null;
		/*
		 * AIMS Application
		 * The menu consists 3 parts: Store menu, Update store menu, Cart menu
		 * 	I. Store menu consists:
		 * 		1. See dvd's details
		 * 		2. Add a dvd to the cart
		 * 		3. Go to cart menu
		 * 		4. Go back to menu
		 * 	II. Update store menu consists:
		 * 		1. Add a dvd to the store
		 * 		2. Remove a dvd from the store
		 * 		3. Go back to menu
		 * 	III. Cart menu consist:
		 * 		1. Filter dvd(s) in the cart (by id/title)
		 * 		2. Sort dvd(s) in the cart (by title/cost)
		 * 		3. Remove dvd(s) from the cart
		 * 		4. Place an order
		 * 		5. Go back to menu
		 */
		while (!stopMenu) {
			Aims.showMenu();
			menuOption = Aims.input(3);
			stopStoreMenu = false;
			stopUpdateStore = false;
			stopCartMenu = false;
			/*
			 * Store options
			 */
			if (menuOption == 1) {
				while (!stopStoreMenu) {
					Aims.storeMenu();
					storeMenuOption = Aims.input(3);
					// See dvd's details
					if (storeMenuOption == 1) {
						System.out.println("----------------------------------------------------------------------------------");
						System.out.println("Please enter the title of the dvd:");
						tempDVD = (DigitalVideoDisc) Store.getMediabyTitle(sc.nextLine());
						if (tempDVD == null) {
							System.out.println("There's no matching dvd in the store!");
						}
						else {
							System.out.println(tempDVD.toString());
						}
						Aims.promptEnterKey();
					}
					// Add a dvd to the cart
					else if (storeMenuOption == 2) {
						Store.display();
						System.out.println("----------------------------------------------------------------------------------");
						System.out.println("Please enter the title of the dvd to add to the cart:");
						tempDVD =  (DigitalVideoDisc) Store.getMediabyTitle(sc.nextLine());
						if (tempDVD == null) {
							System.out.println("There's no matching dvd in the store!");
						}
						else {
							anOrder.addMedia(tempDVD);
						}
						Aims.promptEnterKey();
					}
					// Go to cart menu 
					else if (storeMenuOption == 3) {
						menuOption = 3;
						stopStoreMenu = true;
					}
					// Go back to menu
					else if (storeMenuOption == 0) {
						stopStoreMenu = true;
					}
				}
			}
			/*
			 * Update store options
			 */
			if (menuOption == 2) {
				while (!stopUpdateStore) {
					Aims.updateStore();
					updateStoreOption = Aims.input(2);
					// Add a dvd to the store
					if (updateStoreOption == 1) {
						System.out.println("Enter the title");
						tempStr1 = sc.nextLine();
						System.out.println("Enter the category");
						tempStr2 = sc.nextLine();
						System.out.println("Enter the cost");
						tempFloat = sc.nextFloat(); sc.nextLine();
						Store.addMedia(new DigitalVideoDisc(tempStr1, tempStr2, tempFloat));
						Aims.promptEnterKey();
					}
					// Remove a dvd from the store
					else if (updateStoreOption == 2) {
						System.out.println("Please enter the title of the DVD that you want to remove from the store:");
						Store.removeMedia(tempDVD);
						Aims.promptEnterKey();
					}
					// Go back to menu
					else if (updateStoreOption == 0) {
						stopUpdateStore = true;
					}
				}
			}
			/*
			 * Cart options
			 */
			if (menuOption == 3) {
				while (!stopCartMenu) {
					Aims.cartMenu();
					cartMenuOption = Aims.input(4);
					// Filter dvd(s) in the cart
					if (cartMenuOption == 1) {
						Aims.filterCart();
						filterCartOption = Aims.input(2);
						// Filter by id
						if (filterCartOption == 1) {
							System.out.println("Please enter the ID of the DVD:");
							while (!sc.hasNextInt()) {
								System.out.println("Invalid number, please enter again!");
								sc.nextLine();
							}
							anOrder.searchByID(sc.nextInt());;
						}
						// Filter by title
						else if (filterCartOption == 2) {
							System.out.println("Please enter the title of the DVD:");
							anOrder.searchByTitle(sc.nextLine());
						}
						Aims.promptEnterKey();
					}
					// Sort dvd(s) in the cart
					else if (cartMenuOption == 2) {
						Aims.sortCart();
						sortCartOption = Aims.input(2);
						// Sort dvd(s) in the cart by title
						if (sortCartOption == 1) {
							anOrder.sortByTitle();
						}
						// Sort dvd(s) in the cart by cost
						else if (sortCartOption == 2) {
							anOrder.sortByCost();
						}
						Aims.promptEnterKey();
					}
					// Remove dvd(s) from the cart
					else if (cartMenuOption == 3) {
						System.out.println("Please enter the title of the DVD that you want to remove from the cart");
						String tempTitle = sc.nextLine();
						anOrder.removeMedia(new DigitalVideoDisc(tempTitle));
						Aims.promptEnterKey();
					}
					// Place an order
					else if (cartMenuOption == 4) {
						anOrder.printCart();
						System.out.println("Your order has been placed successfully!");
						menuOption = 0;
						stopCartMenu = true;
						anOrder = new Cart();
					}
					// Go back to menu
					else if (cartMenuOption == 0) {
						stopCartMenu = true;
					}
				}
			}
			if (menuOption == 0) {
				System.out.println("----------------------------------------------------------------------------------");
				System.out.println("--------------------------------Application closed--------------------------------");
				System.out.println("----------------------------------------------------------------------------------");
				stopMenu = true;
			}
		}
	}
	
	// Show all menu options
		public static void showMenu() {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
		
		// Show all store options
		public static void storeMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a DVD�s details");
			System.out.println("2. Add a DVD to cart");
			System.out.println("3. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
		}
		
		// Show all cart options
		public static void cartMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter DVDs in cart");
			System.out.println("2. Sort DVDs in cart");
			System.out.println("3. Remove DVD from cart");
			System.out.println("4. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
		}
		
		// Show all update store options
		public static void updateStore() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add DVD(s) to the store");
			System.out.println("2. Remove DVD(s) from the store");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		// Show all filter cart options
		public static void filterCart() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter DVD(s) by id");
			System.out.println("2. Filter DVD(s) by title");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
		}
		
		// Show all sort cart options
			public static void sortCart() {
				System.out.println("Options: ");
				System.out.println("--------------------------------");
				System.out.println("1. Sort DVD(s) by title");
				System.out.println("2. Sort DVD(s) by cost");
				System.out.println("0. Back");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1-2");
			}
		
		// Take input from user 
		public static int input(int optionNum) {
			Scanner sc = new Scanner(System.in);
			int option = 0;
			boolean checkMenuOption = false;
			while(!checkMenuOption) {
				try {
					option = sc.nextInt();
			        if(option >= 0 && option <= optionNum){
			        	checkMenuOption = true;
			        } 
			        else {
			        	System.out.println("Please type a number from 0 to " + optionNum);
			        }
			    } 
				catch (InputMismatchException e) {
			        System.out.println("Not a valid number!");
			        sc.next();
			    }
		     }
			return option;
		}
		
		// Enter to continue
		public static void promptEnterKey(){
		    System.out.println("Press \"ENTER\" to continue...");
		    try {
		        System.in.read();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
}
