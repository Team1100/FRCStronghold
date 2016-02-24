package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;

public class CenterXAdjust extends Command {

	private double turns;
	private double target;

	public CenterXAdjust() {
		requires(Drive.getInstance());
	}

	@Override
	protected void initialize() {
		turns = 0;
		target = 160;
		setTimeout(0);
	}

	@Override
	protected void execute() {
		if (isTimedOut()) {
			if (Vision.getInstance().getX() > target) {
				Drive.getInstance().driveTank(-.6, .4);
			}
			if (Vision.getInstance().getX() < target) {
				Drive.getInstance().driveTank(.4, -.6);
			}
			setTimeout(.5);
			Drive.getInstance().stop();
			setTimeout(.2);
		}
		turns++;
	}

	@Override
	protected boolean isFinished() {
		return turns > 5;
	}

	@Override
	protected void end() {
		Drive.getInstance().stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}