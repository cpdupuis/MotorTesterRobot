/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SparkMaxSubsystem;
import frc.robot.subsystems.TalonSubsystem;

public class TalonCommand extends CommandBase {
  private final TalonSubsystem subsystem;
  private final DoubleSupplier throttle;

  /**
   * Creates a new SparkMaxCommand.
   */
  public TalonCommand(TalonSubsystem subsystem, DoubleSupplier throttle) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.subsystem = subsystem;
    this.throttle = throttle;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = throttle.getAsDouble();
    subsystem.setSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
