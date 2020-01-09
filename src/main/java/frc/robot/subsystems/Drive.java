/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Drive extends SubsystemBase {
  /**
   * Creates a new Drive.
   */
  public Drive() {
   TalonSRX leftLeader = new TalonSRX(Constants.LeftLeader);
   TalonSRX leftFollower1 = new TalonSRX(Constants.LeftFollower1);
   TalonSRX leftFollower2 = new TalonSRX(Constants.LeftFollower2);
   
   TalonSRX rightLeader = new TalonSRX(Constants.RightLeader);
   TalonSRX rightFollower1 = new TalonSRX(Constants.RightFollower1);
   TalonSRX rightFollower2 = new TalonSRX(Constants.RightFollower2);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
