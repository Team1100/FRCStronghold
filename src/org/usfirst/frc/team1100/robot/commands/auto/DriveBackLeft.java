package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.auto.util.CommandsForEveryAuto;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.TurnLeftUntilCamera;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBackLeft extends CommandGroup{
	public DriveBackLeft(){
		addSequential(new CommandsForEveryAuto());
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, 4));
		addSequential(new TurnLeftUntilCamera());
		addSequential(new FireThenReset());
	}
}