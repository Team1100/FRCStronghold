
package org.usfirst.frc.team1100.robot.subsystems;

import org.usfirst.frc.team1100.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Uses pneumatics to kick boulders into enemy towers (or our own towers. or
 * empty space(its air damnit). or the ceiling, idk)
 */
public class Shooter extends Subsystem {

	private static Shooter shooter;

	private DoubleSolenoid fill;// this one creates the work buildup for firing
	private DoubleSolenoid latch;// controls/releases the fill
	private DoubleSolenoid reset;// pulls back kicker to reset

	private Solenoid flashlight;//aim that sh*t
	private Solenoid flashlight1;
	
	private boolean autoFire;
	private boolean isInAuto;
	
	public boolean isInAuto() {
		return isInAuto;
	}

	public void setInAuto(boolean isInAuto) {
		this.isInAuto = isInAuto;
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
		
		flashlight = new Solenoid(RobotMap.L_PCM, RobotMap.S_FLASHLIGHT);
		flashlight1 = new Solenoid(RobotMap.S_PCM, RobotMap.S_FLASHLIGHT_A);
		
		autoFire = false;
		isInAuto = false;
	}
	
	public void toggleLight(){
		flashlight.set(!flashlight.get());
		flashlight1.set(!flashlight1.get());
	}
	
	public boolean shootInAuto(){
		return autoFire;
	}
	
	public void setFireinAuto(boolean fire){
		this.autoFire = fire;
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

	}
}