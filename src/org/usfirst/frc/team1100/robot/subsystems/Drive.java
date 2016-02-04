
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.drive.UserDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Drive extends Subsystem {

	private static Drive DriveChain;// create drive train object

	// Declare Speed Controllers (motor controllers)
	/*private Victor RightFrontVictor;
	private Victor RightMidVictor;
	private Victor RightBackVictor;
	private Victor LeftFrontVictor;
	private Victor LeftMidVictor;
	private Victor LeftBackVictor;*/
	private SpeedController leftT;
	//private SpeedController leftT2;
	private SpeedController rightT;
	//private SpeedController rightT2;
	// Declare VVVs
	/*private VVV LeftVVV;
	private VVV RightVVV;*/
	// Declare Robot Drive
	private RobotDrive drive;
	//Declare Gyro
	//private Gyro gyro;

	public static Drive getInstance() {// make drive accessible from anywhere
		if (DriveChain == null)
			DriveChain = new Drive();
		return DriveChain;
	}

	public Drive() {
		// Initialize Jaguars
		leftT = new Jaguar(RobotMap.D_LEFT_FRONT);
		//leftT2 = new Jaguar(RobotMap.D_LEFT_BACK);
		rightT = new Jaguar(RobotMap.D_RIGHT_FRONT);
		//rightT2 = new Jaguar(RobotMap.D_RIGHT_BACK);
		/*RightFrontVictor = new Victor(RobotMap.D_RIGHT_FRONT);
		RightMidVictor = new Victor(RobotMap.D_RIGHT_MID);
		RightBackVictor = new Victor(RobotMap.D_RIGHT_BACK);
		LeftFrontVictor = new Victor(RobotMap.D_LEFT_FRONT);
		LeftMidVictor = new Victor(RobotMap.D_LEFT_MID);
		LeftBackVictor = new Victor(RobotMap.D_LEFT_BACK);
		// Initialize VVVs
		LeftVVV = new VVV(LeftFrontVictor, LeftMidVictor, LeftBackVictor);
		RightVVV = new VVV(RightFrontVictor, RightMidVictor, RightBackVictor);*/
		// Initialize Drive
		drive = new RobotDrive(leftT, rightT);
		//Initialize Gyro
		//gyro = new AnalogGyro(RobotMap.D_GYRO);
		//gyro.reset();
	}
	//method called to make robot move
	public void driveTank(double left, double right){
		drive.tankDrive(left, right);
		
	}
	//get the angle on the gyro
	/*public double getAngle(){
		return gyro.getAngle();
		
	}*/
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new UserDrive());
	}

	public class VVV implements SpeedController {//class manages a side of speed controllers
		
		//In this class "Sanic" indicates enhanced loop variable
		//Gotta go fast
		
		private SpeedController[] vics;
		private double speed;

		public VVV(SpeedController... vics) {
			this.vics = vics;
			this.set(0.0);
		}

		@Override
		public void pidWrite(double output) {
			this.set(output);
			for (SpeedController Sanic : vics) {
				Sanic.disable();
			}
		}

		@Override
		public double get() {
			return this.speed;
		}

		@Override
		public void set(double speed, byte syncGroup) {
			this.speed = speed;
		}

		@Override
		public void set(double speed) {
			this.speed = speed;
			for (SpeedController Sanic : this.vics) {
				Sanic.set(speed);
			}

		}

		@Override
		public void setInverted(boolean isInverted) {
			for(SpeedController Sanic: this.vics){
				Sanic.setInverted(isInverted);
			}

		}

		@Override
		public boolean getInverted() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void disable() {
			for(SpeedController Sanic: this.vics){
				Sanic.disable();
			}

		}

	}
}
