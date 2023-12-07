package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		super();	
	}
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category,cost);	
	}
	
	


	@Override
	public String toString() {
		return "Book" + "[" + getId() + "]" + "[" + getTitle() + "]" + "[" +  getCategory() + "]" + "[" + getCost() + "]";
	}
	

	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println(authorName + " already added");
		}else {
			authors.add(authorName);
			System.out.println("Successfully added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("Successfully removed");
		}else {
			System.out.println("404 not found");
		}
	}

}
