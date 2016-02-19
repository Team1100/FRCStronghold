package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class FireThenReset extends CommandGroup{
	/**
	 * Fires by releasing latch and then resets after a second.
	 */
	public FireThenReset(){
		addSequential(new SetLatchCommand(Value.kReverse));
		addSequential(new WaitCommand(1));
		addSequential(new ResetShooterCommandGroup());
	}
}