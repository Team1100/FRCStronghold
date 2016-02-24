package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.auto.util.CommandsForEveryAuto;
import org.usfirst.frc.team1100.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.TrackThenFIRELASER;
import org.usfirst.frc.team1100.robot.commands.vision.TurnRightUntilCamera;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAuto extends CommandGroup{
	/**
	 * This will be called to drive under the low bar.
	 */
	public LowBarAuto(){
		addSequential(new CommandsForEveryAuto());
		//Drive straight ahead for a bit
		addSequential(new DriveStraight(.7, 4));
		//Turn to face goal.
		addSequential(new TurnRightUntilCamera());
		//Track and Fire
		addSequential(new TrackThenFIRELASER());
		//Fire then reset
		addSequential(new FireThenReset());
	}
}