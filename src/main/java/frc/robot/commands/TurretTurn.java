/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
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
  private double targetPositionRotations;

  /**
   * Creates a new TurretTurn.
   */
  public TurretTurn(/*XboxController joystick, Turret turret*/) {
    // Use addRequirements() here to declare subsystem dependencies.
    /*m_joystick = joystick;
    m_turret = turret;
    addRequirements(turret);*/

    //double targetPositionRotations;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    addRequirements(Robot.m_turret);
    /*m_turret.turretServo.configFactoryDefault();
    m_turret.turretServo.configSelectedFeedbackSensor
    (FeedbackDevice.CTRE_MagEncoder_Relative, 
    Constants.kPIDLoopIdx,
    Constants.kTimeoutMs);

    m_turret.turretServo.setSensorPhase(Constants.kSensorPhase);
    m_turret.turretServo.setInverted(Constants.kMotorInvert);
    m_turret.turretServo.configNominalOutputForward(0, Constants.kTimeoutMs);
    m_turret.turretServo.configNominalOutputReverse(0, Constants.kTimeoutMs);
    m_turret.turretServo.configPeakOutputForward(1, Constants.kTimeoutMs);
    m_turret.turretServo.configPeakOutputReverse(-1, Constants.kTimeoutMs);
    m_turret.turretServo.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		m_turret.turretServo.config_kF(Constants.kPIDLoopIdx, Constants.kF, Constants.kTimeoutMs);
		m_turret.turretServo.config_kP(Constants.kPIDLoopIdx, Constants.kP, Constants.kTimeoutMs);
		m_turret.turretServo.config_kI(Constants.kPIDLoopIdx, Constants.kI, Constants.kTimeoutMs);
    m_turret.turretServo.config_kD(Constants.kPIDLoopIdx, Constants.kD, Constants.kTimeoutMs);
    
    int absolutePosition = m_turret.turretServo.getSensorCollection().getPulseWidthPosition();

		absolutePosition &= 0xFFF;
		if (Constants.kSensorPhase) { absolutePosition *= -1; }
		if (Constants.kMotorInvert) { absolutePosition *= -1; }
		
		m_turret.turretServo.setSelectedSensorPosition(absolutePosition, Constants.kPIDLoopIdx, Constants.kTimeoutMs);*/
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // targetPositionRotations = leftYstick * 4096
    // turretServo.set(ControlMode.Positon, targetPositionRotations);
    m_turret.setSpeed(RobotContainer.getRightX());
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