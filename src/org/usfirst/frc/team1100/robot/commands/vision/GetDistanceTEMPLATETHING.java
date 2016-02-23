package org.usfirst.frc.team1100.robot.commands.vision;

public class GetDistanceTEMPLATETHING {
	static double x = 36;
	
	static double possibleWorkingVersion = (-(5.569 * Math.pow(10, -6))*Math.pow(x, 6)) + (1.769 * Math.pow(10, -3)
			* Math.pow(x, 5)) + (-0.231 * Math.pow(x, 4)) + (15.911 * Math.pow(x, 3))
			+ (-607.383 * Math.pow(x, 2)) + (12192.185*x) + (-1.003 * Math.pow(10, 5));
	
	double part1 = -5.569;
	
	public static void main(String[] args) {
		System.out.println(possibleWorkingVersion);
	}
}
