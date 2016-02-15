
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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

	public boolean isReset() {
		if(fill.get()==Value.kForward
				&&reset.get()==Value.kReverse
				&&latch.get()==Value.kForward){
			return true;
		}
		else return false;
	}

	public void burn(){
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
	}

	public void setLatch(Value v) {
		latch.set(v);
		System.out.println("Subystem called: setting latch to " + v.toString());
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
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
