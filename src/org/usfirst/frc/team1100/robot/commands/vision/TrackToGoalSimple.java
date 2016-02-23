package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackToGoalSimple extends Command {

	private double targetY = 225;
	private double pos;

	public TrackToGoalSimple() {
		requires(Lift.getInstance());
	}

	@Override
	protected void initialize() {
		pos = Lift.getInstance().getEncValue();
	}

	@Override
	protected void execute() {
		Lift.getInstance().setSetpoint(pos);
		if (Vision.getInstance().getY() < targetY) {
			pos += 5;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Vision.getInstance().getY() == targetY;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
