
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.shooter.arm.UserMoveArm;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers (or our own towers. or
 * empty space(its air damnit). or the ceiling, idk)
 */
public class Shooter extends PIDSubsystem {

	private static Shooter shooter;

	private DoubleSolenoid fill;// this one creates the work buildup for firing
	private DoubleSolenoid latch;// controls/releases the fill
	private DoubleSolenoid reset;// pulls back kicker to reset
	
	private SpeedController lift1;
	private SpeedController lift2;// these two move the arm up and down
	
	private TT armLift;

	private AnalogInput armRead;

	
	
	private static final double P = .1;
	private static final double I = 0;
	private static final double D = 0;
	private static final double TOLERANCE = 1; 

	public static Shooter getInstance() {
		if (shooter == null)
			shooter = new Shooter();
		return shooter;
	}

	public Shooter() {
		super(P, I, D);
		setAbsoluteTolerance(TOLERANCE);

		fill = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_FILL_PNEUMATIC_A, RobotMap.S_FILL_PNEUMATIC_B);
		latch = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_LATCH_PNEUMATIC_A, RobotMap.S_LATCH_PNEUMATIC_B);
		reset = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_RESET_PNEUMATIC_A, RobotMap.S_RESET_PNEUMATIC_B);

		lift1 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_1);
		lift2 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_2);
		
		armLift = new TT(lift1, lift2);

		armRead = new AnalogInput(RobotMap.L_ARM_LIFT_POTENTIOMETER);
	}

	public void moveArm(double value) {
		armLift.set(value);
	}

	public void setLatch(Value v) {
		latch.set(v);
	}

	public String getLatchValue() {
		return latch.toString();
	}

	public void setReset(Value v) {
		reset.set(v);
	}

	public void setFill(Value v) {
		fill.set(v);
	}

	public boolean isReset() {
		if (fill.get() == Value.kForward && reset.get() == Value.kReverse && latch.get() == Value.kForward) {
			return true;
		} else
			return false;
	}

	public void burn() {// The Heretics
		System.out.println("ARGHGHHERARGHARTHELPMEIMDYINGARGHH");
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
		armLift.set(output);
	}

	public class TT implements SpeedController {// class manages a set of
													// speed controllers

		// In this class "Sanic" indicates enhanced loop variable

		private SpeedController[] tals;
		private double speed;

		public TT(SpeedController... tals) {
			this.tals = tals;
			this.set(0.0);
		}

		@Override
		public void pidWrite(double output) {
			this.set(output);
			for (SpeedController Sanic : tals) {
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
			for (SpeedController Sanic : this.tals) {
				Sanic.set(speed);
			}

		}

		@Override
		public void setInverted(boolean isInverted) {
			for (SpeedController Sanic : this.tals) {
				Sanic.setInverted(isInverted);
			}

		}

		@Override
		public boolean getInverted() {
			return tals[0].getInverted();
		}

		@Override
		public void disable() {
			for (SpeedController Sanic : this.tals) {
				Sanic.disable();
			}
		}
	}
}
