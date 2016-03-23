package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.auto.util.CommandsForEveryAuto;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.TurnRightUntilCamera;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveBackRight extends CommandGroup{
	public DriveBackRight(){
		addSequential(new CommandsForEveryAuto());
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, 4));
		addSequential(new TurnRightUntilCamera());
		addSequential(new FireThenReset());
	}
}