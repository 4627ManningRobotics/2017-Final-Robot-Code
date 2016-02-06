
package org.usfirst.frc.team4627.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4627.robot.commands.AutoLowBar;
import org.usfirst.frc.team4627.robot.commands.AutoMoat;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement1;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement2;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement3;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement4;
import org.usfirst.frc.team4627.robot.commands.AutoPlacement5;
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

	public static double centerY;
	public static double centerX;

	
 // GRIP table declared
	NetworkTable gRIPDataTable = NetworkTable.getTable("GRIP/gripFilePublish");

	

	//Enables the drive train subsystem to be used in commands
	public static final DriveTrain driveTrain = new DriveTrain();
	
	//Enables the El Chupa Arms subsystem to be used in commands
	public static final ElChupaArms elChupaArms = new ElChupaArms();
	
	
	//Enables OI
	public static OI oi;

	//Autonomous run commands
	Command autonomousDefenseStart;
	public static Command autonomousPlacementStart;
//	public static int driveModeStart;
	
	// Dashboard commands
    SendableChooser autonomousDefense;
    SendableChooser autonomousPlacement;
   // SendableChooser driveMode;
   
  
    
    public void robotInit() {
		// Establish OI
    	oi = new OI();
    	
    	
		
    	//  Sets autonomousDefense to a SendableChooser instance variable
		autonomousDefense = new SendableChooser();
		
		//Adding options to the SenableChooser instance variable, autonoumousDefense
		autonomousDefense.addDefault("Low Bar",new AutoLowBar());
		autonomousDefense.addObject("Moat",new AutoMoat());
		autonomousDefense.addObject("Portacolis",new AutoPortacolis());
		autonomousDefense.addObject("Ramparts",new AutoRamparts());
		autonomousDefense.addObject("Rock Wall",new AutoRockWall());
		autonomousDefense.addObject("Rough Terrain",new AutoRoughTerrain());
		autonomousDefense.addObject("Teeter Totters",new AutoTeeterTotters());
		
		//Makes all sendable choosers visable on the smart dashboard
		SmartDashboard.putData("Autonomous Defense Selector", autonomousDefense);
		
		//Sets autonomousPlacement to a SendableChooser instance variable
		autonomousPlacement = new SendableChooser();
		
		
		//Adding options to the SendableChooser instance variable, autonoumousDefense
		autonomousPlacement.addDefault("Placement 1", new AutoPlacement1());
		autonomousPlacement.addObject("Placement 2", new AutoPlacement2());
		autonomousPlacement.addObject("Placement 3", new AutoPlacement3());
		autonomousPlacement.addObject("Placement 4", new AutoPlacement4());
		autonomousPlacement.addObject("Placement 5", new AutoPlacement5());
		
		//Makes all sendable choosers visable on the smart dashboard
		SmartDashboard.putData("Autonomous Placement Selector", autonomousPlacement);
		
		//Showing commands on the smartDashboard
		SmartDashboard.putData(Scheduler.getInstance());
		
		//Showing the command on the subsystem driveTrain
		SmartDashboard.putData(driveTrain);
		
    }
	
	public void disabledPeriodic() {
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
        
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	
    	double[] dataArrayY = gRIPDataTable.getNumberArray("centerY", yValue);
  
    	for (int i = 0; i < dataArrayY.length; i++){
        	centerY = dataArrayY[i];
    	}
    	
    	
    	
    	double[] dataArrayX = gRIPDataTable.getNumberArray("centerX", xValue);
    	  
    	for (int i = 0; i < dataArrayX.length; i++){
        	centerX = dataArrayX[i];
    	}
    	
    	
    	
    	Scheduler.getInstance().run();

    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
     //   if (autonomousPlacement != null) autonomousPlacement.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	double[] yValue = new double[0];
    	double[] xValue = new double[0];
    	
    	double[] dataArrayY = gRIPDataTable.getNumberArray("centerY", yValue);
  
    	for (int i = 0; i < dataArrayY.length; i++){
        	centerY = dataArrayY[i];
    	}
    	
    	
    	
    	double[] dataArrayX = gRIPDataTable.getNumberArray("centerX", xValue);
    	  
    	for (int i = 0; i < dataArrayX.length; i++){
        	centerX = dataArrayX[i];
    	}
    	
    	int robotPressure;
		
		robotPressure = 5;
		
		SmartDashboard.putString("Air Pressure:", robotPressure + " PSI");
    	
        Scheduler.getInstance().run();
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
        LiveWindow.run();
        
    }
}
