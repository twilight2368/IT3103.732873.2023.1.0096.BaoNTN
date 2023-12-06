package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	

	public Book(int id, String title ,String category, float cost) {
		this.id = id;
		this.title = title;
		this.category=category;
		this.cost = cost;	
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
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
