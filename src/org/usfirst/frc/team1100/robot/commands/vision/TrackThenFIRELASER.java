package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.commands.intake.SetIntakeFAST;
import org.usfirst.frc.team1100.robot.commands.shooter.groups.FireThenReset;
import org.usfirst.frc.team1100.robot.commands.vision.toberemoved.CenterYAdjust;
import org.usfirst.frc.team1100.robot.subsystems.Intake;
import org.usfirst.frc.team1100.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 * @author zacha
 * This command tracks the goal and then begins to CHARGE ITS LASER
 * AAAAAAAAAAAAARRRRRBLBLBLBLLBLBLBLBLBLBLBLBLBLBLBLBLBLBLBLBLBL
 */
public class TrackThenFIRELASER extends CommandGroup{
	public TrackThenFIRELASER(){
		if(Shooter.getInstance().isInAuto()&&!Shooter.getInstance().shootInAuto())
			this.cancel();
		addSequential(new CenterXAdjust());
		addSequential(new CenterYAdjust());
		addSequential(new SetIntakeFAST(Intake.POS_UP));
		//I'M A FIRIN' MAH LASER
		addSequential(new FireThenReset());
	}
}