
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.shooter.arm.UserMoveArm;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers (or our own towers. or
 * empty space(its air damnit). or the ceiling, idk)
 */
public class Lift extends PIDSubsystem {

	private static Lift lift;

	private SpeedController lift1;
	private SpeedController lift2;// these two move the arm up and down

	private TT armLift;
	
	private AnalogInput armRead2;
	
	private Encoder armRead;

	private DigitalInput encA;
	private DigitalInput encB;
	
	private DigitalInput lSwitch;

	private static final double P = .1;
	private static final double I = 0;
	private static final double D = 0;
	private static final double TOLERANCE = 1;

	public static Lift getInstance() {
		if (lift == null)
			lift = new Lift();
		return lift;
	}

	public Lift() {
		super(P, I, D);
		setAbsoluteTolerance(TOLERANCE);

		lift1 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_1);
		lift2 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_2);
		
		armLift = new TT(lift1, lift2);
		
		encA = new DigitalInput(RobotMap.L_ARM_ENC_A);
		encB = new DigitalInput(RobotMap.L_ARM_ENC_B);
		
		armRead = new Encoder(encA, encB);
		armRead2 = new AnalogInput(RobotMap.L_ARM_POTENTIOMETER);
		lSwitch = new DigitalInput(RobotMap.L_LIMIT_SWITCH);
	}

	public boolean tooFar(){
		return lSwitch.get();
	}
	
	public double getEncValue(){
		return armRead.pidGet();
	}
	
	public double getPotentiometer(){
		return armRead2.getValue();
	}
	
	public void moveArm(double value) {
		if(tooFar())
			armLift.set(0);
		else armLift.set(value);
	}


	public void initDefaultCommand() {
		setDefaultCommand(new UserMoveArm());
	}
	
	
	@Override
	protected double returnPIDInput() {
		return armRead.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {
		moveArm(output);
	}

	public class TT implements SpeedController {// class manages a set of
												// speed controllers

		// In this class "sanic" indicates enhanced loop variable

		private SpeedController[] tals;
		private double speed;

		public TT(SpeedController... tals) {
			this.tals = tals;
			this.set(0.0);
		}

		@Override
		public void pidWrite(double output) {
			this.set(output);
			for (SpeedController sanic : tals) {
				sanic.disable();
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
			for (SpeedController sanic : this.tals) {
				sanic.set(speed);
			}

		}

		@Override
		public void setInverted(boolean isInverted) {
			for (SpeedController sanic : this.tals) {
				sanic.setInverted(isInverted);
			}

		}

		@Override
		public boolean getInverted() {
			return tals[0].getInverted();
		}

		@Override
		public void disable() {
			for (SpeedController sanic : this.tals) {
				sanic.disable();
			}
		}
	}
}