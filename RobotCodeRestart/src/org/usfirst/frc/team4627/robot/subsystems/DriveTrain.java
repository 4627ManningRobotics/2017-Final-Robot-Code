package org.usfirst.frc.team4627.robot.subsystems;
import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.GTADrive;
import org.usfirst.frc.team4627.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
 		CANJaguar topLeftMotor = new CANJaguar(RobotMap.TOP_LEFT_MOTOR);
    	CANJaguar topRightMotor = new CANJaguar(RobotMap.TOP_RIGHT_MOTOR);
    	CANJaguar bottomLeftMotor = new CANJaguar(RobotMap.BOTTOM_LEFT_MOTOR);
    	CANJaguar bottomRightMotor = new CANJaguar(RobotMap.BOTTOM_RIGHT_MOTOR);
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
    	
    	public void autoLowBar() {
    		
    		Robot.driveTrain.setLeftMotors(0.25);
    		Robot.driveTrain.setRightMotors(-0.25);
    		Timer.delay(5);
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		
    	}
    	
    	public void autoMoat() {
    		
    		Robot.driveTrain.setLeftMotors(0.45);
    		Robot.driveTrain.setRightMotors(-0.45);
    		Timer.delay(3);
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		
    	}
    	
    	public void autoPortacolis() {
    		
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		Timer.delay(5);
    		
    	}
    	
    	public void autoRamparts() {
    		
    		Robot.driveTrain.setLeftMotors(0.5);
    		Robot.driveTrain.setRightMotors(-0.5);
    		Timer.delay(1.5);
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(-0.8);
    		Timer.delay(0.5);
    		Robot.driveTrain.setLeftMotors(0.6);
    		Robot.driveTrain.setRightMotors(-0.5);
    		Timer.delay(1);	
    		
    	}
    	
    	public void autoRockWall() {
    		
        	Robot.driveTrain.setLeftMotors(0.6);	
        	Robot.driveTrain.setRightMotors(-0.6);
        	Timer.delay(4);
    		
    	}
    	
    	public void autoRoughTerrain() {
    		
    		Robot.driveTrain.setLeftMotors(0.5);
    		Robot.driveTrain.setRightMotors(-0.5);
    		Timer.delay(5);
    		
    	}
    	
    	public void autoTeeterTotters() {
    		
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		Timer.delay(5);
    		
    	}
    	
    	public void autoPlacement1() {
    		
       	 Robot.driveTrain.setLeftMotors(0.8);
         Robot.driveTrain.setRightMotors(-0.8);
         Timer.delay(2);
         
         Robot.driveTrain.setLeftMotors(0);
         Robot.driveTrain.setRightMotors(0);
         Timer.delay(0.2);
         
         Robot.driveTrain.setLeftMotors(0.8);
         Robot.driveTrain.setRightMotors(-0.1);
         Timer.delay(1);
         
         Robot.driveTrain.setRightMotors(-0.8);
         Timer.delay(2);
    		
    	}
    	
    	public void autoPlacement2() {
    		
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		Timer.delay(5);
    		
    	}
    	
    	public void autoPlacement3() {
    		
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		Timer.delay(5);
    		
    		
    	}
    	
    	public void autoPlacement4() {
    		
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		Timer.delay(5);
    		
    		
    	}
    	
    	public void autoPlacement5() {
    		
    		Robot.driveTrain.setLeftMotors(0);
    		Robot.driveTrain.setRightMotors(0);
    		Timer.delay(5);
    		
    		
    	}
    			
    			
    	
    public void initDefaultCommand() {
        
    setDefaultCommand(new TankDrive());
    	
    	
    }
}

