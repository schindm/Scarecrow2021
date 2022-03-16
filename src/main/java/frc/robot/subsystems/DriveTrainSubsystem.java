// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  private WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.FrontLeft);
  private WPI_TalonFX frontRight = new WPI_TalonFX(Constants.FrontRight);
  private WPI_TalonFX backLeft = new WPI_TalonFX(Constants.BackLeft);
  private WPI_TalonFX backRight = new WPI_TalonFX(Constants.BackRight);

  private double inchConversion = Constants.encoderInchConversion;

  /** Creates a new DriveTrainSubsystem. */
  public DriveTrainSubsystem() {
    backLeft.set(ControlMode.Follower, frontLeft.getDeviceID());
    backRight.set(ControlMode.Follower, frontRight.getDeviceID());
    frontRight.setInverted(TalonFXInvertType.CounterClockwise);
    backRight.setInverted(InvertType.FollowMaster);
    frontLeft.setInverted(TalonFXInvertType.Clockwise);
    backLeft.setInverted(InvertType.FollowMaster);

    // Makes encoders into the encoders we use
    frontLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
    frontRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void drive(double left, double right){
    frontLeft.set(left);
    frontRight.set(right);

  }

  public double getLeftEncoder(){
    double leftEncoder = frontLeft.getSelectedSensorPosition();
    leftEncoder = -leftEncoder / inchConversion; // to flip it and convert it
    SmartDashboard.putNumber("LeftEncoder", leftEncoder);

    return leftEncoder;
  }

  public double getRightEncoder(){
    double rightEncoder = frontRight.getSelectedSensorPosition();
    rightEncoder = -rightEncoder / inchConversion; // to flip the other one
    SmartDashboard.putNumber("RightEncoder", rightEncoder);

    return rightEncoder;
  }

}

