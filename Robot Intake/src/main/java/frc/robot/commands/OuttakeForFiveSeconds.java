package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class OuttakeForFiveSeconds extends CommandBase {
  private final IntakeSubsystem intake;
  private Timer timer = new Timer();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public OuttakeForFiveSeconds(IntakeSubsystem subsystem) {
    this.intake = subsystem;
    
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.intake.bumperOuttake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.intake.startMotor();
    timer.start();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.timer.stop();
    this.timer.reset();
    this.intake.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(this.timer.get() >= 5) {
      return true;
    }
    return false;
  }
}

