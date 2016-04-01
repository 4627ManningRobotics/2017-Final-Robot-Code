package org.usfirst.frc.team4627.robot.commands;

import java.util.Date;
import java.text.DateFormat;
import org.usfirst.frc.team4627.robot.RobotMap;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SystemTest extends CommandGroup {
    
    public  SystemTest() {
    	Date d = new Date();
    	DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String start = df.format(d);
        System.out.println("Start Time: " + start);
        
    	System.out.println("Shifting into low gear");
    	addSequential(new ShiftLow());
    	System.out.println("Reseting Encoder");
    	addSequential(new ResetChupasEncoder());
    	System.out.println("Turning to right 30 degrees");
    	addSequential(new AutoTurn(30));
    	System.out.println("Turning to left 60 degrees");
    	addSequential(new AutoTurn(-60));
    	System.out.println("Turning back");
    	addSequential(new AutoTurn(30));
    	System.out.println("Spinning el chupas out");
    	addSequential(new SetShootSpeed(1));
    	addSequential(new Wait(1));
    	System.out.println("Spinning el chupas in");
    	addSequential(new SetShootSpeed(-1));
    	addSequential(new Wait(1));
    	System.out.println("Stop chupas");
    	addSequential(new SetShootSpeed(0));
    	System.out.println("Raising arms fully");
    	addSequential(new SetArmPosition(RobotMap.EL_CHUPAS_MAX_POSITION));
    	addSequential(new Wait(1));
    	System.out.println("Lowering arms fully");
    	addSequential(new SetArmPosition(0));
    	System.out.println("Starting kicker ");
    	addSequential(new ElChupaKick());
    	System.out.println("Shifting into high gear");
    	addSequential(new ShiftHigh());
    	System.out.println("Shifting to low gear");
    	addSequential(new ShiftLow());
    	System.out.println("All completed successfully!");
    	Date s = new Date();
    	String end = df.format(s);
    	System.out.println("End Time: " + end);
    	
    }
}
