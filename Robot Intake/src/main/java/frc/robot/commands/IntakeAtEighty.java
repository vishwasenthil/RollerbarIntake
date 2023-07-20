package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeAtEighty extends CommandBase {
  private final IntakeSubsystem intake;
  private final XboxController controller;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeAtEighty(IntakeSubsystem subsystem, XboxController controller) {
    this.intake = subsystem;
    this.controller = controller;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.intake.intakeBtnA();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.intake.startMotor();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.intake.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(this.controller.getAButtonReleased()) {
      return true;
    }
    return false;
  }
}

