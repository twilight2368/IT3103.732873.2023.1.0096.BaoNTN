package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static Scanner inputScanner = new Scanner(System.in);
	public static Cart customerCart = new Cart();

	public static void main(String[] args) {

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Sci-fi", "George Lucas", 87, 24.95f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spider-man", "Action", 20f);
		
		Store.addMedia(dvd1);
		Store.addMedia(dvd2);
		Store.addMedia(dvd3);
		Store.addMedia(dvd4);
		
		showMenuAims();
		inputScanner.close();
	}

	public static void showMenuAims() {
		boolean endMenu = false;
		int option;
		while (!endMenu) {
			showMenu();
			option = inputScanner.nextInt();
			switch (option) {
			case 1:
				storeMenuAims();
				break;
			case 2:
				updateStoreAims();
				break;
			case 3:
				customerCart.printCart();
				cartMenuAims();
				break;
			case 0:
				endMenu = true;
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		}
	}

	public static void storeMenuAims() {
		boolean endMenu = false;
		int option;
		int option_see_media;

		while (!endMenu) {
			storeMenu();
			option = inputScanner.nextInt();
		
			switch (option) {
			case 1:
				System.out.println("--------------------");
				System.out.println("1. Search by ID");
				System.out.println("2. Search by title");
				System.out.println("--------------------");
				System.out.println("Option:");
				option_see_media = inputScanner.nextInt();
				

				if (option_see_media == 1) {
					System.out.println("Input id: ");
					int id = inputScanner.nextInt();
					Media media = Store.getMediabyID(id);
					System.out.println(media);
					MediaMenuDetailsAims(media);

				} else if (option_see_media == 2) {
					inputScanner.nextLine();
					System.out.println("Input title:");
					String title = inputScanner.nextLine();
					Media media = Store.getMediabyTitle(title);
					System.out.println(media);
					MediaMenuDetailsAims(media);
				} else {
					System.out.println("Invalid input");
				}

				break;
			case 2:
				System.out.println("--------------------");
				System.out.println("1. Add by ID");
				System.out.println("2. Add by title");
				System.out.println("--------------------");
				System.out.println("Option:");
				option_see_media = inputScanner.nextInt();

				if (option_see_media == 1) {
					System.out.println("Input: ");
					int id = inputScanner.nextInt();
					customerCart.addMedia(Store.getMediabyID(id));
				} else if (option_see_media == 2) {
					System.out.println("Input: ");
					String titleString = inputScanner.nextLine();
					customerCart.addMedia(Store.getMediabyTitle(titleString));
				} else {
					System.out.println("Invalid input");
				}

				break;
			case 3:
				System.out.println("--------------------");
				System.out.println("1. Choose by ID");
				System.out.println("2. Choose by title");
				System.out.println("--------------------");
				System.out.println("Option:");
				option_see_media = inputScanner.nextInt();

				if (option_see_media == 1) {
					int option_filter;
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
				} else if (option_see_media == 2) {
					String option_filter_titleString;
					System.out.println("Input id: ");
					option_filter_titleString = inputScanner.nextLine();
					Media media_to_play = customerCart.searchByIDreturnMedia(option_filter_titleString);
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
				} else {
					System.out.println("Invalid input");
				}

				break;
			case 4:
				cartMenuAims();
				break;
			case 0:
				endMenu = true;
				break;
			default:
				System.out.println("Inavalid input");
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
			} else if (option_filter == 2) {
				int id = inputScanner.nextInt();
				customerCart.searchByID(id);
			} else {
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
			} else if (option_filter == 2) {
				customerCart.sortByCost();
			} else {
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
			System.out.println("Order is created -Empty the current cart");
			customerCart.removeAllMedia();
			break;
		case 0:
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}
	
	public static void MediaMenuDetailsAims(Media media) {
		int option;
		mediaDetailsMenu();
		option = inputScanner.nextInt();
		if (option == 1) {
			customerCart.addMedia(media);
		}else if (option == 2) {
			if (media != null) {
				try {
					DigitalVideoDisc dvd = (DigitalVideoDisc) media;
					dvd.play();
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					CompactDisc cp = (CompactDisc) media;
					cp.play();
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					Book bk = (Book) media;
					bk.play();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}else if (option == 0) {
			return;
		}else {
			System.out.println("Invalid input");
			return;
		}
	}

	public static void updateStoreAims() {
		int option;
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("--------------------------------");
		System.out.println("Option: ");

		option = inputScanner.nextInt();

		if (option == 1) {
			int option_media;
			System.out.println("--------------------------------");
			System.out.println("1. DigitalVideoDisc");
			System.out.println("2. Book");
			System.out.println("3. CompactDisc");
			System.out.println("--------------------------------");
			System.out.println("Option: ");
			option_media = inputScanner.nextInt();
			
			switch (option_media) {
			case 1:
				addDVDMenu();
				break;
			case 2:
				addBookMenu();
				break;
			case 3:
				System.out.println("This function is still in development");
				break;
				
			default:
				System.out.println("Invalid input");
				break;
			}

		} else if (option == 2) {
			System.out.println("Input id: ");
			int id = inputScanner.nextInt();
			Store.removeMedia(Store.getMediabyID(id));
		} else {
			System.out.println("Invalid input");
		}
	}
	public static void addDVDMenu() {
		String titleString;
		String categoryString;
		float cost;
		String directorNameString;
		int length;
		System.out.println("-----------------------------");
		
		System.out.println("Input title: ");
		titleString = inputScanner.nextLine();
		System.out.println("Input category: ");
		categoryString = inputScanner.nextLine();
		System.out.println("Input director: ");
		directorNameString = inputScanner.nextLine();
		System.out.println("Input cost:");
		cost = inputScanner.nextFloat();
		System.out.println("Input length:");
		length = inputScanner.nextInt();
		
		System.out.println("------------------------------");
		DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(titleString, categoryString, directorNameString, length, cost);
		Store.addMedia(digitalVideoDisc);
	}
	
	public static void addBookMenu() {
		String titleString;
		String categoryString;
		float cost;
		System.out.println("-----------------------");
		System.out.println("Input title: ");
		titleString = inputScanner.nextLine();
		System.out.println("Input category: ");
		categoryString = inputScanner.nextLine();
		System.out.println("Input cost:");
		cost = inputScanner.nextFloat();
		System.out.println("-----------------------");
		Book book = new Book(titleString, categoryString, cost);
		Store.addMedia(book);
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
