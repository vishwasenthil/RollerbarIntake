package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeAtVariableSpeed extends CommandBase {
  private final IntakeSubsystem intake;
  private final XboxController controller;

  private double power;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeAtVariableSpeed(IntakeSubsystem subsystem, XboxController controller, double power) {
    this.intake = subsystem;
    this.controller = controller;

    this.power = power;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.intake.joystick(power);
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
    if(this.controller.getLeftY() < 0.1 && this.controller.getLeftY() > -0.1) { //deadband
      return true;
    }
    return false;
  }
}

