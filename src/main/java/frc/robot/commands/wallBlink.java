// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.TOF;

public class wallBlink extends CommandBase {
  private TOF m_TOF;
  private LED m_LED;

  // colorR is distane to wall
  private double colorR;
private double colorL;
  /** Creates a new wallBlink. */
  public wallBlink(TOF TOF, LED LED) {
    m_TOF = TOF;
    m_LED = LED;
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(m_LED);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   colorL = m_TOF.getDistanceLeft();
   colorR = m_TOF.getDistanceRight();
   if(colorL <= 500  || colorR <= 500){
     m_LED.lightUp(1, 0, 0);
    }
    else if(colorL <= 750 || colorR <= 750){
      m_LED.lightUp(1, 1, 0);
    }else {m_LED.lightUp(0, 1, 0);}
  } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
