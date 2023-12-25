package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDVDScreen extends JFrame{
	Store store;
	
	public AddDVDScreen(Store store) {
		// TODO Auto-generated constructor stub
		super();
		this.store = store;
		
		JFXPanel fxPanel = new JFXPanel();

		this.add(fxPanel);

		this.setTitle("Add DVD");
		this.setSize(600, 450);
		this.setVisible(true);

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDigitalVideoDiscToStore.fxml"));
					AddDVDController controller = new AddDVDController(store);
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

	
}
