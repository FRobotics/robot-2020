package frc.robot.base.subsystem.motor;

import com.ctre.phoenix.motorcontrol.can.BaseMotorController;

/**
 * A pair of phoenix motors where a child follows a parent
 */
public class PhoenixDriveMotorPair implements EncoderMotor {

    private PhoenixMotor parent;
    private PhoenixMotor child;

    public PhoenixDriveMotorPair(BaseMotorController parent, BaseMotorController child, EncoderMotorConfig config) {
        this.parent = new PhoenixMotor(parent, config);
        this.child = new PhoenixMotor(child);
        this.child.follow(this.parent);
    }

    @Override
    public void setVelocity(double velocity) {
        parent.setVelocity(velocity);
    }

    @Override
    public void setPercentOutput(double percent) {
        parent.setPercentOutput(percent);
    }

    @Override
    public double getVelocity() {
        return parent.getVelocity();
    }

    @Override
    public double getOutputPercent() {
        return parent.getOutputPercent();
    }

    @Override
    public EncoderMotor setInverted(boolean inverted) {
        parent.setInverted(inverted);
        child.setInverted(inverted);
        return this;
    }

    @Override
    public EncoderMotor invert() {
        parent.invert();
        child.invert();
        return this;
    }

    @Override
    public double getDistance() {
        return parent.getDistance();
    }

    @Override
    public void resetDistance() {
        parent.resetDistance();
        child.resetDistance();
    }

    @Override
    public void setConfig(EncoderMotorConfig config) {
        parent.setConfig(config);
    }
}