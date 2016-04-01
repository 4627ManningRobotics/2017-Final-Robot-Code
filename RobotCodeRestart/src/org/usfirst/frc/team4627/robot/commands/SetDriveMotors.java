package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetDriveMotors extends Command {

	double tme;
	double spd;
	
    public SetDriveMotors(double speed, double time) {
        requires(Robot.driveTrain);
        tme = time;
        spd = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.driveTrain.setLeftMotors(spd);
    	Robot.driveTrain.setRightMotors(-spd);
    	Timer.delay(tme);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
