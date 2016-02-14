package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireThenReset extends CommandGroup{
	public FireThenReset(){
		addSequential(new FireShooterCommandGroup());
		addSequential(new ResetShooterCommandGroup());
	}
}
