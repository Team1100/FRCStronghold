package org.usfirst.frc.team1100.robot.commands.auto;

import org.usfirst.frc.team1100.robot.commands.arm.SetLiftSetpoint;
import org.usfirst.frc.team1100.robot.commands.drive.DriveStraight;
import org.usfirst.frc.team1100.robot.commands.drive.TurnCommand;
import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeSetpoint;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.TrackToGoal;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowBarAuto extends CommandGroup{
	/**
	 * This will be called to drive under the low bar.
	 */
	public LowBarAuto(){
		//Drive straight ahead for a bit
		addSequential(new DriveStraight(.7, 4));
		//Turn to face goal.
		addSequential(new TurnCommand(45));
		//Raise arm after going under
		//addSequential(new SetLiftSetpoint(Lift.POS_FORTY_FIVE));
		//Aim to fire
		addSequential(new TrackToGoal());
		//Raise intake out of way
		addSequential(new SetIntakeSetpoint(Intake.POS_UP));
		//Fire then reset
		addSequential(new FireThenReset());
	}
}