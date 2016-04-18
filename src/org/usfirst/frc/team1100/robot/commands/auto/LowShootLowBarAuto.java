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
		//back up a bit so we do not cross the line
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, .5));
		//move arm down and reset encoder
		addSequential(new MoveToResetEncoder());
		//drive through bar
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, 2));
		//move right side off of the wall
		addSequential(new DriveCommand(0,Drive.AUTOSPEED,.6));
		//turn a bit to avoid hit side wall
		addSequential(new DriveCommand(Drive.AUTOSPEED, -Drive.AUTOSPEED,.65));
		//back up to wall
		addSequential(new DriveCommand(-(Drive.AUTOSPEED), -(Drive.AUTOSPEED), 1));
		//finish going to wall
		addSequential(new DriveCommand(-Drive.AUTOSPEED_SLOW, -Drive.AUTOSPEED_SLOW, 1.5));
		//go away from wall
		addSequential(new DriveCommand(Drive.AUTOSPEED_SLOW, Drive.AUTOSPEED_SLOW, .5));
		//turn to goal
		addSequential(new DriveCommand(-Drive.AUTOSPEED_SLOW, Drive.AUTOSPEED_SLOW, 2));
		//lift arm to go over batter lip
		addSequential(new MoveArmCommand(-.8, .6));
		//drive up to goal
		addSequential(new DriveCommand(Drive.AUTOSPEED, Drive.AUTOSPEED,.75));
		//roll out ball
		addSequential(new TurnRollers(Intake.ROLL_SPEED),2);
	}
}