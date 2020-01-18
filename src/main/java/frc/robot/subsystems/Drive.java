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
import com.ctre.phoenix.motorcontrol.can.BaseMotorController;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drive extends SubsystemBase {
    TalonSRX leftLeader = new TalonSRX(Constants.LeftLeader);
    BaseMotorController leftFollower1 = new TalonSRX(Constants.LeftFollower1);
    BaseMotorController leftFollower2 = new TalonSRX(Constants.LeftFollower2);
    TalonSRX rightLeader = new TalonSRX(Constants.RightLeader);
    BaseMotorController rightFollower1 = new TalonSRX(Constants.RightFollower1);
    BaseMotorController rightFollower2 = new TalonSRX(Constants.RightFollower2);
  /**
   * Creates a new Drive.
   */
  public Drive() {
    leftFollower1.configFactoryDefault();
    leftFollower2.configFactoryDefault();
    rightFollower1.configFactoryDefault();
    rightFollower2.configFactoryDefault();
    leftFollower1.follow(leftLeader);
    leftFollower2.follow(leftLeader);
    rightFollower1.follow(rightLeader);
    rightFollower2.follow(rightLeader);

    leftLeader.configFactoryDefault();
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
}
