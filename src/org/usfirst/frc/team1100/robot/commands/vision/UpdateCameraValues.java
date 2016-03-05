package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Drive;
import org.usfirst.frc.team1100.robot.subsystems.Arm;
import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UpdateCameraValues extends Command {

	NetworkTable table;

	public UpdateCameraValues() {
		requires(Vision.getInstance());
	}

	@Override
	protected void initialize() {
		requires(Vision.getInstance());
		table = NetworkTable.getTable("GRIP/myContoursReport");
	}

	@Override
	protected void execute() {

		double[] defaultValue = {};
		double[] area = table.getNumberArray("area", defaultValue);
		double[] centerY = table.getNumberArray("centerY", defaultValue);
		double[] centerX = table.getNumberArray("centerX", defaultValue);
		double[] height = table.getNumberArray("height", defaultValue);
		double[] width = table.getNumberArray("width", defaultValue);
		int index = 0;
		double max_area = 0;
		for (int i = 0; i < area.length; i++) {
			if (area[i] > max_area) {
				max_area = area[i];
				index = i;
			}
		}
		try {
			SmartDashboard.putNumber("X", centerX[index]);
			if (centerX[index] != 0) {
				Vision.getInstance().updateVal(centerX[index], centerY[index], height[index], width[index],
						area[index]);
			}
		} catch (Exception e) {
			Vision.getInstance().updateVal(0, 0, 0, 0, 0);
		}

		SmartDashboard.putNumber("Center Y", Vision.getInstance().getY());
		SmartDashboard.putNumber("CenterX", Vision.getInstance().getX());
		SmartDashboard.putNumber("Area", Vision.getInstance().getA());
		SmartDashboard.putNumber("Height", Vision.getInstance().getH());
		SmartDashboard.putNumber("Width", Vision.getInstance().getW());
		//SmartDashboard.putNumber("Gyro", Drive.getInstance().getAngle());
		SmartDashboard.putNumber("Arm Encoder", -Arm.getInstance().getEncValue());
		SmartDashboard.putNumber("Left Drive", Drive.getInstance().leftSpeed());
		SmartDashboard.putNumber("Right Drive", Drive.getInstance().rightSpeed());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
