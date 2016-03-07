
package org.usfirst.frc.team4627.robot;

import edu.wpi.first.wpilibj.CameraServer;
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
import org.usfirst.frc.team4627.robot.commands.AutoTurn;
import org.usfirst.frc.team4627.robot.commands.TheAligner;
import org.usfirst.frc.team4627.robot.commands.AutoTargetingX;
import org.usfirst.frc.team4627.robot.commands.AutoTargetingY;
import org.usfirst.frc.team4627.robot.commands.AutoTeeterTotters;
import org.usfirst.frc.team4627.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4627.robot.subsystems.ElChupaArms;
import org.usfirst.frc.team4627.robot.subsystems.Sensors;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

/*
 * Programmer Names: Ryan, Drew & Paul 
 * 
 * LIABILITY WAVER:
 * IF ANYTHING IS WRONG IT IS 100% ELECTRICAL TEAM'S  FAULT
 * 
 * 
 * DREW IS A BETRAYER MUCH DISAPPOINT 
 * 
 * 
 * 
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
	
	// Enables the Sensors subsystem to be used in commands
	public static final Sensors sensors = new Sensors();
	

	// Enables OI
	public static OI oi;

	// Autonomous run commands
	Command autonomousDefenseStart;
	public static Command autonomousPlacementStart;

	// Dashboard commands
	SendableChooser autonomousDefense;
	SendableChooser autonomousPlacement;

	public void robotInit() {
		
		//CameraServer server = CameraServer.getInstance();
		//server.setQuality(50);
		//server.startAutomaticCapture("cam0");	

		Robot.elChupaArms.setUpEncoder();
		
		
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

		SmartDashboard.putData("AutoTarget X", new AutoTargetingX());
		SmartDashboard.putData("AutoTarget Y", new AutoTargetingY());
		SmartDashboard.putData("AutoTarget Shoot", new TheAligner());
		SmartDashboard.putData("Placement One", new AutoPlacement1());
		SmartDashboard.putData("Test Gyro 45", new AutoTurn(45));
	}

	public void disabledPeriodic() {

		// Default code, do not delete
		Scheduler.getInstance().run();

	}


    public void autonomousInit() {
    	
    	elChupaArms.setMotorAutoStart();
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
        
    	getGRIPData();

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
    	
    	
    	
    	SmartDashboard.putNumber("Talon 3 Current", elChupaArms.getSlaveCurrent());
    	//Print out encoder values
    	//System.out.println(Robot.elChupaArms.getEncoderValue());
    	
    	//Print gyroscope values
    	System.out.println(Robot.sensors.getGyroAngle());
    	
    	getGRIPData();
    	
    	
    	
    	
		SmartDashboard.putNumber("Chupas Position", elChupaArms.getEncoderValue());

		// Default code, do not delete
		Scheduler.getInstance().run();

	}

    public void getGRIPData() {
    	
    	//Declaring arrays of doubles to be used when retrieving data from GRIP during autonomous
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	double[] widthValue = new double[0];
    	
    	int widthPos = 0;
    	//Getting the array values for centerY (The center of the contour in grip from top to bottom)
    	double[] dataArrayY = GRIPDataTable.getNumberArray("centerY", yValue);
    	//Getting the array values for centerX (The center of the contour in grip from left to right)
    	double[] dataArrayX = GRIPDataTable.getNumberArray("centerX", xValue);
    	//Getting the array values for width (The center of the contour in grip from left to right)
    	double[] dataArrayWidth = GRIPDataTable.getNumberArray("width", widthValue);
    	
    	for(int i = 0; i < dataArrayWidth.length; i++){
    		
    		if(dataArrayWidth[i] > dataArrayWidth[widthPos]){
    			
    			widthPos = i;
    			
    		}
    		
    	}
    	//Getting a single double value from the array of centerY
        if (dataArrayY.length > widthPos) {	
    		centerY = dataArrayY[widthPos];
        }
    	//Getting a single double value from the array of centerX
        if (dataArrayX.length > widthPos){
    		centerX = dataArrayX[widthPos];
        }
    		
		//Showing the value of centerY on the smart dashboard
		SmartDashboard.putNumber("The value of centerY is ", Robot.centerY);
		
		//Showing the value of centerX on the smart dashboard
		SmartDashboard.putNumber("The value of centerX is ", Robot.centerX);
    }
    
	/*
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

		// Default code, do not delete
		LiveWindow.run();

	}
}
