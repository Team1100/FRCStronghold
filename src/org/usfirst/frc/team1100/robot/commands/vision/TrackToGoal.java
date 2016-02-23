package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Lift;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TrackToGoal extends Command {

	private NetworkTable table;
	double[] defaultValue;

	private double initialY;
	private double initialX;
	private double finalX;
	private double deltaX;
	private double finalY;
	private double deltaY;
	private double yToEncoderRatio;
	private double encoderTarget;
	private double gyroTarget;
	private double gyroStart;
	private double gyroStart2;
	private double encoderStart;
	private double encoderStart2;
	
	private final double ENCODER_DELTA = 0;
	private final double GYRO_DELTA = 0;
	
	private boolean isFinished;
	
	private boolean firstStageFinishedY;
	private boolean targetYCalculated;
	private boolean xStarted;
	private boolean firstStageFinishedX;
	private boolean xCalculated;

	private double centerYtarget = 225; //TODO: find real values
	private double centerXtarget = 130;
	
	/**
	 * Moves the drive and intake to face the goal based
	 * off of what the camera sees.
	 */
	public TrackToGoal(){
		requires(Lift.getInstance());
		//requires(Drive.getInstance());
	}
	
	@Override
	protected void initialize() {

		isFinished = false;
		firstStageFinishedY = false;
		targetYCalculated = false;
		firstStageFinishedX = false;
		xCalculated = false;
		xStarted = false;
		
		initialY = Vision.getInstance().getY();
		encoderStart = Lift.getInstance().getPosition();
		}

	@Override
	protected void execute() {
		if(!firstStageFinishedY){
			Lift.getInstance().setSetpoint(encoderStart+ENCODER_DELTA);
			Lift.getInstance().enable();
			if(Lift.getInstance().onTarget()){
				firstStageFinishedY = true;
				Lift.getInstance().disable();
			}
		}
		else if(firstStageFinishedY && !targetYCalculated){
			//initialX = centerX[index];
			finalY = Vision.getInstance().getY();
			deltaY = finalY-initialY;
			yToEncoderRatio = deltaY/ENCODER_DELTA;
			double yToMove = centerYtarget-finalY;
			encoderTarget = yToMove/yToEncoderRatio;
			encoderStart2 = Lift.getInstance().getPosition();
			targetYCalculated = true;
		}
		else if(targetYCalculated){
			Lift.getInstance().setSetpoint(encoderStart2+encoderTarget);
			Lift.getInstance().enable();
		}
		/*if(targetYCalculated && !xStarted){
			gyroStart = Drive.getInstance().getPosition();
			xStarted = true;
		}
		if(xStarted&&!firstStageFinishedX){
			Drive.getInstance().setSetpoint(gyroStart+GYRO_DELTA);
			Drive.getInstance().enable();
			if(Drive.getInstance().onTarget()){
				firstStageFinishedX = true;
				Drive.getInstance().disable();
			}
		}
		if(firstStageFinishedX&&!xCalculated){
			double[] area = table.getNumberArray("area", defaultValue);
			double[] centerX = table.getNumberArray("centerX", defaultValue);
			int index = 0;
			double max_area = 0;
			for (int i = 0; i < area.length; i++) {
				if (area[i] > max_area) {
					max_area = area[i];
					index = i;
				}
			}
			double x = centerX[index];
			finalX = x;
			deltaX = finalX-initialX;
			double xToGyroRatio = deltaY/ENCODER_DELTA;
			double xToMove = centerXtarget-finalX;
			gyroTarget = xToMove/xToGyroRatio;
			gyroStart2 = Drive.getInstance().getPosition();
			xCalculated = true;
		}
		if(xCalculated){
			Drive.getInstance().setSetpoint(gyroStart2 + gyroTarget);
			Drive.getInstance().enable();
		}*/
		if(targetYCalculated&&Lift.getInstance().onTarget()){
			Lift.getInstance().disable();
			Drive.getInstance().disable();
			isFinished = true;
		}
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		Lift.getInstance().moveArm(0);
		Lift.getInstance().disable();
		Drive.getInstance().driveTank(0, 0);
		Drive.getInstance().disable();
	}

	@Override
	protected void interrupted() {
		end();
	}

}