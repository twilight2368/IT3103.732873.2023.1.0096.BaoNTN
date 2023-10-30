import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cart {
	private List<DigitalVideoDisc> my_cartDVDs = new ArrayList<DigitalVideoDisc>();
	private static final int MAX_QTY = 20;

	/* Add a DVD to cart */
	public void addToCart(DigitalVideoDisc disc) {
		if (disc != null) {
			if (my_cartDVDs.size() < MAX_QTY) {
				my_cartDVDs.add(disc);
				System.out.println("DVD is added");
			} else {
				System.out.println("Cart is full");
			}
		} else {
			System.out.println("Not found DVD");
		}
	}
	
	/*Search DVD in cart*/
	public DigitalVideoDisc searchDVDinCart(String titleString) {
		for (DigitalVideoDisc digitalVideoDisc : my_cartDVDs) {
			if (titleString.toLowerCase().equals(digitalVideoDisc.getTitleString().toLowerCase())) {
				return digitalVideoDisc;
			}
		}
		return null;
	}

	/* Remove a DVD from cart */
	public void removeToCart(DigitalVideoDisc disc) {
		if (!my_cartDVDs.isEmpty()) {
			if (disc != null) {
				my_cartDVDs.remove(disc);
				System.out.println("DVD is removed");
			} else {
				System.out.println("Not found DVD");
			}
		} else {
			System.out.println("Cart is empty");
		}
	}

	/* Display all DVDs in cart */
	public void showDVDinCart() {
		if (my_cartDVDs.isEmpty()) {
			System.out.println("Cart is empty");
			return;
		}

		for (DigitalVideoDisc digitalVideoDisc : my_cartDVDs) {
			System.out.println(digitalVideoDisc);
		}
	}

	/**
	 * choice == 1: sort by cost <br>
	 * choice == 2: sort by title
	 **/
	public void sortTheCart(int choice) {
		if (choice == 1) {
			Collections.sort(my_cartDVDs, new DVDCostComparator());
			System.out.println("Sorted by cost: ");
			showDVDinCart();
		} else if (choice == 2) {
			Collections.sort(my_cartDVDs, new DVDTitleComparator());
			System.out.println("Sorted by title: ");
			showDVDinCart();
		}
	}
	
	/*Calculate total cost in cart*/
	public double totalCost() {
		double sum = 0;
		for (DigitalVideoDisc digitalVideoDisc : my_cartDVDs) {
			sum = sum + digitalVideoDisc.getCost();
		}
		
		return sum;
	}

	/* Override compare method for object */
	class DVDCostComparator implements java.util.Comparator<DigitalVideoDisc> {
		@Override
		public int compare(DigitalVideoDisc a, DigitalVideoDisc b) {
			if (a.getCost() - b.getCost() > 0) {
				return 1;
			} else if (a.getCost() - b.getCost() == 0) {
				return 0;
			} else if (a.getCost() - b.getCost() < 0) {
				return -1;
			}
			return 0;
		}
	}

	/* Override compare method for object */
	class DVDTitleComparator implements java.util.Comparator<DigitalVideoDisc> {
		@Override
		public int compare(DigitalVideoDisc a, DigitalVideoDisc b) {
			return a.getTitleString().compareTo(b.getTitleString());
		}
	}

}
