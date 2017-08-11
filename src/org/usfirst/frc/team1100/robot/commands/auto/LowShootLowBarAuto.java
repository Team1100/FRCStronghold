package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.arm.Brakeoff;
import org.usfirst.frc.team1100.robot.commands.arm.MoveArmCommand;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.intake.TurnRollers;
import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowShootLowBarAuto extends CommandGroup{
	/**
	 * This will be called to drive under the low bar, turn, and shoot into the low goal.
	 */
	public LowShootLowBarAuto(){
		//Disable arm brake
		addSequential(new Brakeoff());
		//drive through bar
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, 1));
		//move right side off of the wall
		addSequential(new DriveCommand(Drive.AUTOSPEED/2,Drive.AUTOSPEED,1));
		//turn  to goal
		addSequential(new DriveCommand(Drive.AUTOSPEED, -Drive.AUTOSPEED,1));
		//lift up arm
		addSequential(new MoveArmCommand(-.8, .6));
		//drive up to goal
		addSequential(new DriveCommand(Drive.AUTOSPEED, Drive.AUTOSPEED,1.5));
		//roll out ball
		addSequential(new TurnRollers(Intake.ROLL_SPEED),2);
	}
}