# IamRobo
A desktop application for performing multiple robotic movements
                        ROBOT CONTROLLER

Files
------------------------------------------------------------------------
Main.java			: Main class that loads the FXML file and create a Scene.
ControllerClass.java	: Controller Class that contains all event listeners.
RobotController.java	: The class that contains the getters and setter methods.
RobotModel.java		: The variables and statuses are defined here.
NewUI.fxml			: FXML file

Functionalities
------------------------------------------------------------------------

1. Movement: 
 	i. It can move forward and backward. 
  	ii. It can also turn in any direction, from 1 degree to 360 degrees, not just left or right.
  	iii. It can also stop.
  	iv. The responses given by the robot are visible to the user.

2. Speed:
It has three speeds: slow, medium, and fast.  The responses given by the robot to the speed inputs are visible to the user.

3. Camera:
It can be instructed to turn on its camera.  The camera can be turned on or off and the image can be resized.

4. Temperature:
It can be requested to send back the current temperature from its temperature sensor. We have generated a random number between 40 F to 70 F that is near room temperature.

5. Arm Movement: 
The robot has a mechanical arm.  The arm can moved between 0 to 90 degrees. At 0 degree, the arm is down. Also, the claw can be open or closed. The GUI reflects the state of the arm and claw.  



