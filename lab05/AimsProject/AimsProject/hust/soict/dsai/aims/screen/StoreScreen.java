package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {

	private Store store;

	public StoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		this.store = store;
		
		Container cp = getContentPane();
		
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("DVD1'S Title", null, 76.0f);
		store.addMedia(dvd1);
		Book book1 = new Book("Book2's Title", null, 61.0f);
		store.addMedia(book1);
		CompactDisc cd3 = new CompactDisc("CD3's Title", null, 59.0f);
		store.addMedia(cd3);
		CompactDisc cd4 = new CompactDisc("CD4's Title", null, 38.0f);
		store.addMedia(cd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("DVD5'S Title", null, 43.0f);
		store.addMedia(dvd5);
		CompactDisc cd6 = new CompactDisc("CD6's Title", null, 95.0f);
		store.addMedia(cd6);
		Book book7 = new Book("Book7's Title", null, 24.0f);
		store.addMedia(book7);
		Book book8 = new Book("Book8's Title", null, 78.0f);
		store.addMedia(book8);
		CompactDisc cd9 = new CompactDisc("CD9's Title", null, 95.0f);
		store.addMedia(cd9);
		
		new StoreScreen(store);
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {

		JMenu menu = new JMenu("Options");

		JMenu smUpdateStore = new JMenu("Update store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	JPanel createHeader() {

		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS BAO_NTN_20210096");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;

	}

	JPanel createCenter() {

		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel{
		
		private Media media;

		public MediaStore(Media media) {
			
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			container.add(new JButton("Add to cart"));
			if (media instanceof Playable) {
				container.add(new JButton("Play"));
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		}
		
		
	}

}
