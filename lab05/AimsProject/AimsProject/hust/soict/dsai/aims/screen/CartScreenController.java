package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import java.awt.event.ActionListener;
import java.util.function.Predicate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.application.Platform;

public class CartScreenController {
	private Cart cart;

	@FXML
	private TableView<Media> tblMedia;

	@FXML
	private TableColumn<Media, String> colMediaCost;

	@FXML
	private TableColumn<Media, String> colMediaTitle;

	@FXML
	private TableColumn<Media, String> colMediaCategory;

	@FXML
	private ToggleGroup filterCategory;

	@FXML
	private Button btnPlay;

	@FXML
	private Button btnRemove;

	@FXML
	private RadioButton radioBtnFilterId;

	@FXML
	private RadioButton radioBtnFilterTitle;

	@FXML
	private TextField tfFilter;

	@FXML
	private Label totalcostID;

	@FXML
	private Button orderBtnID;

	public CartScreenController(Cart cart) {
		// TODO Auto-generated constructor stub
		super();
		this.cart = cart;
	}

	@FXML
	private void initialize() {

		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, String>("cost"));

		tblMedia.setItems(this.cart.getItemsOrdered());
		FloatProperty totalCost = new SimpleFloatProperty(this.cart.totalCost());
		totalcostID.setText("$" + cart.totalCost());

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				if (newValue != null) {
					updateButtonBar(newValue);
				}
			}
		});

		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> oservable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});

		cart.getItemsOrdered().addListener((ListChangeListener.Change<? extends Media> change) -> {
			Platform.runLater(() -> {
				totalcostID.setText("$" + cart.totalCost());
			});
		});

	}

	
	@FXML
    void orderBtnClicked(ActionEvent event) {
		cart.removeAllMedia();
		JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		JOptionPane.showMessageDialog(frame, "Cart removed" ,"Order Placed", JOptionPane.INFORMATION_MESSAGE);
    }

	void updateButtonBar(Media media) {
		btnRemove.setVisible(true);
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
	}

	void showFilteredMedia(String search) {
		ObservableList<Media> sort_cartList = cart.getItemsOrdered();
		FilteredList<Media> filtedData = new FilteredList<>(sort_cartList);

		filtedData.setPredicate(media -> {
			if (search == null || search.isEmpty() || search.length() == 0) {
				return true;
			} else {
				if (radioBtnFilterId.isSelected()) {
					return media.getId() == Integer.parseInt(search);
				}

				if (radioBtnFilterTitle.isSelected()) {
					return media.getTitle().toLowerCase().contains(search.toLowerCase());
				}

				return false;
			}
		});

		tblMedia.setItems(filtedData);

	}
	
	

}
