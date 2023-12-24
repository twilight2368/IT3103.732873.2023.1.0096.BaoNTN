package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	public static final int MAX_NUMBER_ORDERED = 100;
	private static List<Media> itemOrdered = new ArrayList<Media>();
	
	public static void addMedia(Media media) {
		if (itemOrdered.contains(media)) {
			System.out.println("Already in shop");
		}else {
			itemOrdered.add(media);
			System.out.println("Added successfully");
		}
	}
	
	public static void removeMedia(Media media) {
		if (itemOrdered.contains(media)) {
			itemOrdered.remove(media);
			System.out.println("Removed successfully");
		}else {
			System.out.println("Not found");
		}
	}
	
	public static Media getMediabyID(int id) {
		for (Media media : itemOrdered) {
			if (media.isMatchID(id)) {
				return media;
			}
		}
		return null;
	}
	
	public static Media getMediabyTitle(String title) {
		for (Media media : itemOrdered) {
			if (media.isMatchTitile(title)) {
				return media;
			}
		}
		return null;
	}
	
	public static ArrayList<Media> getItemsInStore() {
		return (ArrayList<Media>) itemOrdered;
	}
	
	public static void display() {
		for (Media media : itemOrdered) {
			System.out.println(media);
		}
	}
	

}
