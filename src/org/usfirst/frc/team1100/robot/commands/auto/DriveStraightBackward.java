package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightBackward extends CommandGroup{
	public DriveStraightBackward(){
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, 3));
	}
}