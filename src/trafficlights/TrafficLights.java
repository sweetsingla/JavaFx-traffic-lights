/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlights;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;

public class TrafficLights extends Application {
	@Override 
	public void start(Stage primaryStage) {
		VBox circle = new VBox(5);
		circle.setAlignment(Pos.CENTER);
                Rectangle rec = new Rectangle();
		rec.setFill(Color.BLACK);
		rec.setStroke(Color.BLACK);
                rec.setWidth(50);
		rec.setHeight(150);
		StackPane light = new StackPane(rec, circle);

		Circle Circle1 = getCircle();
		Circle Circle2 = getCircle();
		Circle Circle3 = getCircle();
                circle.getChildren().addAll(Circle1, Circle2, Circle3);

		HBox button = new HBox(5);
		button.setAlignment(Pos.CENTER);

		RadioButton red = new RadioButton("RED");
		RadioButton yellow = new RadioButton("YELLOW");
		RadioButton green = new RadioButton("GREEN");

		ToggleGroup rbButton = new ToggleGroup();
		red.setToggleGroup(rbButton);
		yellow.setToggleGroup(rbButton);
		green.setToggleGroup(rbButton);
		button.getChildren().addAll(red, yellow, green);

		BorderPane pane = new BorderPane();
		pane.setCenter(light);
		pane.setBottom(button);

		red.setOnAction(e -> {
			if (red.isSelected()) {
				Circle1.setFill(Color.RED);
				Circle2.setFill(Color.WHITE);
				Circle3.setFill(Color.WHITE);
			}
		});
		yellow.setOnAction(e -> {
			if (yellow.isSelected()) {
				Circle1.setFill(Color.WHITE);
				Circle2.setFill(Color.YELLOW);
				Circle3.setFill(Color.WHITE);
			}
		});
                green.setOnAction(e -> {
			if (green.isSelected()) {
				Circle1.setFill(Color.WHITE);
				Circle2.setFill(Color.WHITE);
				Circle3.setFill(Color.GREEN);
			}
		});

		Scene scene = new Scene(pane, 400, 200);
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}

	private Circle getCircle() {
		Circle CIRCLE = new Circle(15);
		CIRCLE.setFill(Color.WHITE);
		CIRCLE.setStroke(Color.BLACK);
		return CIRCLE;
	}
}
