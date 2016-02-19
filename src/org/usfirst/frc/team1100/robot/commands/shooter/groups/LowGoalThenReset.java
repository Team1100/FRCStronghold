package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LowGoalThenReset extends CommandGroup{
	/**
	 * Low goal fire then reset
	 */
	public LowGoalThenReset(){
		addSequential(new LowGoalFire());
		addSequential(new WaitCommand(1));
		addSequential(new ResetShooterCommandGroup());
	}
}