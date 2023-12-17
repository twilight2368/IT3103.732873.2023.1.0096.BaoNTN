package hust.soict.dsai.javafx;

import java.awt.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PainterController {
	boolean drawing = true;

	@FXML
	private Pane drawingAreaPane;
	
	@FXML
	private RadioButton eraser;

	@FXML
	private RadioButton pen;

	@FXML
	void clearButtonPressed(ActionEvent event) {
		drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
		// implement clearing the canvas here
		Circle newCircle;

		if (drawing) {
			newCircle = new Circle(event.getX(), event.getY(), 4, Paint.valueOf("black"));
		} else {
			newCircle = new Circle(event.getX(), event.getY(), 4, Paint.valueOf("white"));
		}

		drawingAreaPane.getChildren().add(newCircle);

	}

	@FXML
	void setEraser(MouseEvent event) {
		drawing = false;
		pen.setSelected(false);
	}

	@FXML
	void setPen(MouseEvent event) {
		drawing = true;
		eraser.setSelected(false);
	}

}
