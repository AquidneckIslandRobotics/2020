/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import frc.robot.commands.TurretTurn;


public class TurretTarget extends CommandBase {
  public double initialTurretEncoderPos;
  public double distanceInClicksTurret;

  /**
   * Creates a new TurretTarget.
   */
  public TurretTarget(/*double distanceInClicksTurret*/) {
   // addRequirements(Robot.m_turret);
    distanceInClicksTurret = 155; // Do we need this to turn?
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_turret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_turret.lightsOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xval = RobotContainer.m_turret.getLimelightX();
    double speed = xval * -0.15;
    RobotContainer.m_turret.setSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_turret.stopTurret();
    RobotContainer.m_turret.lightsOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
