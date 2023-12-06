package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBER_ORDERED = 100;
	private static List<Media> itemOrdered = new ArrayList<Media>();
	
	private void addMedia(Media media) {
		if (itemOrdered.contains(media)) {
			System.out.println("Already in shop");
		}else {
			itemOrdered.add(media);
			System.out.println("Added successfully");
		}
	}
	
	private void removeMedia(Media media) {
		if (itemOrdered.contains(media)) {
			itemOrdered.remove(media);
			System.out.println("Removed successfully");
		}else {
			System.out.println("Not found");
		}
	}

}
