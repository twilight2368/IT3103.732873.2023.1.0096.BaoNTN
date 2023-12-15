package hust.soict.dsai.test.cart;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		cart.addMedia(dvd3);
		
		//Test the print method 
		cart.printCart();
		
		//To-do: Test the search methods 
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.print("Nhap title dvd can tim: ");
		String testTitle = inputScanner.nextLine();
		cart.searchByTitle(testTitle);
		
		System.out.print("Nhap ID can tim: ");
		int idTest = inputScanner.nextInt();
		cart.searchByID(idTest);
		
		
	}

}
