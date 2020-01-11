/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Climbing extends CommandBase {
  TalonSRX leftElevator = new TalonSRX(Constants.LeftElevator);
  TalonSRX rightElevator = new TalonSRX(Constants.RightElevator);
  /**
   * Creates a new Climbing.
   */
  public Climbing() {
    leftElevator.configFactoryDefault();
    leftElevator.follow(rightElevator);
    rightElevator.configFactoryDefault();

    rightElevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 30);
    rightElevator.configNeutralDeadband(.001, 30);
    rightElevator.setSensorPhase(false);
    rightElevator.setInverted(false);
    rightElevator.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, 30);
    rightElevator.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, 30);

    rightElevator.configNominalOutputForward(0, 30);
    rightElevator.configNominalOutputReverse(0, 30);
    rightElevator.configPeakOutputForward(0, 30);
    rightElevator.configPeakOutputReverse(0, 30);

    rightElevator.selectProfileSlot(0, 0);
    rightElevator.config_kF(0, 0, 30);
    rightElevator.config_kP(0, .00045, 30);
    rightElevator.config_kI(0, 0, 30);
    rightElevator.config_kD(0, .00045, 30);

    rightElevator.configMotionCruiseVelocity(15000, 30);
    rightElevator.configMotionAcceleration(6000, 30);

    rightElevator.setSelectedSensorPosition(0, 0, 30);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
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
