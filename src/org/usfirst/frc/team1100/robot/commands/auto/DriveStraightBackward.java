package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.auto.util.CommandsForEveryAuto;
import org.usfirst.frc.team1100.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team1100.robot.commands.drive.TurnCommand;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightBackward extends CommandGroup{
	public DriveStraightBackward(){
		addSequential(new CommandsForEveryAuto());
		addSequential(new DriveStraight(-.8, 4));
		addSequential(new TurnCommand(180));
		addSequential(new FireThenReset());
	}
}