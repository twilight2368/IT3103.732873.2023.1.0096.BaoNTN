package hust.soict.dsai.aims.compare;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	public MediaComparatorByTitleCost() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public int compare(Media media1, Media media2) {
		if (media1.getTitle().compareTo(media2.getTitle()) > 0) {
			return 1;
		}else if (media1.getTitle().compareTo(media2.getTitle()) == 0) {
			if (media1.getCost() > media2.getCost()) {
				return 1;
			}else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
