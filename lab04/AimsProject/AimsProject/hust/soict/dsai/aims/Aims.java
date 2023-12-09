package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Aims {
	public static Scanner inputScanner = new Scanner(System.in);
	public static Cart customerCart = new Cart();
	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Cart anOrder = new Cart();
//		//anOrder.addDigitalVideoDisc(null);
//		
//		
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);
//		
//		System.out.println("Total cost is: ");
//		System.out.println(anOrder.totalCost());
//		
//		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider-man", "Action",  20f);
//		anOrder.addDigitalVideoDisc(dvd4);
//		anOrder.removeDigitalVideoDisc(dvd4);	

	}

	public static void showMenuAims() {
		boolean endMenu = false;
		int option;
		while (!endMenu) {
			showMenu();
			option = inputScanner.nextInt();
			inputScanner.nextInt();

			switch (option) {
			case 1:
				storeMenuAims();
				break;
			case 2:

				break;
			case 3:

				break;
			case 0:

				break;
			default:
				break;
			}
		}
	}

	public static void storeMenuAims() {
		boolean endMenu = false;
		int option;

		while (!endMenu) {
			storeMenu();
			option = inputScanner.nextInt();
			inputScanner.nextInt();

			switch (option) {
			case 1:
				
				break;
			case 2:
				break;
			case 3:

				break;
			case 4:
				
				break;
			case 0:
				break;
			default:
				break;
			}
		}

	}
	
	public static void cartMenuAims() {
		int option;
		int option_filter;
		customerCart.printCart();
		cartMenu();
		option = inputScanner.nextInt();
		inputScanner.nextInt();
		
		switch (option) {
		case 1:
			System.out.println("--------------------");
			System.out.println("1.Search by title.");
			System.out.println("2.Search by ID.");
			System.out.println("--------------------");
			System.out.println("Option:");
			option_filter = inputScanner.nextInt();
			inputScanner.nextInt();
			if (option_filter == 1) {
				String title = inputScanner.nextLine();
				customerCart.searchByTitle(title);
			} else if(option_filter == 2) {
				int id = inputScanner.nextInt();
				customerCart.searchByID(id);
			}else {
				System.out.println("Invalid input");
			}	
			break;
		case 2:
			System.out.println("--------------------");
			System.out.println("1.Sort by title.");
			System.out.println("2.Sort by cost.");
			System.out.println("--------------------");
			System.out.println("Option:");
			option_filter = inputScanner.nextInt();
			inputScanner.nextInt();
			if (option_filter == 1) {
				customerCart.sortByTitle();
			} else if(option_filter == 2) {
				customerCart.sortByCost();
			}else {
				System.out.println("Invalid input");
			}
			break;
		case 3:
			System.out.println("Input id: ");
			option_filter = inputScanner.nextInt();
			inputScanner.nextInt();
			Media media = customerCart.searchByIDreturnMedia(option_filter);
			customerCart.removeMedia(media);
			break;
		case 4:
			System.out.println("Input id: ");
			option_filter = inputScanner.nextInt();
			inputScanner.nextInt();
			Media media_to_play = customerCart.searchByIDreturnMedia(option_filter);
			if (media_to_play != null) {
				try {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media_to_play;
					dvd.play();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					CompactDisc cp = (CompactDisc) media_to_play;
					cp.play();
				} catch (Exception e) {
					// TODO: handle exception
				}
			
				try {
					Book bk = (Book) media_to_play;
					bk.play();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			break;
		case 5:
			System.out.println("Order is created -E mpty the current cart");
			customerCart.removeAllMedia();
			break;
		case 0:
			break;
		default:
			System.out.println("Invalis input");
			break;
		}
	}

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

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

}
