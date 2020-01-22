/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive extends SubsystemBase {
  TalonFX leftLeader = new TalonFX(Constants.LeftLeader);
  TalonFX leftFollower = new TalonFX(Constants.LeftFollower);
  TalonFX rightLeader = new TalonFX(Constants.RightLeader);
  TalonFX rightFollower = new TalonFX(Constants.RightFollower);
  /**
   * Creates a new Drive.
   */
  public Drive() {
   leftFollower.follow(leftLeader);
   rightFollower.follow(rightLeader);
  }

  public void curvatureDrive(double speed, double rotation, boolean quickTurn){
  }

  @Override
  public void periodic() {
    
    //This method will be called once per scheduler run
  }
}
