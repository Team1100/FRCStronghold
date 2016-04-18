package org.usfirst.frc.team1100.robot.commands.auto.old;

import org.usfirst.frc.team1100.robot.commands.auto.util.CommandsForEveryAuto;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightForward extends CommandGroup{
	public DriveStraightForward(){
		addSequential(new DriveCommand(Drive.AUTOSPEED, Drive.AUTOSPEED, 3));
	}
}