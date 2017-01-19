package org.usfirst.frc.team4627.robot.subsystems;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.StartupDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 		
		//CANTalon topLeftMotor = new CANTalon(RobotMap.TOP_LEFT_MOTOR);
    	//CANTalon topRightMotor = new CANTalon(RobotMap.TOP_RIGHT_MOTOR);
    	//CANTalon bottomLeftMotor = new CANTalon(RobotMap.BOTTOM_LEFT_MOTOR);
    	//CANTalon bottomRightMotor = new CANTalon(RobotMap.BOTTOM_RIGHT_MOTOR);
    	
		CANTalon topLeftMotor = new CANTalon(RobotMap.TOP_LEFT_MOTOR);
		CANTalon topRightMotor = new CANTalon(RobotMap.TOP_RIGHT_MOTOR);
		CANTalon bottomLeftMotor = new CANTalon(RobotMap.BOTTOM_LEFT_MOTOR);
		CANTalon bottomRightMotor = new CANTalon(RobotMap.BOTTOM_RIGHT_MOTOR);
	
    	Solenoid gearShifter = new Solenoid(RobotMap.GEAR_SHIFTER);

    	

  
    	
    	public void shiftGear(boolean gear) {
    		
    		gearShifter.set(gear);
    		
    	}

    	//Setting the speed of motors
    	public void setLeftMotors(double speed) {
    		
    		topLeftMotor.set(speed);
    		bottomLeftMotor.set(speed);
    		
    	}

    	public void setRightMotors(double speed) {
    		
    		topRightMotor.set(speed);
    		bottomRightMotor.set(speed);
    	}
    	


	public void initDefaultCommand() {
        
    	setDefaultCommand(new StartupDrive());
    	
    	
    }
}

