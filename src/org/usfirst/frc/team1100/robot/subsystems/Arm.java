
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.arm.UserMoveArm;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Uses pneumatics to kick boulders into enemy towers (or our own towers. or
 * empty space(its air damnit). or the ceiling, idk)
 */
public class Arm extends PIDSubsystem {

	private static Arm arm;

	private SpeedController arm1;
	private SpeedController arm2;// these two move the arm up and down

	private AnalogInput armRead2;

	private Encoder armRead;

	private DigitalInput lSwitch;
	private DigitalInput downLimitSwitch;
	private Solenoid brake;

	public static final double POS_DEFENSES = 240;
	public static final double POS_MIDDLE = 230;
	public static final double POS_CLOSE = 250;
	public static final double POS_RAMP = 290;

	private static final double P = .1;
	private static final double I = 0;
	private static final double D = 0;
	private static final double TOLERANCE = 7;
	private static final double MAX_SPEED = .6;

	public static final boolean ON = false;
	public static final boolean OFF = true;
	
	public static Arm getInstance() {
		if (arm == null)
			arm = new Arm();
		return arm;
	}

	public Arm() {
		super(P, I, D);
		setAbsoluteTolerance(TOLERANCE);
		setOutputRange(-MAX_SPEED, MAX_SPEED);

		arm1 = new Talon(RobotMap.A_ARM_LIFT_MOTOR_1);
		arm2 = new Talon(RobotMap.A_ARM_LIFT_MOTOR_2);

		brake = new Solenoid(RobotMap.S_PCM, RobotMap.A_BRAKE);
		
		//downLimitSwitch = new DigitalInput(RobotMap.A_DOWN_SWITCH);
		
		armRead = new Encoder(RobotMap.A_ARM_ENC_A, RobotMap.A_ARM_ENC_B);
		armRead.reset();
	}
	
	
	public void brake(){
		brake.set(true);
	}
	
	public void setBrake(boolean b) {
		brake.set(b);
	}
	
	public boolean isTooFarDown() {
		return !downLimitSwitch.get();
	}
	
	public boolean tooFar() {
		return lSwitch.get();
	}

	public double getEncValue() {
		return armRead.get();
	}

	public void resetEncoder() {
		armRead.reset();
	}

	public double getPotentiometer() {
		return armRead2.getValue();
	}

	public void moveArm(double value) {
		/*if (getEncValue() > 500 && value < 0) {
			arm1.set(0);
			arm2.set(0);
			return;
		}*/
		
		/*if(value > 0 && isTooFarDown()) {
			//Check for the limit switch being hit, and if it is then we sto
			//the arm and only allow it to go back up
			arm1.set(0);
			arm2.set(0);
			return;
		}*/
		/*
		if(OI.getInstance().getPeasant().getAxis(XboxController.XboxAxis.kYLeft)!=0) {
			setBrake(OFF); 
		}
		*/
		arm1.set(value);
		arm2.set(value);
	}

	public boolean getBrake(){
		return brake.get();
	}
	
	public void brakeToggle(){
		brake.set(!brake.get());
		if(brake.get())
			SmartDashboard.putString("Brake status", "Enabled");
		else
			SmartDashboard.putString("Brake status", "Disabled");
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new UserMoveArm());
	}

	@Override
	protected double returnPIDInput() {
		return -armRead.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		moveArm(-output);
	}
}