package org.usfirst.frc.team4627.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4627.robot.commands.ArmsFullyBack;
import org.usfirst.frc.team4627.robot.commands.AutoTargeting;
import org.usfirst.frc.team4627.robot.commands.AutoTargetingX;
import org.usfirst.frc.team4627.robot.commands.GTADrive;
import org.usfirst.frc.team4627.robot.commands.AutoShoot;
import org.usfirst.frc.team4627.robot.commands.SetCloseShotAng;
import org.usfirst.frc.team4627.robot.commands.ChupasGoDown;
import org.usfirst.frc.team4627.robot.commands.SetDefenseShotAng;
import org.usfirst.frc.team4627.robot.commands.LowGoalAutomatic;
import org.usfirst.frc.team4627.robot.commands.ResetChupasEncoder;
import org.usfirst.frc.team4627.robot.commands.ShiftHigh;
import org.usfirst.frc.team4627.robot.commands.ShiftLow;
import org.usfirst.frc.team4627.robot.commands.ElChupaKick;
import org.usfirst.frc.team4627.robot.commands.AutoShoot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	// Declaring Joysticks
	Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
	Joystick operator = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	
	//Declaring driver buttons
	Button driveA = new JoystickButton(driver, RobotMap.BUTTON_A);
	Button driveB = new JoystickButton(driver, RobotMap.BUTTON_B);
	Button driveBack = new JoystickButton(driver, RobotMap.BUTTON_BACK);
	Button driveStart = new JoystickButton(driver, RobotMap.BUTTON_START);
	
	//Declaring operator buttons
	Button opStart = new JoystickButton(operator, RobotMap.BUTTON_START);
	Button opX = new JoystickButton(operator, RobotMap.BUTTON_X);
	Button opBack = new JoystickButton(operator, RobotMap.BUTTON_BACK);
	Button opY = new JoystickButton(operator, RobotMap.BUTTON_Y);
	Button opA = new JoystickButton(operator, RobotMap.BUTTON_A);
	Button opB = new JoystickButton(operator, RobotMap.BUTTON_B);
	Button oprightShoulder = new JoystickButton(operator, RobotMap.BUTTON_RIGHT_BUMPER);
	Button opleftShoulder = new JoystickButton(operator, RobotMap.BUTTON_LEFT_BUMPER);
	
	
	//Sets commands to run when buttons are pressed
		public OI () {
			
			
			/*
			 * Driver a -----> Shifts into high gear
			 * Driver b -----> Shifts into low gear
			 * 
			 * Driver right trigger -----> Drives forward
			 * Driver left trigger -----> Drives backwards
			 * 
			 * 
			 * Operator a -----> Sets the Chupas to go down to the ground level
			 * Operator b -----> Currently an empty command, but will be the low goal automatic
			 * Operator x -----> Fires the kicker
			 * Operator y -----> Sets the Chupas to an angle for close shooting
			 * 
			 * Operator back -----> Resets the encoder on the lift motors for the Chupas
			 * Operator start -----> Brings the chupas fully back (ex. for going over defenses)
			 * 
			 * Operator right bumper -----> Turns on the Chupa motors shoots the kicker then stops the Chupa motors
			 * Operator left bumper -----> Sets the angle to the desired angle from the defenses
			 * 
			 * Operator right trigger -----> Intakes the ball
			 * Operator left trigger -----> Outtakes/shoots the ball
			 
			 * 
			 * */
			
			driveA.whenPressed(new ShiftHigh());
			driveB.whenPressed(new ShiftLow());
			driveBack.whenPressed(new AutoTargetingX());
			driveStart.whenPressed(new GTADrive());
			
			
			opX.whenPressed(new ElChupaKick());
			opBack.whenPressed(new ResetChupasEncoder());
			opY.whenPressed(new SetCloseShotAng());
			opA.whenPressed(new ChupasGoDown());
			opB.whenPressed(new LowGoalAutomatic());
			oprightShoulder.whenPressed(new AutoShoot());
			opleftShoulder.whenPressed(new SetDefenseShotAng());
			opStart.whenPressed(new ArmsFullyBack());
	
		}
		
	//Method for getting an axis value on the driver joystick
	public double driverAxisValue (int axis) {
		
		return driver.getRawAxis(axis);
		
	}
	
	//Method for getting an axis value on the operator joystick
	public double operatorAxisValue (int axis) {
		
		return operator.getRawAxis(axis);
		
	}
	
}

