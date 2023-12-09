package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private List<Media> itemOrder = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemOrder.contains(media)) {
			System.out.println("The item already in list");
		}else {
			itemOrder.add(media);
			System.out.println("Added successfully");
		}
	}
	
	public void removeMedia(Media media) {
		if (!itemOrder.contains(media)) {
			System.out.println("The item not in list");
		}else {
			itemOrder.remove(media);
			System.out.println("Removed successfully");
		}
	}
	public float totalCost() {
		float cost = 0;
		for (Media media : itemOrder) {
			cost = cost + media.getCost();
		}
		return cost;
	}
	
	public void sortByCost() {
		Collections.sort(itemOrder, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void sortByTitle() {
		Collections.sort(itemOrder, Media.COMPARE_BY_TITLE_COST);
	}
	
	
//	public void printCart() {
//		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
//			if (digitalVideoDisc != null) {
//				System.out.println(digitalVideoDisc);
//			}
//		}
//		System.out.println("Total cost: " + totalCost());
//	}
	
//	public void searchByTitle(String input) {
//		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
//			if (digitalVideoDisc == null) continue;
//			if (digitalVideoDisc.isMatchTitile(input)) {
//				System.out.println(digitalVideoDisc);
//				return;
//			}
//		}
//		
//		System.out.println("404 not found");
//	}
	
//	public void searchByID(int idInput) {
//		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
//			if (digitalVideoDisc == null) continue;
//			if (digitalVideoDisc.isMatchID(idInput)) {
//				System.out.println(digitalVideoDisc);
//				return;
//			}
//		}
//		
//		System.out.println("404 not found");
//	}
	
	
}
