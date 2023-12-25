package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import javafx.scene.control.Label;
import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;

	public CartScreen(Cart cart) {
		// TODO Auto-generated constructor stub
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();

		this.add(fxPanel);

		this.setTitle("Cart");
		this.setSize(1024, 768);
		this.setVisible(true);

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller); 				
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));

				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] arg) {
		Cart store = new Cart();

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

		new CartScreen(store);

	}

}
