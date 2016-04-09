package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.arm.ArmToSetpoint;
import org.usfirst.frc.team1100.robot.commands.arm.MoveArmCommand;
import org.usfirst.frc.team1100.robot.commands.arm.MoveToResetEncoder;
import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowShootLowBarAuto extends CommandGroup{
	/**
	 * This will be called to drive under the low bar.
	 */
	public LowShootLowBarAuto(){
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, .5));
		//addSequential(new ToggleRollerCommand());
		addSequential(new SetIntakeSetpoint(Intake.POS_DOWN));
		addSequential(new MoveArmCommand(1, .4));
		addSequential(new MoveToResetEncoder());
		//Drive straight ahead for a bit
		addSequential(new ArmToSetpoint(0));
		addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED, 2));
		addSequential(new DriveCommand(-Drive.PORTCULLIS_SPEED, -Drive.PORTCULLIS_SPEED, 0.5));
		addSequential(new TurnUntilGyro(90));
		//addSequential(new DriveCommand(-Drive.AUTOSPEED, -Drive.AUTOSPEED,1));
		//addSequential(new FireThenReset());
		
		
		//Turn to face goal.
		//addSequential(new TurnRightUntilCamera());
		//Track and Fire
		//TODO addSequential(new TrackThenFIRELASER());
		
	}
}