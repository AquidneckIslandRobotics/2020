/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Turret;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.XboxController;


public class TurretTurn extends CommandBase {


  private XboxController m_joystick;
  private Turret m_turret;
  private double speed; 
  //private double targetPositionRotations;

  /**
   * Creates a new TurretTurn.
   */
  public TurretTurn(Turret subsystems, double speed) {
    addRequirements(subsystems);
    m_turret = subsystems; 
    this.speed = speed; 
    
    // Use addRequirements() here to declare subsystem dependencies.
    /*m_joystick = joystick;
    m_turret = turret;
    addRequirements(turret);*/

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // targetPositionRotations = leftYstick * 4096
    // turretServo.set(ControlMode.Positon, targetPositionRotations);
    m_turret.setSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turret.stopTurret();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
