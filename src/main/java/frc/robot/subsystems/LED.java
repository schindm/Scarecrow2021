// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.CANifier;

/** Add your docs here. */
public class LED extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private CANifier canifier = new CANifier(7);
// makes the light green
public void lightUp (double R, double G, double B) {
  canifier.setLEDOutput(G, CANifier.LEDChannel.LEDChannelA); //Greeen
  canifier.setLEDOutput(R, CANifier.LEDChannel.LEDChannelB); //Red
  canifier.setLEDOutput(B, CANifier.LEDChannel.LEDChannelC); //Blue

  }
}