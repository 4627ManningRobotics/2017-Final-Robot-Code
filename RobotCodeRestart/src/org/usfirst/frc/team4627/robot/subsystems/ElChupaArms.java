package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.ElChupasControl;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElChupaArms extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//Declaring Arm motors
	Victor leftMotor = new Victor(RobotMap.EL_CHUPAS_LEFT_MOTOR);
	Victor rightMotor = new Victor(RobotMap.EL_CHUPAS_RIGHT_MOTOR);
	
	public void shootBoulder(double speed) {
	
		
		leftMotor.set(-speed);
		rightMotor.set(speed);
		
	}
	
		
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ElChupasControl());
    	
    	
    	
    	
    }
}

