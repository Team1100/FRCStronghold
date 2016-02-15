package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class FireThenReset extends CommandGroup{
	public FireThenReset(){
		addSequential(new SetLatchCommand(Value.kReverse));
		addSequential(new ResetShooterCommandGroup());
	}
}