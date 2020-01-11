/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Elevator extends SubsystemBase {

  TalonSRX leftElevator = new TalonSRX(Constants.LeftElevator);
  TalonSRX rightElevator = new TalonSRX(Constants.RightElevator);
  
  /**
   * Creates a new Elevator.
   */
  public Elevator() {
  rightElevator.configFactoryDefault();
  rightElevator.follow(leftElevator);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
