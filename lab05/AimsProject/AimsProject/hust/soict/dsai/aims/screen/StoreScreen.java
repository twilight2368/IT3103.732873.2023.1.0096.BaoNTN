package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.Border;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {

	private Store store;
	private Cart cart;
	private CartScreen cartScreen;

	public StoreScreen(Store store, Cart cart) {
		// TODO Auto-generated constructor stub
		this.store = store;
		this.cart = cart;
		cartScreen = new CartScreen(cart);
		
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
		Cart cart = new Cart();
		
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
		
		new StoreScreen(store, cart);
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
		JMenuItem addBookItem = new JMenuItem("Add Book");
		JMenuItem addCDItem = new JMenuItem("Add CD");
		JMenuItem addDVDItem = new JMenuItem("Add DVD");
		
		addBookItem.addActionListener(new MenuItemListener());
		addCDItem.addActionListener(new MenuItemListener());
		addDVDItem.addActionListener(new MenuItemListener());
		
		smUpdateStore.add(addBookItem);
		smUpdateStore.add(addCDItem);
		smUpdateStore.add(addDVDItem);

		menu.add(smUpdateStore);
		
		JMenuItem viewStoreItem = new JMenuItem("View store");
		JMenuItem viewCartItem = new JMenuItem("View cart");
		viewStoreItem.addActionListener(new MenuItemListener());
		viewCartItem.addActionListener(new MenuItemListener());
		menu.add(viewStoreItem);
		menu.add(viewCartItem);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private class MenuItemListener implements ActionListener {
		
		@Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();

	        // Perform actions based on the command
	        switch (command) {
	            case "Add Book":
	                // Add Book logic
	                break;
	            case "Add CD":
	                // Add CD logic
	                break;
	            case "Add DVD":
	                // Add DVD logic
	                break;
	            case "View store":
	            	break;
	            case "View cart":
	            	cartScreen = new CartScreen(cart);
	            	break;
	            default:
	                break;
	        }
	    }
	}

	JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS BAO_NTN_20210096");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cartBtn = new JButton("View cart");
		cartBtn.addActionListener(new ButtonViewCartListener());
		cartBtn.setPreferredSize(new Dimension(100, 50));
		cartBtn.setMaximumSize(new Dimension(100, 50));

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cartBtn);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		
		return header;

	}
	
	private class ButtonViewCartListener implements ActionListener{
		
		public ButtonViewCartListener() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public void actionPerformed(ActionEvent event) {
			String button = event.getActionCommand();
			if (button.equals("View cart")) {
				cartScreen = new CartScreen(cart);
			}
		}
		
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
			
			JButton btnAddToCart = new JButton("Add to cart");
			btnAddToCart.addActionListener(new ButtonListener(media));
			container.add(btnAddToCart);
			if (media instanceof Playable) {
				JButton btnPlay = new JButton("Play");
				btnPlay.addActionListener(new ButtonListener(media));
				container.add(btnPlay);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		}
		
		private class ButtonListener implements ActionListener{
			Media media;
			
						
			public ButtonListener(Media media) {
				super();
				this.media = media;
			}
			
			
			@Override
			public void actionPerformed(ActionEvent event) {
				String button = event.getActionCommand();
				if (button.equals("Add to cart")) {
					cart.addMedia(media);
					cartScreen.controller.updateCostLabel();
					
				}else if (button.equals("Play")) {
					JDialog dialog = new JDialog();
					JLabel label = new JLabel(media.toString());
					dialog.add(label);
					dialog.setSize(400,100);
					dialog.setVisible(true);
				}
			}
		}
		
		
	}
	
}
