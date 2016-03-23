package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.arm.MoveArmCommand;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAuto extends CommandGroup {
	public PortcullisAuto() {
		//Move arm down and reset encoder
		addSequential(new MoveArmCommand(.7, .4));
		addSequential(new MoveToResetEncoder());
		//Drive forward towards the portcullis w/ arm down
		addParallel(new MoveArmCommand(.3, 2));
		addSequential(new DriveCommand(Drive.AUTOSPEED, Drive.AUTOSPEED, 1.5));
		//drive through
		addSequential(new MoveArmCommand(-1,1));
		addParallel(new DriveCommand(Drive.AUTOSPEED, Drive.AUTOSPEED,2));		
	}
}
