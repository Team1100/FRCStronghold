package org.usfirst.frc.team1100.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//TODO: t indicates temporary value
	
	private static final int MOTOR_0 = 0;
	private static final int MOTOR_1 = 1;
	private static final int MOTOR_2 = 2;
	private static final int MOTOR_3 = 3;
	private static final int MOTOR_4 = 4;
	private static final int MOTOR_5 = 5;
	private static final int MOTOR_6 = 6;
	private static final int MOTOR_7 = 7;
	private static final int MOTOR_8 = 8;
	private static final int MOTOR_9 = 9;
	
	private static final int PNEUM_0 = 0;
	private static final int PNEUM_1 = 1;
	private static final int PNEUM_2 = 2;
	private static final int PNEUM_3 = 3;
	private static final int PNEUM_4 = 4;
	private static final int PNEUM_5 = 5;
	
	private static final int CAN_0 = 0;
	private static final int CAN_1 = 1;
	
	private static final int USB_0 = 0;
	private static final int USB_1 = 1;
	private static final int USB_2 = 2;
	
	private static final int ANALOG_0 = 0;
	private static final int ANALOG_1 = 1;
	private static final int ANALOG_2 = 2;
	private static final int ANALOG_3 = 3;
	private static final int ANALOG_4 = 4;
	
	private static final int DIGITAL_0 = 0;
	private static final int DIGITAL_1 = 1;
	private static final int DIGITAL_2 = 2;
	private static final int DIGITAL_3 = 3;
	private static final int DIGITAL_4 = 4;
	
	//[D]RIVE TRAIN
	public static final int D_LEFT_FRONT = MOTOR_4; //t
	public static final int D_LEFT_BACK = MOTOR_5;//t
	public static final int D_RIGHT_FRONT = MOTOR_6;//t
	public static final int D_RIGHT_BACK = MOTOR_7;//t
	//[S]HOOTER
	public static final int S_PCM = CAN_1;
	
	public static final int S_FILL_PNEUMATIC_A = PNEUM_4;
	public static final int S_RESET_PNEUMATIC_A = PNEUM_2;
	public static final int S_LATCH_PNEUMATIC_A = PNEUM_0;
	public static final int S_FILL_PNEUMATIC_B = PNEUM_5;
	public static final int S_RESET_PNEUMATIC_B = PNEUM_3;
	public static final int S_LATCH_PNEUMATIC_B = PNEUM_1;
	
	public static final int L_ARM_LIFT_MOTOR_1 = MOTOR_2;
	public static final int L_ARM_LIFT_MOTOR_2 = MOTOR_3;
	public static final int L_ARM_ENC_A = DIGITAL_1;
	public static final int L_ARM_ENC_B = DIGITAL_2;
	//[I]NTAKE
	public static final int I_INTAKE_ROLLER = MOTOR_0;
	public static final int I_INTAKE_LIFT = MOTOR_1;
	public static final int I_INTAKE_LIFT_POTENTIOMETER = ANALOG_0;
	public static final int I_BALL_IN = DIGITAL_0;
	//[C]LLIMB
	public static final int C_HOOK_EXTEND_MOTOR_1 = MOTOR_8;//t
	public static final int C_HOOK_EXTEND_MOTOR_2 = MOTOR_9;//t
	//[J]OYSTICKS
	public static final int J_LEFT = USB_0;
	public static final int J_RIGHT = USB_1;
	public static final int J_X = USB_2;
	//[U]LTRASONIC
	public static final int U_EZ3 = ANALOG_1;//t
	public static final int U_EZ1 = ANALOG_2;//t
	
}
