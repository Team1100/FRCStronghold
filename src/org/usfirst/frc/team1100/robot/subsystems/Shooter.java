
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;
import org.usfirst.frc.team1100.robot.commands.shooter.arm.UserMoveArm;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers
 * (or our own towers. or empty space(its air damnit). or the ceiling, idk)
 */
public class Shooter extends Subsystem {

	private static Shooter shooter;

	private DoubleSolenoid fill;//this one creates the work buildup for firing
	private DoubleSolenoid latch;//controls/releases the fill
	private DoubleSolenoid reset;//pulls back kicker to reset
	private SpeedController lift1;
	private SpeedController lift2;//these two move the arm up and down

	public boolean isReset() {
		if(fill.get()==Value.kForward
				&&reset.get()==Value.kReverse
				&&latch.get()==Value.kForward){
			return true;
		}
		else return false;
	}

	public void burn(){// The Heretics
		System.out.println("ARGHGHHERARGHARTHELPMEIMDYINGARGHH");
	}

	public static Shooter getInstance() {
		if (shooter == null)
			shooter = new Shooter();
		return shooter;
	}

	public Shooter() {
		fill = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_FILL_PNEUMATIC_A, RobotMap.S_FILL_PNEUMATIC_B);
		latch = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_LATCH_PNEUMATIC_A, RobotMap.S_LATCH_PNEUMATIC_B);
		reset = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_RESET_PNEUMATIC_A, RobotMap.S_RESET_PNEUMATIC_B);
		
		lift1 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_1);
		lift2 = new Talon(RobotMap.L_ARM_LIFT_MOTOR_2);
	}

	public void moveArm(double value){
		burn();
		lift1.set(value);
		lift2.set(value);
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

	public void initDefaultCommand() {
		setDefaultCommand(new UserMoveArm());
	}
}
