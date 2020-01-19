/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

public class Drive extends SubsystemBase {
    TalonSRX leftLeader = new TalonSRX(Constants.LeftLeader);
    BaseMotorController leftFollower1 = new TalonSRX(Constants.LeftFollower1);
    BaseMotorController leftFollower2 = new TalonSRX(Constants.LeftFollower2);
    TalonSRX rightLeader = new TalonSRX(Constants.RightLeader);
    BaseMotorController rightFollower1 = new TalonSRX(Constants.RightFollower1);
    BaseMotorController rightFollower2 = new TalonSRX(Constants.RightFollower2);

    public TalonSRXConfiguration _motion_magic = new TalonSRXConfiguration();
  /**
   * Creates a new Drive.
   */
  public Drive() {
    // Setup the followers, only going to test on one side.
    leftFollower1.configFactoryDefault();
    leftFollower2.configFactoryDefault();
    leftFollower1.follow(leftLeader);
    leftFollower2.follow(leftLeader);

    // setup the leaders
    leftLeader.configFactoryDefault();

    // configure talon SRX Output and sensor direction
    leftLeader.setSensorPhase(false);
    leftLeader.setInverted(false);

    // configure sensor source for primary PID
    //leftLeader.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
    _motion_magic.primaryPID.selectedFeedbackSensor = FeedbackDevice.CTRE_MagEncoder_Relative;
    // send deadband to super small
    //leftLeader.configNeutralDeadband(0.001, 30);
    _motion_magic.neutralDeadband = 0.001;
    // set frame periods
    _motion_magic.nominalOutputForward = 0;
    _motion_magic.nominalOutputReverse = 0;
    _motion_magic.peakOutputForward = 1;
    _motion_magic.peakOutputReverse = -1;
    // config pid, acel, velocity
    _motion_magic.slot0.kF = 0.0;
    _motion_magic.slot0.kP = 0.0;
    _motion_magic.slot0.kI = 0.0;
    _motion_magic.slot0.kD = 0.0;
    _motion_magic.motionAcceleration = 6000;
    _motion_magic.motionCruiseVelocity = 15000;

  }

  public void curvatureDrive(double speed, double rotation, boolean quickTurn){
    double leftSpeed = (quickTurn?rotation:-speed * -rotation);
    double rightSpeed = (quickTurn?rotation:-speed * rotation);
    
    leftLeader.set(ControlMode.PercentOutput,leftSpeed);
    rightLeader.set(ControlMode.PercentOutput,rightSpeed);
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  public void setConfig(TalonSRXConfiguration config) {
    leftLeader.configAllSettings(config);
  }

  public void setSetpoint(double setpoint) {
    leftLeader.set(ControlMode.MotionMagic, setpoint);
  }

  public void resetEncoder(){
    leftLeader.setSelectedSensorPosition(0);
  }
}
