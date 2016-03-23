package org.usfirst.frc.team1100.robot.commands.shooter.groups;

import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeFAST;
import org.usfirst.frc.team1100.robot.commands.shooter.SetLatchCommand;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class FireThenResetSimultIntake extends CommandGroup{
	/**
	 * Fires by releasing latch and then resets after a second.
	 */
	public FireThenResetSimultIntake(){
		addParallel(new SetIntakeFAST(Intake.POS_UP));
		addSequential(new WaitCommand(0.2));
		addSequential(new SetLatchCommand(Value.kReverse));
		addSequential(new WaitCommand(1));
		addSequential(new ResetShooterCommandGroup());
	}
}