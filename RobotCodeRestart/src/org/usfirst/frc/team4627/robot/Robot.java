
package org.usfirst.frc.team4627.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4627.robot.commands.AutoDefenseNull;
import org.usfirst.frc.team4627.robot.commands.AutoLowBar;
import org.usfirst.frc.team4627.robot.commands.AutoMoat;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement1;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement2;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement3;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement4;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement5;
import org.usfirst.frc.team4627.robot.commands.AutoPlacementNull;
import org.usfirst.frc.team4627.robot.commands.AutoPortacolis;
import org.usfirst.frc.team4627.robot.commands.AutoRamparts;
import org.usfirst.frc.team4627.robot.commands.AutoRockWall;
import org.usfirst.frc.team4627.robot.commands.AutoRoughTerrain;
import org.usfirst.frc.team4627.robot.commands.AutoTeeterTotters;
import org.usfirst.frc.team4627.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4627.robot.subsystems.ElChupaArms;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	
	
	// Declaring variables for retrieving values from GRIP
	public static double centerY;
	public static double centerX;

	// GRIP table declared
	NetworkTable GRIPDataTable = NetworkTable.getTable("GRIP/gripFilePublish");

	// Enables the drive train subsystem to be used in commands
	public static final DriveTrain driveTrain = new DriveTrain();

	// Enables the El Chupa Arms subsystem to be used in commands
	public static final ElChupaArms elChupaArms = new ElChupaArms();

	// Enables OI
	public static OI oi;

	// Autonomous run commands
	Command autonomousDefenseStart;
	public static Command autonomousPlacementStart;

	// Dashboard commands
	SendableChooser autonomousDefense;
	SendableChooser autonomousPlacement;

	public void robotInit() {

		// Establish OI
		oi = new OI ();

		
		//Resets the encoder
		//Robot.elChupaArms.resetEncoder();

		// Sets autonomousDefense to a SendableChooser instance variable
		autonomousDefense = new SendableChooser();

		// Adding options to the SenableChooser instance variable,
		// autonoumousDefense
		autonomousDefense.addDefault("Low Bar", new AutoLowBar());

		//Adding options to the SenableChooser instance variable, autonoumousDefense
		autonomousDefense.addObject("Low Bar",new AutoLowBar());
		autonomousDefense.addObject("Moat",new AutoMoat());
		autonomousDefense.addObject("Portacolis",new AutoPortacolis());
		autonomousDefense.addObject("Ramparts",new AutoRamparts());
		autonomousDefense.addObject("Rock Wall",new AutoRockWall());
		autonomousDefense.addObject("Rough Terrain",new AutoRoughTerrain());
		autonomousDefense.addObject("Teeter Totters",new AutoTeeterTotters());
		autonomousDefense.addDefault("Null", new AutoDefenseNull());
		
		//Makes all sendable choosers visable on the smart dashboard
		autonomousDefense.addObject("Moat", new AutoMoat());
		autonomousDefense.addObject("Portacolis", new AutoPortacolis());
		autonomousDefense.addObject("Ramparts", new AutoRamparts());
		autonomousDefense.addObject("Rock Wall", new AutoRockWall());
		autonomousDefense.addObject("Rough Terrain", new AutoRoughTerrain());
		autonomousDefense.addObject("Teeter Totters", new AutoTeeterTotters());

		// Makes all sendable choosers visable on the smart dashboard
		SmartDashboard.putData("Autonomous Defense Selector", autonomousDefense);

		// Sets autonomousPlacement to a SendableChooser instance variable
		autonomousPlacement = new SendableChooser();
		
		//Adding options to the SendableChooser instance variable, autonoumousDefense
		autonomousPlacement.addObject("Placement 1", new AutoPlacement1());

		// Adding options to the SendableChooser instance variable,
		// autonoumousDefense
		autonomousPlacement.addDefault("Placement 1", new AutoPlacement1());
		autonomousPlacement.addObject("Placement 2", new AutoPlacement2());
		autonomousPlacement.addObject("Placement 3", new AutoPlacement3());
		autonomousPlacement.addObject("Placement 4", new AutoPlacement4());
		autonomousPlacement.addObject("Placement 5", new AutoPlacement5());
		autonomousPlacement.addDefault("Null", new AutoPlacementNull());

		// Makes all sendable choosers visable on the smart dashboard
		SmartDashboard.putData("Autonomous Placement Selector", autonomousPlacement);

		// Showing commands that are currently running on the smartDashboard
		SmartDashboard.putData(Scheduler.getInstance());

		// Showing the command on the subsystem DriveTrain
		SmartDashboard.putData(driveTrain);
		
		//Showing the command on the subsystem ElChupaArms
		SmartDashboard.putData(elChupaArms);

	}

	public void disabledPeriodic() {

		// Default code, do not delete
		Scheduler.getInstance().run();

	}


    public void autonomousInit() {
    	
    	
    	//Makes autonomousDefenseStart command variable equal to the selected command on the autonomousDefense selectable chooser
    	autonomousDefenseStart = (Command) autonomousDefense.getSelected();
    	
    	//Makes autonomousPlacementStart command variable equal to the selected command on the autonomousPlacement selectable chooser
    	autonomousPlacementStart = (Command) autonomousPlacement.getSelected();
    	
    	//Runs autonomousDefenseStart command
    	if (autonomousDefenseStart != null) autonomousDefenseStart.start();
    	
    	

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
    	
    	
    	
    	//Declaring arrays of doubles to be used when retrieving data from GRIP during autonomous
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	
    	//Getting the array values for centerY (The center of the contour in grip from top to bottom)
    	double[] dataArrayY = GRIPDataTable.getNumberArray("centerY", yValue);
    	
    	//Getting a single double value from the array of centerY
    	for (int i = 0; i < dataArrayY.length; i++){
        	
    		centerY = dataArrayY[i];
    	
    	}
    	
    	//Getting the array values for centerX (The center of the contour in grip from left to right)
    	double[] dataArrayX = GRIPDataTable.getNumberArray("centerX", xValue);
    	
    	//Getting a single double value from the array of centerX
    	for (int i = 0; i < dataArrayX.length; i++){
        	
    		centerX = dataArrayX[i];
    	
    	}
    	
    	//Default code, do not delete
    	Scheduler.getInstance().run();

    }

    public void teleopInit() {
		
    	// This line makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousPlacement != null) autonomousPlacement.cancel();
    }

    /*
     This function is called when the disabled button is hit.
     You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /*
     This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	//Print out encoder values
    	Robot.elChupaArms.getEncoderValue();
    	
    	//Sets array variables for retrieving values in GRIP
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	
    	//Gets centerY values from GRIP
    	double[] dataArrayY = GRIPDataTable.getNumberArray("centerY", yValue);
    	
    	//Sets the array value as a single value
    	for (int i = 0; i < dataArrayY.length; i++){
        	centerY = dataArrayY[i];
    	}
    	
    	//Gets centerX values from GRIP
    	double[] dataArrayX = GRIPDataTable.getNumberArray("centerX", xValue);
    	  
    	//Sets the array value as a single value
    	for (int i = 0; i < dataArrayX.length; i++){
        	
    		centerX = dataArrayX[i];
    	
    	}
    	
    	//Sets a variable for the smart dashboard air pressure value
    	int robotPressure;
		
		// Sets the value for the smart dashboard air pressure value (Currently
		// set at 5 for testing, to be modified once we have the hardware for
		// testing pressure)
		robotPressure = 5;

		// Puts the robotPressure variable on the smart dashboard
		SmartDashboard.putString("Air Pressure:", robotPressure + " PSI");

		// Default code, do not delete
		Scheduler.getInstance().run();

	}

	/*
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

		// Default code, do not delete
		LiveWindow.run();

	}
}
