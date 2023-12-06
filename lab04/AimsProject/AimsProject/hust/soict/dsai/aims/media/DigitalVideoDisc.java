package hust.soict.dsai.aims.media;
import java.util.Objects;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	private int idDigitalVideoDiscs = 0;

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

	public DigitalVideoDisc(int id ,String title) {
		super();

		this.idDigitalVideoDiscs = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(int id ,String title, String category, float cost) {
		super();
		this.idDigitalVideoDiscs = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(int id ,String title, String category, String director, float cost) {
		super();
		this.director = director;
		this.idDigitalVideoDiscs = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(int id ,String title, String category, String director, int length, float cost) {
		super();
		this.director = director;
		this.length = length;
		this.idDigitalVideoDiscs = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}


	@Override
	public String toString() {
		return "DVD: " 
				+ "[" + title + "]" 
				+ "[" + category + "]" 
				+ "[" + director + "]" 
				+ "[" + length + "]"
				+ ":[" + cost + "]";
	}
	
	public boolean isMatchTitile(String title) {
		return this.title.toUpperCase().equals(title.toUpperCase());
	}
	
	public boolean isMatchID(int id) {
		return idDigitalVideoDiscs == id;
	}

	public boolean equals(DigitalVideoDisc disc) {
		if (title.equals(disc.getTitle())) {
			return true;
		}
		
		return false;
	}
		

}
