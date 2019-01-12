package org.usfirst.frc.team2977.robot.subsystems;

import org.usfirst.frc.team2977.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	/*
	public DigitalInput rotatecounter = new DigitalInput(1);
	public DigitalInput rotateclock = new DigitalInput(2);
	public DigitalInput pOut = new DigitalInput(3);
	public DigitalInput pIn = new DigitalInput(4);
	*/
	
	public int autoMode = 0;
	public int autoStart = 0; // 0 = L, 1 = M, 2 = R
	public int autoSide = 0; // 0 = L, 1 = R
	
	public boolean lowArm;
	public Boolean done = false;
	public DigitalInput lowerArm = new DigitalInput(0);
	public Boolean isDIrequired = true; // Is the Digital Input Required to finish the command?
	Compressor compressor = new Compressor(0);
	
	//Solenoid bottomPushOut = new Solenoid(0); // Pushy thing go out
	//Solenoid bottomPushIn = new Solenoid(1); // Pushy thing go in
	DoubleSolenoid bottomClaw = new DoubleSolenoid(0, 1);
	
	//Solenoid topPushOut = new Solenoid(4); // Spinny thing spin
	//Solenoid topPushIn = new Solenoid(5); // Spinny thing stop spin
	DoubleSolenoid topClaw = new DoubleSolenoid(4, 5);
	
	//Solenoid armUp = new Solenoid(RobotMap.ArmUpSolenoid);
	//Solenoid armDown = new Solenoid(RobotMap.ArmDownSolenoid);
	DoubleSolenoid arm = new DoubleSolenoid(RobotMap.ArmUpSolenoid, RobotMap.ArmDownSolenoid);

	public void BottomClawOpen() {
		//bottomClaw.set(DoubleSolenoid.Value.kForward);
		topClaw.set(DoubleSolenoid.Value.kReverse);
		}
	
	public void BottomClawClosed(){
		//bottomClaw.set(DoubleSolenoid.Value.kReverse);
		topClaw.set(DoubleSolenoid.Value.kForward);
		}
	
	public boolean LowArmUp() {
		arm.set(DoubleSolenoid.Value.kForward);
		return !lowerArm.get();
		}
	
	public void LowArmDown() {
		arm.set(DoubleSolenoid.Value.kReverse);
		}
	
	public void TopClawClosed() {
		bottomClaw.set(DoubleSolenoid.Value.kForward);
		}
	
	public void TopClawOpen() {
		//topClaw.set(DoubleSolenoid.Value.kReverse);
		bottomClaw.set(DoubleSolenoid.Value.kReverse);
		}
	public void TeleInit() {
		BottomClawClosed();
		TopClawClosed();
	}
	
    public void initDefaultCommand() {
    	//There are no default commands needed.
    }
}

