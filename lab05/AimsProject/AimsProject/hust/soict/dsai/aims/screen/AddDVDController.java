package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddDVDController {

	Store store;
	DigitalVideoDisc digitalVideoDisc;
	String title, category, director;
	int length;
	float cost;

	@FXML
	private Button addBtnID;

	@FXML
	private TextField categoryID;

	@FXML
	private TextField costID;

	@FXML
	private TextField directorID;

	@FXML
	private TextField lengthID;

	@FXML
	private TextField titleID;

	public AddDVDController(Store store) {
		// TODO Auto-generated constructor stub
		this.store = store;
	}

	@FXML
	private void initialize() {

		titleID.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> oservable, String oldValue, String newValue) {
				title = newValue;
			}
		});

		categoryID.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> oservable, String oldValue, String newValue) {
				category = newValue;
			}
		});

		lengthID.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> oservable, String oldValue, String newValue) {
				length = Integer.parseInt(newValue);
			}
		});

		directorID.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> oservable, String oldValue, String newValue) {
				director = newValue;
			}
		});

		costID.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> oservable, String oldValue, String newValue) {
				cost = Float.parseFloat(newValue);
			}
		});

	}

	@FXML
	void AddButtonClicked(ActionEvent event) {
		digitalVideoDisc = new DigitalVideoDisc(title, category, director, length, cost);
		store.addMedia(digitalVideoDisc);
	}

}
