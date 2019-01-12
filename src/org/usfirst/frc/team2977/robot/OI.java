/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2977.robot;

import org.usfirst.frc.team2977.robot.commands.ArmBack;
import org.usfirst.frc.team2977.robot.commands.ArmBackGrabCube;
import org.usfirst.frc.team2977.robot.commands.GuidersIn;
import org.usfirst.frc.team2977.robot.commands.GuidersOut;
import org.usfirst.frc.team2977.robot.commands.GuidersStop;
import org.usfirst.frc.team2977.robot.commands.GyroTurn;
import org.usfirst.frc.team2977.robot.commands.PneumaticCommands;
import org.usfirst.frc.team2977.robot.commands.RightScaleAuto;
import org.usfirst.frc.team2977.robot.commands.TopArmDown;
import org.usfirst.frc.team2977.robot.commands.TopArmStop;
import org.usfirst.frc.team2977.robot.commands.TopArmUp;
import org.usfirst.frc.team2977.robot.commands.TopArmUpOverride;
import org.usfirst.frc.team2977.robot.commands.WinchDown;
import org.usfirst.frc.team2977.robot.commands.WinchStop;
import org.usfirst.frc.team2977.robot.commands.WinchUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static int A = 1;
	public static int B = 2;
	public static int X = 3;
	public static int Y = 4;
	public static int LB = 5;
	public static int RB = 6;
	public static int Back = 7;
	public static int Start = 8;
	public static int L3 = 9;
	public static int R3 = 10;

	//This is still button mapping, we have everything called here for the joysticks and button
	Joystick stick = new Joystick(1);
	Joystick stick2 = new Joystick(2);
	Button A1 = new JoystickButton(stick, A);
	Button A2 = new JoystickButton(stick2, A);
	Button B1 = new JoystickButton(stick, B);
	Button B2 = new JoystickButton(stick2, B);
	Button X1 = new JoystickButton(stick, X);
	Button X2 = new JoystickButton(stick2, X);
	Button Y1 = new JoystickButton(stick, Y);
	Button Y2 = new JoystickButton(stick2, Y);
	Button LB1 = new JoystickButton(stick, LB);
	Button LB2 = new JoystickButton(stick2, LB);
	Button RB1 = new JoystickButton(stick, RB);
	Button RB2 = new JoystickButton(stick2, RB);
	Button Start1 = new JoystickButton(stick, Start);
	Button Start2 = new JoystickButton(stick2, Start);
	Button Back1 = new JoystickButton(stick, Back);
	Button Back2 = new JoystickButton(stick2, Back);
	Button L3_1 = new JoystickButton(stick, L3);
	Button L3_2 = new JoystickButton(stick2, L3);
	Button R3_1 = new JoystickButton(stick, R3);
	Button R3_2 = new JoystickButton(stick2, R3);
	
	public double getLeftY() {
		if (stick.getRawAxis(1) > .1 || stick.getRawAxis(1) < -.1) {
			return stick.getRawAxis(1);
		}
		else {
			return 0;
		}
		
	}
	
	public double getLeftY2() {
		if (stick2.getRawAxis(1) > .1 || stick2.getRawAxis(1) < -.1) {
			return stick2.getRawAxis(1);
		}
		else {
			return 0;
		}
		
	}
	
	public double getLeftX() {
		if (stick.getRawAxis(0) > .1 || stick.getRawAxis(0) < -.1) {
			return stick.getRawAxis(0);
		}
		
		else {
			return 0;
		}
	}
	
	public double getRightY() {
		return stick.getRawAxis(5);
	}
	
	public double getLTrigger() {
		if (stick2.getRawAxis(2) > .05 || stick2.getRawAxis(2) < -.05) {
			SmartDashboard.putNumber("Help Me L", stick.getRawAxis(2));
			return stick2.getRawAxis(2);
		}
		else {
			return 0;
		}
		
	}
	
	public double getRTrigger() {
		if (stick2.getRawAxis(3) > .05 || stick2.getRawAxis(3) < -.05) {
			SmartDashboard.putNumber("Help Me R", stick.getRawAxis(3));
			return stick2.getRawAxis(3);
		}
		else {
			return 0;
		}
		
	}
	
	public OI() {
		A1.whenPressed(new PneumaticCommands(1)); //Close Bottom Claw
		B1.whenPressed(new PneumaticCommands(2)); //BottomClawClose //Open Top Claw
		X1.whenPressed(new PneumaticCommands(3)); //LowArmUp
		Y1.whenPressed(new PneumaticCommands(4)); //LowArmDown
		
		LB2.whenPressed(new PneumaticCommands(5)); //TopClawOpen  //
		RB2.whenPressed(new PneumaticCommands(6)); //TopClawClose

		R3_1.whileHeld(new WinchDown());
		R3_1.whenReleased(new WinchStop());
		L3_1.whileHeld(new WinchUp());
		L3_1.whenReleased(new WinchStop());
		
		Back2.whenPressed(new TopArmUpOverride());
		Back2.whenReleased(new TopArmStop());
		Start1.whenPressed(new ArmBackGrabCube());
		Back1.whenPressed(new ArmBack());
		/**
		LB1.whileHeld(new GuidersIn());
		RB1.whenReleased(new GuidersStop());
		RB1.whileHeld(new GuidersOut());
		LB1.whenReleased(new GuidersStop());
		**/
		
		//Controller 2 Commands
		A2.whileHeld(new TopArmDown());
		A2.whenReleased(new TopArmStop());
		B2.whileHeld(new TopArmUp());
		B2.whenReleased(new TopArmStop());
		X2.whileHeld(new GyroTurn(-75, .7));
	}
}
