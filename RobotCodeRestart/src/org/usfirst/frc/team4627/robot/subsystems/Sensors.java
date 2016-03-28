package org.usfirst.frc.team4627.robot.subsystems;

//import org.usfirst.frc.team4627.robot.commands.ElChupasControl;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	
	ADXRS450_Gyro gyroSPI = new ADXRS450_Gyro();
	public double preAngle;
	public double postAngle;
	
	
	public double getGyroAngle() {
		
		return gyroSPI.getAngle();
		
	}
	
    public void initDefaultCommand() {
        //(new ElChupasControl());
    }
    
    
    
    
}

