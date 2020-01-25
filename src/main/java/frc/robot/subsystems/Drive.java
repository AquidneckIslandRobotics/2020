/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

public class Drive extends SubsystemBase {
  public WPI_TalonSRX leftLeader = new WPI_TalonSRX(Constants.LeftLeader);
  public WPI_TalonSRX leftFollower1 = new WPI_TalonSRX(Constants.LeftFollower1);
  public WPI_TalonSRX leftFollower2 = new WPI_TalonSRX(Constants.LeftFollower2);
  public WPI_TalonSRX rightLeader = new WPI_TalonSRX(Constants.RightLeader);
  public WPI_TalonSRX rightFollower1 = new WPI_TalonSRX(Constants.RightFollower1);
  public WPI_TalonSRX rightFollower2 = new WPI_TalonSRX(Constants.RightFollower2);
  DifferentialDrive diffDrive = new DifferentialDrive(leftLeader, rightLeader);
  PigeonIMU _pidgey;

  final int kPigeonID = 30;
  /**
   * Creates a new Drive.
   */
  public Drive() {
    System.out.println("Starting Drive");
   leftFollower1.follow(leftLeader);
   leftFollower2.follow(leftLeader);
   rightFollower1.follow(rightLeader);
   rightFollower2.follow(rightLeader);

   double speed = 0.5;
   double rotation = 0.5;
   boolean quickTurn = true;
   diffDrive.curvatureDrive(speed, rotation, quickTurn);

    _pidgey = new PigeonIMU(kPigeonID);
  }
  public void curvatureDrive(double speed, double rotation, boolean quickTurn){
    diffDrive.curvatureDrive(speed, rotation, quickTurn);
  }

  @Override
  public void periodic() {
    double [] accumgyro = new double [3];
    _pidgey.getAccumGyro(accumgyro);
    System.out.println("X: " + accumgyro[0] + " Y: " + accumgyro[1] + " Z: " +accumgyro[2]) ;

      }    
    
    // This method will be called once per scheduler run
  }

