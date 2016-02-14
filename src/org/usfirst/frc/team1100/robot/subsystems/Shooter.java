
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers
 */
public class Shooter extends Subsystem {

	private static Shooter shooter;

	private DoubleSolenoid kicker;
	private DoubleSolenoid latch;
	private DoubleSolenoid reset;


	public boolean isReset() {
		if(kicker.get()==Value.kForward
				&&reset.get()==Value.kReverse
				&&latch.get()==Value.kForward){
			return true;
		}
		else return false;
	}

	

	public static Shooter getInstance() {
		if (shooter == null)
			shooter = new Shooter();
		return shooter;
	}

	public Shooter() {
		kicker = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_KICKER_PNEUMATIC_A, RobotMap.S_KICKER_PNEUMATIC_B);
		latch = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_LATCH_PNEUMATIC_A, RobotMap.S_LATCH_PNEUMATIC_B);
		reset = new DoubleSolenoid(RobotMap.S_PCM, RobotMap.S_RESET_PNEUMATIC_A, RobotMap.S_RESET_PNEUMATIC_B);
	}

	public void setLatch(Value v) {
		latch.set(v);
		System.out.println("Subystem called: setting latch to " + v.toString());
	}

	public void setReset(Value v) {
		reset.set(v);
	}

	public void setKicker(Value v) {
		kicker.set(v);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
