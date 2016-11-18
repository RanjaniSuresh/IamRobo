package application;

/**
 * Code Written By	:	Ranjani Suresh
 * NetId			:	rxs144930
 * Date				:	10/25/2015
 * Subject			:	CS6301.006 - User Interface Design and Mobile App Development
 */

public class RobotModel {

	public enum Speed {OFF, SLOW, MEDIUM,FAST};
	int degrees;	// Direction in degrees
	int armPos;		// Arm poisiton in degrees; Range : 0-90 degrees; 0 -> down and 90 -> up
	Speed speed;	

	boolean cameraControl, clawPosition, isStarted;
	int temperature;

	public RobotModel() 
	{
		// TODO Auto-generated constructor stub
		speed = Speed.OFF;	// Robot is at halt at initialization
		degrees = 0;
		cameraControl = true;	// Camera is switched on already
		clawPosition = false;	// Claw is closed
		isStarted = false;	
	}
	public int computeTemperature()
	{	// This method returns any random value between 40 and 70 degree F
		int temp  = 40 + (int)(Math.random()*70) ;
		//System.out.println(temp);
		return temp;
	}
	public int getTemperature(){		// This method returns the temperature of the surrounding area 
		this.temperature=computeTemperature();
		return this.temperature;
	}


}
