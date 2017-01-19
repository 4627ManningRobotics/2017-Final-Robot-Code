package org.usfirst.frc.team4627.robot.subsystems;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.ElChupasControl;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElChupaArms extends Subsystem {

	//Declaring Arm motors
	CANTalon leftMotor = new CANTalon(RobotMap.EL_CHUPAS_LEFT_MOTOR);
	CANTalon rightMotor = new CANTalon(RobotMap.EL_CHUPAS_RIGHT_MOTOR);
	CANTalon liftMotorMaster = new CANTalon(RobotMap.EL_CHUPAS_LIFT_MOTOR_MASTER);
	CANTalon liftMotorSlave = new CANTalon(RobotMap.EL_CHUPAS_LIFT_MOTOR_SLAVE);
	Solenoid kicker = new Solenoid(RobotMap.EL_CHUPAS_KICKER);
    
	public int motorPosition = 0;
	
	public double waitTime = 0;
	
	public void setUpEncoder() {
		
		// set up master motor
		liftMotorMaster.changeControlMode(CANTalon.TalonControlMode.Position);
		liftMotorMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		liftMotorMaster.setPID(2.8, 0.0, 0.0);
		liftMotorMaster.enableControl();
		
		//Set up slave motor
		liftMotorSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		liftMotorSlave.set(liftMotorMaster.getDeviceID());
		liftMotorSlave.reverseOutput(false);
		
	}
	
	public void shootBoulder(double speed) {
	
		leftMotor.set(-speed);
		rightMotor.set(speed);
		
	}
 
    public void shootKicker(boolean shooting) {
		
    	kicker.set(shooting);
		
	}
    
    public double getEncoderValue() {

    	return liftMotorMaster.get();
    	
    }
    
    public void setMotor() {
    	
    	liftMotorMaster.set(motorPosition);
    	
    }
    
    public void zeroMotorInPlace() {

    	motorPosition = 0;
    	liftMotorMaster.setPosition(0);
    
    }
    
    public void setMotorAutoStart() {
    	
    	
    	motorPosition = RobotMap.EL_CHUPAS_MAX_POSITION;
    	liftMotorMaster.setPosition(RobotMap.EL_CHUPAS_MAX_POSITION);
    	
    }
    
    public double getSlaveCurrent() {
    	
    	return liftMotorSlave.getOutputCurrent();
    	
    }
	
    public void overcurrentCheck() {
    	
    	if(motorPosition > liftMotorSlave.getEncPosition() && liftMotorSlave.getOutputCurrent() >= 20.00) {
    		
    		motorPosition = RobotMap.EL_CHUPAS_MAX_POSITION;
        	liftMotorMaster.setPosition(RobotMap.EL_CHUPAS_MAX_POSITION);

    		
    	}
    	if(motorPosition < liftMotorSlave.getEncPosition() && liftMotorSlave.getOutputCurrent() >= 20.00) {
    		
    		motorPosition = 0;
        	liftMotorMaster.setPosition(0);

    		
    	}
    	
    	
    }

	public void initDefaultCommand() {
	
    	setDefaultCommand(new ElChupasControl());
    	
    }
	

}

