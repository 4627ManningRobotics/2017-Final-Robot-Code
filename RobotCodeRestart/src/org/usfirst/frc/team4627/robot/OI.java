package org.usfirst.frc.team4627.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4627.robot.commands.ArmsFullyBack;
import org.usfirst.frc.team4627.robot.commands.AutoTargeting;
import org.usfirst.frc.team4627.robot.commands.TheAligner;
import org.usfirst.frc.team4627.robot.commands.ChupasAngleCloseShot;
import org.usfirst.frc.team4627.robot.commands.ChupasGoDown;
import org.usfirst.frc.team4627.robot.commands.DefenseShotAngleSet;
import org.usfirst.frc.team4627.robot.commands.LowGoalAutomatic;
import org.usfirst.frc.team4627.robot.commands.ResetChupasEncoder;
import org.usfirst.frc.team4627.robot.commands.ShiftHigh;
import org.usfirst.frc.team4627.robot.commands.ShiftLow;
import org.usfirst.frc.team4627.robot.commands.Shoot;
import org.usfirst.frc.team4627.robot.commands.TheAligner;

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
			
			driveA.whenPressed(new ShiftHigh());
			driveB.whenPressed(new ShiftLow());
			opX.whenPressed(new Shoot());
			opBack.whenPressed(new ResetChupasEncoder());
			opY.whenPressed(new ChupasAngleCloseShot());
			opA.whenPressed(new ChupasGoDown());
			opB.whenPressed(new LowGoalAutomatic());
			oprightShoulder.whenPressed(new TheAligner());
			opleftShoulder.whenPressed(new DefenseShotAngleSet());
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

