/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //the numbers are what the CAN ID Numbers MUST be. They have not be changed as of Feb 1st 2020
    //the numbers are also where they will be plugged in on the PDP

    //Driving Motors 
    public static final int LeftLeader = 14; //this should be 14
    public static final int LeftFollower = 15; //this should be 15
    
    public static final int RightLeader = 1; //this should be 1
    public static final int RightFollower = 0; //this shoudl be 0

    //Shooter Motors 
    public static final int RightShooter = 2;  //this should be ID 2
    public static final int LeftShooter = 3; //this should be ID 3 
    public static final int HoodAngle = 4; 
    public static final int TurretRotate = 5; 
    //Lime light does not get its own motor port, but is plugged into the PDP

    //Hopper Motors
    public static final int HopperRight = 6; 
    public static final int HopperLeft = 9; 
    public static final int Feed = 10; 

    //Intake Motors
    public static final int RightIntake = 7; 
    public static final int LeftIntake = 8; 

    //Control Panel 
    public static final int ControlPanel = 11; 
    
    //Climbing 
    public static final int Climber = 13; 

	public static boolean kSensorPhase = false;
	public static int kTimeoutMs = 0;
	public static int kPIDLoopIdx = 0;
    public static boolean kMotorInvert = false;

    
    
    //Encoders
   // public static final int TurretEncoder = 0;
    public static final double DRIVE_DISTANCE = -14;
	public static final int PID_PRIMARY = 0;
    public static final int REMOTE_0 = 0; 
    
    //public static final int deviceID = 05; //this is where ever the sparkmax ID is   
    public static final int talonsrxturret = 7; 
}



