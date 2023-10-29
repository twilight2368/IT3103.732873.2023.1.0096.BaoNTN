import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DigitalVideoDisc {
	private String titleString;
	private String categoryString;
	private String directorString;
	private int length;
	private float cost;

	public static List<DigitalVideoDisc> allDVDs = new ArrayList<DigitalVideoDisc>();

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public String getCategoryString() {
		return categoryString;
	}

	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}

	public String getDirectorString() {
		return directorString;
	}

	public void setDirectorString(String directorString) {
		this.directorString = directorString;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public static void showAllDVDs() {
		for (DigitalVideoDisc digitalVideoDisc : allDVDs) {
			System.out.println(digitalVideoDisc);
		}
	}

	/**
	 * option == 1: Search by title
	 * <br>
	 * option == 2: Search by category name
	 * <br>
	 * else: not working
	 */
	public static void searchDVD(String input, int option) {
		if (option == 1) {
			for (DigitalVideoDisc digitalVideoDisc : allDVDs) {
				if (digitalVideoDisc.titleString.toLowerCase().equals(input.toLowerCase())) {
					System.out.println(digitalVideoDisc);
				}
			}
		} else if (option == 2) {
			for (DigitalVideoDisc digitalVideoDisc : allDVDs) {
				if (digitalVideoDisc.categoryString.toLowerCase().equals(input.toLowerCase())) {
					System.out.println(digitalVideoDisc);
				}
			}
		}
	}
	
	/**Search by price*/
	public static void searchDVD(double price_less, double price_more) {
		for (DigitalVideoDisc digitalVideoDisc : allDVDs) {
			if (digitalVideoDisc.cost >= price_less && digitalVideoDisc.cost <= price_more) {
				System.out.println(digitalVideoDisc);
			}
		}
	}

	@Override
	public String toString() {
		return "[" + titleString + " - " + categoryString + " - " + directorString + " - " + length + " - " + cost
				+ "]";
	}

}
