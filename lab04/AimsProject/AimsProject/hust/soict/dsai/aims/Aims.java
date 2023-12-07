package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Aims {

	public static void main(String[] args) {

		
		List<Media> mediae = new ArrayList<Media>();
		
		Book book = new Book(1, "I love Java", "Programming", 1.5f);
		DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(1, "Tiger King", "Animal", 2.0f);
		
		mediae.add(book);
		mediae.add(digitalVideoDisc);
		
		for (Media media : mediae) {
			System.out.println(media);
		}
		
		
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

}
