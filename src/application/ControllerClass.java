package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import application.RobotModel.Speed;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Code Written By : Ranjani Suresh 
 * NetId : rxs144930 
 * Date : 10/25/2015 
 * Subject: CS6301.006 - User Interface Design and Mobile App Development
 */

public class ControllerClass implements Initializable {

	@FXML
	Button Tempbtn, ClawOpenbtn, ClawClosebtn, Cambtn, Forwardbtn, Backwardbtn, SpdSlowbtn, SpdMdmbtn, SpdFastbtn,
			Stopbtn; // Declares the buttons

	@FXML
	Slider RotSlider, CamSlider, ArmSlider; // Declare Sliders used for
											// direction control, arm control
											// and zooming in and out the image

	@FXML
	Label ViewLbl, ClawLbl, TempLabl, SpdLbl, MvmtLbl, DirLbl, ArmmmtLbl, ArmLbl, RotLabl, tempview, speedview,
			camstatus; // Declare Labels

	@FXML
	ImageView CamPic, RobotPic, NavArr, camview, leftbtnview, forwardbtnview, rtbtnview, backwardbtnview; // Declare
																											// ImageViews
																											// to
																											// show
																											// the
																											// compass,
																											// speedometer,
																											// robot
																											// images
																											// and
																											// the
																											// camera
																											// image

	@FXML
	AnchorPane MainPane, APtop, Apdown, SliderAp, cameraAp, clawAp, MoveAp, ancpane; // Declare
																						// AnchorPanes

	static int robotspeed = 0;
	static boolean fwddirbtn, bkwddirbtn;
	TranslateTransition tt;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void init(Stage primaryStage) {
		RobotController.init();
		ArmSlider.valueProperty().addListener(new ChangeListener<Number>() { // Adds
																				// a
																				// listener
																				// for
																				// arm
																				// Control
																				// Slider
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				int degrees = new_val.intValue();
				RobotController.setArmPosition(degrees); // sets the arm to
															// degrees entered
															// through slider
				setRobotImage(); // changes the robot image according to change
									// in degrees
				ArmLbl.setText(new_val.intValue() + " degrees"); // Shows the
																	// degrees
																	// selected
																	// by the
																	// user
			}
		});
		RotSlider.valueProperty().addListener(new ChangeListener<Number>() { // Adds
																				// a
																				// listener
																				// to
																				// the
																				// Direction
																				// slider
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {

				int oldval = old_val.intValue();
				int degrees = new_val.intValue();
				int newDeg = RobotController.getdegree(degrees);
				RotateTransition rt = new RotateTransition(); // using rotate
																// transition
																// object for
																// rotation
																// event
				rt.setNode(NavArr);
				rt.setFromAngle(oldval);
				rt.setToAngle(newDeg);
				System.out.println(newDeg);
				rt.setAutoReverse(true);
				rt.play();

				RotLabl.setText(new_val.intValue() + " degrees"); // Shows the
																	// direction
																	// in
																	// degrees
																	// selected
																	// by the
																	// user
			}

		});
		CamSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				int newvalue = new_val.intValue();

				CamPic.setScaleX(newvalue);
				CamPic.setScaleY(newvalue);

