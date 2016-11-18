package application;

import application.RobotModel.Speed;

/**
 * Code Written By	:	Ranjani Suresh
 * NetId			:	rxs144930
 * Date				:	10/25/2015
 * Subject			:	CS6301.006 - User Interface Design and Mobile App Development
 */

public class RobotController {


	static RobotModel robot;	// Declare a static object robot of class RobotModel
	public static void init() 
	{
		robot =  new RobotModel();	
	}
	public static int getTemperature()
	{	// This method returns the current temperature perceived by the robot.
		int temp = robot.getTemperature();
		return temp;
	}
	public static void setArmPosition(int degrees)
	{	// This method sets the arm position as per the degrees passed in the argument
		robot.armPos = degrees;
	}
	public static boolean isClawOpen()
	{			// This method checks if the claw is Open
		return robot.clawPosition;
	}
	public static void setClawPosition(boolean open)
	{	//This method set the claw position to either open(true) or close(false)

		robot.clawPosition = open;
	}	
	public static int getArmPosition()
	{			// This method gets the arm position in degrees; range is 0-90 degrees
		return robot.armPos;
	}	
	public static boolean isCameraOn(){		// This method checks if the Camera is On
		boolean flag = robot.cameraControl; 
		return flag;
	}
	public static void setCameraOff(){	// This method sets the Camera off
		robot.cameraControl = false;
	}
	public static void setCameraOn(){	// This method sets the Camera on
		robot.cameraControl = true;
	}
	public static int getdegree(int degrees)
	{
		int newDeg = degrees % 360;
		robot.degrees = newDeg; 
		return robot.degrees;
	}
	public static Speed getSpeed()
	{
		return robot.speed;
	}	
	public static void setSpeed(Speed s)
	{
		robot.speed = s;
	}

}	
