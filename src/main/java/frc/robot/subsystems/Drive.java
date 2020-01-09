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
    TalonSRX leftleader = new TalonSRX(Constants.leftleader);
    TalonSRX leftfollower1 = new TalonSRX(Constants.leftfollower1);
    TalonSRX leftfollower2 = new TalonSRX(Constants.leftfollower2);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
