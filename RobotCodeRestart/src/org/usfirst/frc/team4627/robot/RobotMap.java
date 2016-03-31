package org.usfirst.frc.team4627.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
		//Joystick values	
		public static final int DRIVER_JOYSTICK = 0;
		public static final int OPERATOR_JOYSTICK = 1;

		// Motor controller values
		//public static final int TOP_LEFT_MOTOR = 0;
		//public static final int TOP_RIGHT_MOTOR = 2;
		//public static final int BOTTOM_LEFT_MOTOR = 1;
		//public static final int BOTTOM_RIGHT_MOTOR = 3;

		public static final int BOTTOM_RIGHT_MOTOR = 5;
		public static final int BOTTOM_LEFT_MOTOR = 6;
		public static final int TOP_LEFT_MOTOR = 7;
		public static final int TOP_RIGHT_MOTOR = 8;
		
		
		
		
		//Pnuematics Values
		public static final int COMPRESSOR_VALUE = 0;
		public static final int GEAR_SHIFTER = 0;
	
		//Axis values
		public static final int RIGHT_TRIGGER = 3;
		public static final int LEFT_TRIGGER = 2;
		public static final int LEFT_JOYSTICK_X_AXIS = 0;
		public static final int LEFT_JOYSTICK_Y_AXIS = 1;
		public static final int RIGHT_JOYSTICK_Y_AXIS = 5;
	
		//GTA Drive Settings
			//Robot Speed Scaling
		public static final double GTA_ROBOT_CONTROLS_SCALING = 1;
			//Robot Max/Min Speed
		public static final double GTA_MAX_ROBOT_SPEED = 0.99;
		public static final double GTA_MIN_ROBOT_SPEED = -0.99;
		
		//Tank Drive Settings
			//Joystick sensitivity scaling
		public static final double TANK_DRIVE_CONTROLS_SCALING = 1;
			//Robot Max/Min Speed
		public static final double TANK_DRIVE_MAX_SPEED = 0.9;
		public static final double TANK_DRIVE_MIN_SPEED = -0.9;
		
		//Arcade Drive Settings
			//Arcade Drive Control Scaling
		public static final double ARCADE_DRIVE_CONTROL_SCALING = 1;
			//Robot Max/Min Speed
		public static final double ARCADE_DRIVE_MAX_SPEED = 0.9;
		public static final double ARCADE_DRIVE_MIN_SPEED = -0.9;
		
		//Button Values
		public static final int BUTTON_A = 1;
		public static final int BUTTON_B = 2;
		public static final int BUTTON_X = 3;
		public static final int BUTTON_Y = 4;
		public static final int BUTTON_LEFT_BUMPER = 5;
		public static final int BUTTON_RIGHT_BUMPER = 6;
		public static final int BUTTON_BACK = 7;
		public static final int BUTTON_START = 8;
		
		//El Chupa values
		//public static final int EL_CHUPAS_LEFT_MOTOR = 4;
		//public static final int EL_CHUPAS_RIGHT_MOTOR = 5;
		
		public static final int EL_CHUPAS_LEFT_MOTOR = 0;
		public static final int EL_CHUPAS_RIGHT_MOTOR = 1;
		
		public static final double EL_CHUPA_SHOOT_SCALING = 0.99;
		public static final double EL_CHUPA_FIRING_SPEED = 0.99;
		public static final int EL_CHUPAS_KICKER = 1;
		public static final int EL_CHUPAS_MAX_LIFT = 5000;
		public static final int EL_CHUPAS_MIN_LIFT = -1000;
		
		
		
		//public static final int EL_CHUPAS_LIFT_MOTOR_MASTER = 6;
		//public static final int EL_CHUPAS_LIFT_MOTOR_SLAVE = 7;
		
		public static final int EL_CHUPAS_LIFT_MOTOR_MASTER = 2;
		public static final int EL_CHUPAS_LIFT_MOTOR_SLAVE = 3;
		
		public static final int EL_CHUPAS_CLOSE_SHOT_ANGLE = 1250;
		public static final int EL_CHUPAS_MAX_POSITION = 2348;
		public static final int DEFENSE_SHOT_ANGLE = 700;
		
		public static final double AUTO_TARGET_SPIN_SPEED = 0.45;
		public static final double AUTO_TARGET_SPIN_SPEED_FINE = 0.3;
	
		
		
}