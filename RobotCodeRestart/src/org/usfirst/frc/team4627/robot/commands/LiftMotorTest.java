package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftMotorTest extends Command {

    public LiftMotorTest() {
        
    	requires(Robot.elChupaArms);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    Robot.elChupaArms.motorPosition = 1500;
    Robot.elChupaArms.setMotor();
    Timer.delay(3);
    Robot.elChupaArms.motorPosition = 50;
    Robot.elChupaArms.setMotor();
    
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
