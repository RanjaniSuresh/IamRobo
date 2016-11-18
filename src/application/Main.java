package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Code Written By	:	Ranjani Suresh
 * NetId			:	rxs144930
 * Date				:	10/25/2015
 * Subject			:	CS6301.006 - User Interface Design and Mobile App Development
 */


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewUI.fxml")); 
			Parent root = loader.load();
			ControllerClass controller = (ControllerClass) loader.getController();
			controller.init(primaryStage);
			Scene scene = new Scene(root,1366,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("ROBOT CONTROLLER");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}
}
