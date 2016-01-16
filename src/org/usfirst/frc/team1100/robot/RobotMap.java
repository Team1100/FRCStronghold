package org.usfirst.frc.team1100.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//t indicates temporary value
	
	//[D]RIVE TRAIN
	public static final int D_LEFT_FRONT = 1; //t
	public static final int D_LEFT_MID = 2;//t
	public static final int D_LEFT_BACK = 3;//t
	public static final int D_RIGHT_FRONT = 1;//t
	public static final int D_RIGHT_MID = 2;//t
	public static final int D_RIGHT_BACK = 3;//t
	public static final int D_GYRO = 42;//t
	//[V]ISION
	public static final int V_CAMERA = 314;//t
	//[S]HOOTER
	//[I]NTAKE
	//[J]OYSTICKS
	public static final int J_LEFT = 0;//t
	public static final int J_RIGHT = 1;//t
	public static final int J_X = 2;//t
	//[E]NCODERS
	public static final int E_POLAR_SHOOTER = 17;//t
}
