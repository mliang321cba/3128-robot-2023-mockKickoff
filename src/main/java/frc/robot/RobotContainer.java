// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import common.hardware.input.NAR_Joystick;
import common.utility.shuffleboard.NAR_Shuffleboard;

public class RobotContainer {
  private NAR_Joystick joystick;

  public RobotContainer() {
    joystick = new NAR_Joystick(0);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    
  }

  public void updateDashboard() {
    NAR_Shuffleboard.update();
  }

}
