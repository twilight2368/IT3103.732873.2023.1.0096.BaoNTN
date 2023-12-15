package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

import hust.soict.dsai.aims.compare.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.compare.MediaComparatorByTitleCost;

public abstract class Media implements Comparable<Media> {
	private int id = 1; 
	private String title;
	private String category;
	private float cost;
	
	private static int id_unique = 0;
	
	
	//Implement Comparators
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	
	public Media() {
		this.id = id_unique;
		id_unique++;
	}
	
	public Media(String title) {
		this.title = title;
		this.id = id_unique;
		id_unique++;
	}
    
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = id_unique;
		id_unique++;
	}

	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}


	public float getCost() {
		return cost;
	}


	@Override
	public int hashCode() {
		return Objects.hash(title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		return title.equals(other.getTitle());
	}
	
	@Override
	public int compareTo(Media media) {
		if (title.compareTo(media.getTitle()) > 0) {
			return 1;
		}else if (title.compareTo(media.getTitle()) == 0) {
			if (cost >= media.getCost()) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return -1;
		}
	}
	
	public boolean isMatchTitile(String title) {
		return getTitle().toUpperCase().equals(title.toUpperCase());
	}

	public boolean isMatchID(int id) {
		return getId() == id;
	}





	
	
}
