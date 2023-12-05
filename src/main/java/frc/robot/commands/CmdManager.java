package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;

import static edu.wpi.first.wpilibj2.command.Commands.runOnce;

import common.hardware.input.NAR_Joystick;
import common.utility.shuffleboard.NAR_Shuffleboard;

import frc.robot.subsystem.Manipulator;

public class CmdManager {
    private static Manipulator manipulator = Manipulator.getInstance();
    public CmdManager() {}   
    
    public static CommandBase set(double power){
        return runOnce(() -> manipulator.set(power));
    }
 
}
