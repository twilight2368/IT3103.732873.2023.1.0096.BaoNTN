package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBER_ORDERED = 100;
	private static DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];

	public static void addDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < itemOrdered.length; i++) {
			if (itemOrdered[i] == null) {
				itemOrdered[i] = disc;
				System.out.println("The disc has been added to store");
				return;
			} else {
				if (itemOrdered[i].equals(disc)) {
					System.out.println(disc + " is alrady in the store");
					return;
				}
			}
		}

		System.out.println("Store is full");

	}

	public static void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc digitalVideoDisc : dvdList) {
			addDigitalVideoDisc(digitalVideoDisc);
		}
	}

	public static void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < itemOrdered.length; i++) {
			if (itemOrdered[i].equals(disc)) {
				itemOrdered[i] = null;
				System.out.println("Removed successfully");
				return;
			}
		}
	}

}
