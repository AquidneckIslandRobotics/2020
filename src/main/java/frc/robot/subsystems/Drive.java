/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import com.ctre.phoenix.motorcontrol.InvertType; 

public class Drive extends SubsystemBase {
  WPI_TalonFX leftLeader = new WPI_TalonFX(Constants.LeftLeader);
  WPI_TalonFX leftFollower = new WPI_TalonFX(Constants.LeftFollower);
    
  WPI_TalonFX rightLeader = new WPI_TalonFX(Constants.RightLeader);
  WPI_TalonFX rightFollower = new WPI_TalonFX(Constants.RightFollower);
   
    DifferentialDrive diffDrive = new DifferentialDrive(leftLeader, rightLeader);
    public boolean yeeting = false;
    boolean forward = true;
  /**
   * Creates a new Drive.
   */
  public Drive() {

    leftFollower.configFactoryDefault();
    leftFollower.follow(leftLeader);
   rightFollower.configFactoryDefault();
   rightFollower.follow(rightLeader);
  


   double speed = 0.5;
   double rotation = 0.5;
   boolean quickTurn = true;  
   //diffDrive.curvatureDrive(speed, rotation, quickTurn);

leftLeader.configFactoryDefault();
   leftLeader.follow(rightLeader);
   rightLeader.configFactoryDefault();
   
   leftLeader.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.PID_PRIMARY, Constants.kTimeoutMs);
   rightLeader.configRemoteFeedbackFilter(leftLeader.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, Constants.REMOTE_0, Constants.kTimeoutMs);
   rightLeader.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor0, Constants.kTimeoutMs);
   rightLeader.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.CTRE_MagEncoder_Absolute, Constants.kTimeoutMs);
   rightLeader.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, Constants.PID_PRIMARY, Constants.kTimeoutMs);
   rightLeader.configSelectedFeedbackCoefficient(0.5, Constants.PID_PRIMARY, Constants.kTimeoutMs); 
   rightLeader.configNeutralDeadband(.001, 30);

   leftLeader.follow(rightLeader);

rightLeader.setInverted(true); 
leftLeader.setInverted(false); 

rightFollower1.setInverted(InvertType.FollowMaster); 
leftFollower1.setInverted(InvertType.FollowMaster); 

rightLeader.setSensorPhase(true); 
leftLeader.setSensorPhase(true); 

diffDrive.setRightSideInverted(false);

  //  leftLeader.setInverted(false);
  //  leftLeader.setSensorPhase(true);
  //  rightLeader.setSensorPhase(false);
  //  rightLeader.setInverted(false);

   rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
   rightLeader.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 10, 30);

    rightFollower.follow(rightLeader); 
    leftFollower.follow(leftLeader); 

    rightLeader.setInverted(true); 
    leftLeader.setInverted(false);

    rightFollower.setInverted(InvertType.FollowMaster); 
    leftFollower.setInverted(InvertType.FollowMaster); 

    rightLeader.setSensorPhase(true);
    leftLeader.setSensorPhase(true);

    diffDrive.setRightSideInverted(false); 

    

   rightLeader.configNominalOutputForward(0, 30);
   rightLeader.configNominalOutputReverse(0, 30);
   rightLeader.configPeakOutputForward(1, 30);
   rightLeader.configPeakOutputReverse(-1, 30);

   rightLeader.selectProfileSlot(0, 0);
   rightLeader.config_kF(0, 0.1, 30);
   rightLeader.config_kP(0, .4, 30);
   rightLeader.config_kI(0, .001, 30);
   rightLeader.config_kD(0, 4, 30);
   rightLeader.configMotionCruiseVelocity(3000, 30);
   rightLeader.configMotionAcceleration(937, 30);

   rightLeader.setSelectedSensorPosition(0, 0, 30);
  }
  public void curvatureDrive(double speed, double rotation, boolean quickTurn) {
    //diffDrive.curvatureDrive(speed, rotation, quickTurn);
  }
  public void setPoint(double rotation){
    rightLeader.set(ControlMode.MotionMagic, rotation);
    SmartDashboard.putNumber("error", rightLeader.getClosedLoopError(0)); 
    SmartDashboard.putNumber("Output", rightLeader.getMotorOutputPercent());

  }
  public void stop(){
    rightLeader.set(ControlMode.PercentOutput, 0);


  }



  @Override
  public void periodic() {
    SmartDashboard.putString("Mode",rightLeader.getControlMode().toString());
    SmartDashboard.putData("Drive", this);
   //System.out.println("accel"+rightLeader.getSelectedSensorVelocity());
    //double x = SmartDashboard.getNumber("SetPoing", 0);
    //rightLeader.set(ControlMode.MotionMagic, 15000);
    // This method will be called once per scheduler run
  }
  public void resetEncoder(){
    rightLeader.setSelectedSensorPosition(0);
  }
  public void flipDirection(){
    leftLeader.setInverted(!forward);
    rightLeader.setInverted(forward);
    forward = !forward;
  }
}
