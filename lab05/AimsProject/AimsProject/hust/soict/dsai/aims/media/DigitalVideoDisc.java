package hust.soict.dsai.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Media implements Playable {
	private String director;
	private int length;

	
	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public DigitalVideoDisc(String title) {
		super(title);

	}
     
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);

	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.director = director;

	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}

	@Override
	public String toString() {
		return "DVD: " + "[" + getTitle() + "]" + "[" + getCategory() + "]" + "[" + getDirector() + "]" + "[" + getLength()
				+ "]" + ":[" + getCost() + "]";
	}
	
	@Override
	public boolean isMatchTitile(String title) {
		return getTitle().toUpperCase().equals(title.toUpperCase());
	}
	
	@Override
	public boolean isMatchID(int id) {
		return getId() == id;
	}

	public boolean equals(DigitalVideoDisc disc) {
		if (getTitle().equals(disc.getTitle())) {
			return true;
		}

		return false;
	}

	// play implement from Interface Playable
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public int compareTo(Media other) {
		if (other instanceof DigitalVideoDisc) {
			DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;
			if (getTitle().compareTo(otherDVD.getTitle()) > 0) {
				return 1;
			} else if (getTitle().compareTo(otherDVD.getTitle()) == 0) {
				if (getLength() < otherDVD.getLength()) {
					return 1;
				} else if (getLength() == otherDVD.getLength()) {
					if (getCost() >= otherDVD.getCost()) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			} else {
				return -1;
			}
		} else {
			return 1;
		}
	}
}
