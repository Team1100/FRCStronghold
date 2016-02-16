package org.usfirst.frc.team1100.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//TODO: t indicates temporary value
	
	//[D]RIVE TRAIN
	public static final int D_LEFT_FRONT = 9; //t
	public static final int D_LEFT_MID = 7;//t
	public static final int D_LEFT_BACK = 2;//t
	public static final int D_RIGHT_FRONT = 3;//t
	public static final int D_RIGHT_MID = 4;//t
	public static final int D_RIGHT_BACK = 5;//t
	//[V]ISION
	public static final int V_CAMERA = 314;//t
	//[S]HOOTER
	public static final int S_PCM = 1;
	public static final int S_FILL_PNEUMATIC_A = 4;
	public static final int S_RESET_PNEUMATIC_A = 2;
	public static final int S_LATCH_PNEUMATIC_A = 0;
	public static final int S_FILL_PNEUMATIC_B = 5;
	public static final int S_RESET_PNEUMATIC_B = 3;
	public static final int S_LATCH_PNEUMATIC_B = 1;
	public static final int S_KICKER_SENSOR = 1;
	
	public static final int L_CLUTCH_PNEUMATIC = 3;//t
	public static final int L_ARM_LIFT_MOTOR_1 = 8;//t
	public static final int L_ARM_LIFT_MOTOR_2 = 6;//t
	public static final int L_ARM_LIFT_ENCODER = 0;//t
	//[I]NTAKE
	public static final int I_INTAKE_ROLLER = 0;//It was 3 until Justin came along and plugged it in
	public static final int I_INTAKE_LIFT = 1;
	public static final int I_INTAKE_LIFT_POTENTIOMETER = 0;
	public static final int I_BALL_IN = 1;
	//[C]LLIMB
	public static final int C_HOOK_EXTEND_MOTOR = 2;//t
	//[J]OYSTICKS
	public static final int J_LEFT = 0;
	public static final int J_RIGHT = 1;
	public static final int J_X = 2;
	//[U]LTRASONIC
	public static final int U_EZ3 = 0;
	public static final int U_EZ1 = 1;
	public static final int U_UNKNOWN = 2;
	//[E]NCODERS AND SENSORS
	
}
