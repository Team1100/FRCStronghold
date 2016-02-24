package org.usfirst.frc.team1100.robot.commands.vision;

import org.usfirst.frc.team1100.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class JerkGrouper extends CommandGroup {

	private final double target = 106;

	public JerkGrouper() {
		for(int i = 0; i<5; i++){
			x = X();
			if (x > 106) {
				addSequential(new JerkSingleCommand(1));
				addSequential(new WaitCommand(.5));
				SmartDashboard.putNumber("x",1);
			} else if (x < 106) {
				addSequential(new JerkSingleCommand(-1));
				addSequential(new WaitCommand(.5));
				SmartDashboard.putNumber("x",-1);
			}
		}
	}
	public double X(){
		NetworkTable table = NetworkTable.getTable("GRIP/myContoursReport");
		double[] defaultValue = {1, 1, 1};
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
		double x=centerX[index];
		return x;
	}
}