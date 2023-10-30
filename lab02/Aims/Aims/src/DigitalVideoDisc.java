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
		for (DigitalVideoDisc digitalVideoDisc : allDVDs.reversed()) {
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
	
	public static DigitalVideoDisc searchDVD(String titleinput) {
		for (DigitalVideoDisc digitalVideoDisc : allDVDs) {
			if (digitalVideoDisc.getTitleString().toLowerCase().equals(titleinput.toLowerCase())) {
				return digitalVideoDisc;
			}
		}
		return null;
	}
	/** Calculate total cost*/
	public double totalCost() {
		double cost = 0;
		for (DigitalVideoDisc digitalVideoDisc : allDVDs) {
			cost = cost + digitalVideoDisc.getCost();
		}		
		return cost;
	}
	
	//ALL CONSTRUCTORS FOR DigitalVideoDisc class
	public DigitalVideoDisc(String titleString, String categoryString, String directorString, int length, float cost) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
		this.directorString = directorString;
		this.length = length;
		this.cost = cost;
	}
	
	public DigitalVideoDisc(String titleString, String categoryString, int length, float cost) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
		this.length = length;
		this.cost = cost;
	}

	public DigitalVideoDisc(String titleString) {
		super();
		this.titleString = titleString;
	}

	public DigitalVideoDisc(String titleString, String categoryString, float cost) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
		this.cost = cost;
	}

	public DigitalVideoDisc(String titleString, String categoryString, String directorString, float cost) {
		super();
		this.titleString = titleString;
		this.categoryString = categoryString;
		this.directorString = directorString;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "[" + titleString + " - " + categoryString + " - " + directorString + " - " + length + " - " + cost
				+ "]";
	}

}
