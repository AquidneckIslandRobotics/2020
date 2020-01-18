/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Turret; 

public class TurretTarget extends CommandBase {
  private Turret m_turret;
  public double initialTurretEncoderPos; 
  public double distanceInClicksTurret; 

  /**
   * Creates a new TurretTarget.
   */
  public TurretTarget(Turret turret, double distanceInClicksTurret) {
   addRequirements(turret); 
   m_turret = turret;
     distanceInClicksTurret = 155; //do we need this to get it to spin?
     
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //initialTurretEncoderPos
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
