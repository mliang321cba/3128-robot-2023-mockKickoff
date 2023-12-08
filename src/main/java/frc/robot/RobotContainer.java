// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static frc.robot.Constants.ManipulatorConstants.MOTOR_POWER;

import common.hardware.input.NAR_Joystick;
import common.utility.shuffleboard.NAR_Shuffleboard;
import frc.robot.commands.CmdManager;
import frc.robot.subsystem.Manipulator;

import static frc.robot.commands.CmdManager.*;

public class RobotContainer {
  private NAR_Joystick joystick;

  public RobotContainer() {
    joystick = new NAR_Joystick(0);
    configureButtonBindings();
    Manipulator.getInstance().initShuffleboard();
    
  }

  private void configureButtonBindings() {
    joystick.getButton(6).onTrue(intake());
    joystick.getButton(4).onTrue(outtake()).onFalse(set(0));
    joystick.getButton(5).onTrue(set(MOTOR_POWER)).onFalse(set(0));
    joystick.getButton(3).onTrue(set(-MOTOR_POWER)).onFalse(set(0));
  }

  public void updateDashboard() {
    NAR_Shuffleboard.update();
  }

}
