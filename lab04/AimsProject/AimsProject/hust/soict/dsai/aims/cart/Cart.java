package hust.soict.dsai.aims.cart;
import java.util.Iterator;
import java.util.Scanner;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < itemOrdered.length; i++) {
			if (itemOrdered[i] == null) {
				itemOrdered[i] = disc;
				System.out.println("The disc has been added");
				if (i >= 18) {
					System.out.println("Your cart is almost full");
				}
				return;
			}else {
				if (itemOrdered[i].equals(disc)) {
					System.out.println(disc + " is alrady in the cart");
					return;
				}
			}
		}
		
		System.out.println("Cart is full");

	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc digitalVideoDisc : dvdList) {
			addDigitalVideoDisc(digitalVideoDisc);
		}
	}
	
	public void addDigitalVideoDisc(int numDVD) {
		//pass an arbitrary number of arguments for dvd
		for(int i = 0; i < numDVD; i++) {
			//dosomething;S
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)  {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public float totalCost() {
		float cost = 0;
		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
			if (digitalVideoDisc != null) {
				cost = cost + digitalVideoDisc.getCost();
			}
		}
		
		return cost;
	}
	
	public void printCart() {
		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
			if (digitalVideoDisc != null) {
				System.out.println(digitalVideoDisc);
			}
		}
		System.out.println("Total cost: " + totalCost());
	}
	
	public void searchByTitle(String input) {
		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
			if (digitalVideoDisc == null) continue;
			if (digitalVideoDisc.isMatchTitile(input)) {
				System.out.println(digitalVideoDisc);
				return;
			}
		}
		
		System.out.println("404 not found");
	}
	
	public void searchByID(int idInput) {
		for (DigitalVideoDisc digitalVideoDisc : itemOrdered) {
			if (digitalVideoDisc == null) continue;
			if (digitalVideoDisc.isMatchID(idInput)) {
				System.out.println(digitalVideoDisc);
				return;
			}
		}
		
		System.out.println("404 not found");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < itemOrdered.length; i++) {
			if (itemOrdered[i].equals(disc)) {
				itemOrdered[i] = null;
				System.out.println("Removed successfully");
				return;
			}
		}
	}
}
