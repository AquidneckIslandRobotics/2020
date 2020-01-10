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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Drive extends SubsystemBase {
  WPI_TalonSRX leftleader = new  WPI_TalonSRX(Constants.leftleader);
  WPI_TalonSRX leftfollower1 = new  WPI_TalonSRX(Constants.leftfollower1);
  WPI_TalonSRX leftfollower2 = new  WPI_TalonSRX(Constants.leftfollower2);
  
  WPI_TalonSRX rightleader = new  WPI_TalonSRX(Constants.rightleader);
  WPI_TalonSRX rightfollower1 = new  WPI_TalonSRX(Constants.rightfollower1);
  WPI_TalonSRX rightfollower2 = new  WPI_TalonSRX(Constants.rightfollower2);
  DifferentialDrive diffDrive = new DifferentialDrive(leftleader, rightleader);

  /**
   * Creates a new Drive.
   */
  public Drive() {
   leftfollower1.follow(leftleader);
   leftfollower2.follow(leftleader);
   rightfollower1.follow(rightleader);
   rightfollower2.follow(rightleader);

    //double speed = 0.5;
    //double rotation = 0.5;
    //boolean quickTurn = true;


 }
  public void curvatureDrive(double speed, double rotation, boolean quickTurn);  
  diffDrive.curvatureDrive(speed, rotation, quickTurn);


  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }
}
