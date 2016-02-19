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
	public LowBarAuto(){
		addSequential(new DriveCommand(.8, .8, 2));
		addSequential(new DriveUntilUltrasoundFront(.8, .8, 134.8));
		addSequential(new TurnCommand(45));
		addSequential(new TrackToGoal());
		addSequential(new SetIntakeSetpoint(Intake.POS_UP));
		addSequential(new FireThenReset());
	}
}