/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drive extends SubsystemBase {
  WPI_TalonSRX leftLeader = new WPI_TalonSRX(Constants.LeftLeader);
   WPI_TalonSRX leftFollower1 = new WPI_TalonSRX(Constants.LeftFollower1);
   WPI_TalonSRX leftFollower2 = new WPI_TalonSRX(Constants.LeftFollower2);
   
   WPI_TalonSRX rightLeader = new WPI_TalonSRX(Constants.RightLeader);
   WPI_TalonSRX rightFollower1 = new WPI_TalonSRX(Constants.RightFollower1);
   WPI_TalonSRX rightFollower2 = new WPI_TalonSRX(Constants.RightFollower2);
   DifferentialDrive diffDrive = new DifferentialDrive(leftLeader, rightLeader); 
=======
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drive extends SubsystemBase {
  WPI_TalonSRX leftLeader = new WPI_TalonSRX(Constants.LeftLeader);
    WPI_TalonSRX leftFollower1 = new WPI_TalonSRX(Constants.LeftFollower1);
    WPI_TalonSRX leftFollower2 = new WPI_TalonSRX(Constants.LeftFollower2);
    WPI_TalonSRX rightLeader = new WPI_TalonSRX(Constants.RightLeader);
    WPI_TalonSRX rightFollower1 = new WPI_TalonSRX(Constants.RightFollower1);
    WPI_TalonSRX rightFollower2 = new WPI_TalonSRX(Constants.RightFollower2);
    DifferentialDrive diffDrive = new DifferentialDrive(leftLeader, rightLeader);
>>>>>>> 63b5df266423e93493e1f033140b4fad0c1525de
  /**
   * Creates a new Drive.
   */
  public Drive() {
<<<<<<< HEAD
    leftFollower1.follow(leftLeader);
    leftFollower2.follow(leftLeader);
    rightFollower1.follow(rightLeader);
    rightFollower2.follow(rightLeader);

  }

   public void curvatureDrive(double speed, double rotation, boolean quickTurn) {
    diffDrive.curvatureDrive(speed, rotation, quickTurn);
   
=======
   leftFollower1.follow(leftLeader);
   leftFollower2.follow(leftLeader);
   rightFollower1.follow(rightLeader);
   rightFollower2.follow(rightLeader);

   double speed = 0.5;
   double rotation = 0.5;
   boolean quickTurn = true;
   diffDrive.curvatureDrive(speed, rotation, quickTurn);


  }
  public void curvatureDrive(double speed, double rotation, boolean quickTurn){
    diffDrive.curvatureDrive(speed, rotation, quickTurn);
>>>>>>> 63b5df266423e93493e1f033140b4fad0c1525de
  }

  @Override
  public void periodic() {
<<<<<<< HEAD
    // This method will be called once per scheduler run
    
=======
    
    // This method will be called once per scheduler run
>>>>>>> 63b5df266423e93493e1f033140b4fad0c1525de
  }
}
