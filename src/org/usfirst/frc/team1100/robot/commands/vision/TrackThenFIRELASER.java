package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeFAST;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * @author zacha
 * This command tracks the goal and then begins to CHARGE ITS LASER
 * AAAAAAAAAAAAARRRRRBLBLBLBLLBLBLBLBLBLBLBLBLBLBLBLBLBLBLBLBLBL
 */
public class TrackThenFIRELASER extends CommandGroup{
	public TrackThenFIRELASER(){
		addSequential(new JerkGrouper());
		addSequential(new WidthToEncoderMovement());
		addSequential(new SetIntakeFAST(Intake.POS_UP));
		//I'M A FIRIN' MAH LASER
		addSequential(new FireThenReset());
	}
}