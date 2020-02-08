/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Turret;


public class Shoot extends CommandBase {
  WPI_TalonFX rightShooter = new WPI_TalonFX(Constants.RightShooter);
  WPI_TalonFX leftShooter = new WPI_TalonFX(Constants.LeftShooter);
  private XboxController m_Joystick;
  private Button m_button;
  private Turret turret;
  
  
  /**
   * Creates a new Shoot.
   */
  public Shoot(Turret turret, XboxController Joy, Button button) {
    m_Joystick = Joy;
    m_button = button;
    this.turret = turret;
    addRequirements(turret);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turret.startWheel();



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