				CamPic.preserveRatioProperty().set(true);

			}
		});
	}

	// Temperature Control
	@FXML
	protected void handleTempButtonAction(ActionEvent e) {
		int temp = RobotController.getTemperature();
		System.out.println(temp);// RobotController sends the temperature
		tempview.setTextFill(Color.GREEN);
		tempview.setText("Current Temp: " + temp + " degrees F");

	}

	public void setRobotImage() { // This method is called to set an image on
									// the ImageView to depict the position of
									// Arm and Claw
		int deg = 0; // Temporary Variable to store the approximate value of
						// degrees
		int armPos = RobotController.getArmPosition(); // Instructs the
														// RobotController to
														// get the arm position
														// in degrees; range is
														// 0-90 degrees
		File file;
		// Stores a value in the variable deg, as per the range of the actual
		// position of the arm in degrees
		if (armPos == 0)
			deg = 0;
		else if (armPos > 0 && armPos <= 10)
			deg = 10;
		else if (armPos > 10 && armPos <= 20)
			deg = 20;
		else if (armPos > 20 && armPos <= 30)
			deg = 30;
		else if (armPos > 30 && armPos <= 40)
			deg = 40;
		else if (armPos > 40 && armPos <= 50)
			deg = 50;
		else if (armPos > 50 && armPos <= 60)
			deg = 60;
		else if (armPos > 60 && armPos <= 70)
			deg = 70;
		else if (armPos > 70 && armPos <= 80)
			deg = 80;
		else
			deg = 90;
		/*
		 * Chooses an image on the basis of the approximate value of degrees and
		 * the claw position(Open/Close).
		 */
		if (RobotController.isClawOpen()) {
			String fileName = "src/fxmlrobot/robotopen" + deg + ".png";
			file = new File(fileName);
		} else {
			String fileName = "src/fxmlrobot/robotclosed" + deg + ".png";
			file = new File(fileName);
		}
		Image image = new Image(file.toURI().toString()); // Loads the file on
															// an Image Object
		RobotPic.setImage(image); // Sets the selected image on the ImageView
		RobotPic.setVisible(true); // and then makes the ImageView visible
	}

	@FXML
	public void OpenclawAction(ActionEvent e) { // This method is called if the
												// user clicks the button to
												// open the claw of the robot

		RobotController.setClawPosition(true); // Instructs the RobotController
												// to open the Claw
		setRobotImage(); // Sets the Robot image accordingly
		ClawOpenbtn.setDisable(true);
		ClawClosebtn.setDisable(false);
	}

	@FXML
	public void CloseclawAction(ActionEvent e) { // This method is called if the
													// user clicks the button to
													// close the claw of the
													// robot

		RobotController.setClawPosition(false); // Instructs the RobotController
												// to close the Claw
		setRobotImage(); // Sets the Robot image accordingly
		ClawClosebtn.setDisable(true);
		ClawOpenbtn.setDisable(false);

	}

	@FXML
	public void onClickCamera(ActionEvent e) { // This method is used to
												// turnon/off the camera
		if (!RobotController.isCameraOn()) { // Turns on the camera if it is off
			CamPic.setVisible(true); // Makes the image visible
			RobotController.setCameraOn(); // Changes the state of the Camera to
											// on
			camstatus.setText("ON");

		} else {
			CamPic.setVisible(false);
			RobotController.setCameraOff();
			camstatus.setText("OFF");

		}
	}

	public void onfrwdbtnclick(ActionEvent e) {

		if (RobotController.getSpeed() == Speed.OFF) {
			robotspeed = 5;
			RobotController.setSpeed(Speed.SLOW);
			speedview.setText("SLOW");
		}
		moveforward();
		fwddirbtn = true;
		bkwddirbtn = false;
	}

	public void moveforward() {
		if (tt != null) {
			tt.stop();
			tt.setDuration(Duration.seconds(robotspeed));
		} else {

			tt = new TranslateTransition(Duration.seconds(robotspeed), RobotPic);

		}
		tt.setFromY(+(Apdown.getPrefHeight()));
		tt.setToY(-Apdown.getPrefHeight());
		tt.setCycleCount(Timeline.INDEFINITE);
		tt.play();

	}

	public void onbkwdbtnclick(ActionEvent e) {
		if (RobotController.getSpeed() == Speed.OFF) {
			robotspeed = 5;
			RobotController.setSpeed(Speed.SLOW);
			speedview.setText("SLOW");
		}
		movebackward();
		fwddirbtn = false;
		bkwddirbtn = true;
	}

	public void movebackward() {
		if (tt != null) {
			tt.stop();
			tt.setDuration(Duration.seconds(robotspeed));

		} else {
			tt = new TranslateTransition(Duration.seconds(robotspeed), RobotPic);

		}
		tt.setFromY(-(Apdown.getPrefHeight()));
		tt.setToY(+(Apdown.getPrefHeight()));
		tt.setCycleCount(Timeline.INDEFINITE);
		tt.play();

	}

	public void slowbtnclick(ActionEvent e) // Event Listemer for Slow Button
	{
		robotspeed = 5; // Assigns the corresponding speed for the robot
		speedview.setText("SLOW");

		if (fwddirbtn && !bkwddirbtn)
			moveforward();
		else
			movebackward();

	}

	public void mdmbtnclick(ActionEvent e) // Event Listener for Medium Button
	{
		robotspeed = 3; // Assigns the corresponding speed for the robot
		speedview.setText("MEDIUM");

		if (fwddirbtn && !bkwddirbtn)
			moveforward();
		else
			movebackward();
	}

	public void fastbtnclick(ActionEvent e) // Event Listener for Fast Button
	{
		robotspeed = 1; // Assigns the corresponding speed for the robot
		speedview.setText("FAST");

		if (fwddirbtn && !bkwddirbtn)
			moveforward();
		else
			movebackward();
	}

	public void stopbtnclick(ActionEvent e) // Event Listener for Stop Button
	{
		RobotController.setSpeed(Speed.OFF); // sets the speed to OFF
		robotspeed = 0;
		tt.stop(); // Stops the Transition

	}
}
