package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final Talon motor = new Talon(1); //deviceNum = 1
    Timer bumperTimer = new Timer();

    private double power;
    private boolean enabled;
    private double defaultPower = 1;

    public IntakeSubsystem() {

    }

    public void startMotor() {
        this.motor.set(this.power);
    }
    public void stopMotor() {
        this.enabled = false;
        this.motor.stopMotor();
    }
    public void intakeBtnA() {
        this.enabled = true;
        this.power = 0.8 * defaultPower;
    }
    public void outtake() { //dpad outtake
        this.enabled = true;
        this.power = -(0.5 * defaultPower);
    }
    public void bumperIntake() {
        this.enabled = true;
        this.power = defaultPower;
    }
    public void bumperOuttake() {
        this.enabled = true;
        this.power = -defaultPower;
    }
    public void joystick(double power) {
        this.enabled = true;
        this.power = power;
    }

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      if(this.enabled) {
        startMotor();
      }
    }
}
