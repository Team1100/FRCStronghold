package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.drive.DriveCommand;
import org.usfirst.frc.team1100.robot.commands.drive.TurnCommand;
import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.ultrasound.DriveUntilUltrasoundFront;
import org.usfirst.frc.team1100.robot.commands.vision.TrackToGoal;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAuto extends CommandGroup{
	/**
	 * This will be called to drive under the low bar.
	 */
	public LowBarAuto(){
		//Drive forward for 2 seconds.
		addSequential(new DriveCommand(.8, .8, 2));
		//Drive until we are a distance from the wall.
		addSequential(new DriveUntilUltrasoundFront(.8, .8, 134.8));
		//Turn to face goal.
		addSequential(new TurnCommand(45));
		//Aim to fire
		addSequential(new TrackToGoal());
		//Raise intake out of way
		addSequential(new SetIntakeSetpoint(Intake.POS_UP));
		//Fire then reset
		addSequential(new FireThenReset());
	}
}