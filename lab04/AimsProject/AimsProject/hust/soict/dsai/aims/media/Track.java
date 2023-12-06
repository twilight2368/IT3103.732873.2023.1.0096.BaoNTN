package hust.soict.dsai.aims.media;

public class Track implements Playable {

	private String title;
	private int length;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	// play implement from Interface Playable
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}

}
