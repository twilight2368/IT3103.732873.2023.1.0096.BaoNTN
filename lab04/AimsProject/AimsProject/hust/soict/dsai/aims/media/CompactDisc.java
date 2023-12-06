package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (tracks.contains(track)) {
			System.out.println("Track already in list");
		} else {
			tracks.add(track);
		}
	}

	public void removeTrack(Track track) {
		if (!tracks.contains(track)) {
			System.out.println("Track not in list");
		} else {
			tracks.remove(track);
		}
	}

	public int getLength() {
		int sum = 0;
		for (Track track : tracks) {
			sum = sum + track.getLength();
		}
		return sum;
	}

	// play implement from Interface Playable
	public void play() {
		for (Track track : tracks) {
			track.play();
		}
	}

}
