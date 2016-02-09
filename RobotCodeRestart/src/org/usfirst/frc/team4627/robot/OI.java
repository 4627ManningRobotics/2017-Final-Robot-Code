package org.usfirst.frc.team4627.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4627.robot.commands.AutoTargeting;
import org.usfirst.frc.team4627.robot.commands.ShiftHigh;
import org.usfirst.frc.team4627.robot.commands.ShiftLow;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    
	// Declaring Joysticks
	Joystick driver = new Joystick(RobotMap.DRIVER_JOYSTICK);
	Joystick operator = new Joystick(RobotMap.OPERATOR_JOYSTICK);
	
	//Declaring Buttons
	Button a = new JoystickButton(driver, RobotMap.BUTTON_A);
	Button b = new JoystickButton(driver, RobotMap.BUTTON_B);
	Button start = new JoystickButton(operator, RobotMap.BUTTON_START);
		
	//Sets commands to run when buttons are pressed
		public OI () {
			
			a.whenPressed(new ShiftHigh());
			b.whenPressed(new ShiftLow());
			start.whenPressed(new AutoTargeting());
				
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

