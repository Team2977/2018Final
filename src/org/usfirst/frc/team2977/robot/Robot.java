/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2977.robot;

import java.io.FileNotFoundException;

import org.usfirst.frc.team2977.robot.commands.DriveForwardAuto;
import org.usfirst.frc.team2977.robot.commands.LeftScaleAuto;
import org.usfirst.frc.team2977.robot.commands.LeftSwitchAuto;
import org.usfirst.frc.team2977.robot.commands.RightScaleAuto;
import org.usfirst.frc.team2977.robot.commands.RightSwitchAuto;
import org.usfirst.frc.team2977.robot.subsystems.ArmWinch;
import org.usfirst.frc.team2977.robot.subsystems.Chassis;
import org.usfirst.frc.team2977.robot.subsystems.Guiders;
import org.usfirst.frc.team2977.robot.subsystems.IntakeWheels;
import org.usfirst.frc.team2977.robot.subsystems.Pneumatics;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public static final Chassis chassis = new Chassis();
	public static final Pneumatics pneu = new Pneumatics();
	public static final ArmWinch armwinch = new ArmWinch();
	public static final Guiders guiders = new Guiders();
	public static final IntakeWheels intakewheels = new IntakeWheels();
	public static OI m_oi = new OI();

	Command m_autonomousCommand;
	String position;
	String preference;
	
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	
	//These are used for the autonomous positions ramdomly picked at the start of the game.
	SendableChooser<String> m_position = new SendableChooser<>();
	SendableChooser<String> m_preference = new SendableChooser<>();
	
	//these are the commands that get parsed when it checks for what auto to do.
	Command leftScaleAuto = new LeftScaleAuto();
	Command leftSwitchAuto = new LeftSwitchAuto();
	Command rightScaleAuto = new RightScaleAuto();
	Command rightSwitchAuto = new RightSwitchAuto();
	Command forwardAuto = new DriveForwardAuto();
	Command autoSelected;
	
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		Robot.chassis.gyro.calibrate();
		/**
		UsbCamera topCamera = CameraServer.getInstance().startAutomaticCapture(0);
		topCamera.setResolution(240,  240);
		topCamera.setFPS(20);
		topCamera.setBrightness(50);
		**/
		
		UsbCamera bottomCamera =  CameraServer.getInstance().startAutomaticCapture();
		bottomCamera.setResolution(240,  240);
		bottomCamera.setFPS(20);
		bottomCamera.setBrightness(20);
		
		/** ----------------------------------------------------- **/
		m_position.addObject("Right Position", "Right");
		m_position.addObject("Left Position", "Left");
		m_position.addObject("Center Position", "Center");
		SmartDashboard.putData("Starting Position", m_position);
		
		/** ----------------------------------------------------- **/
		m_preference.addObject("Switch Preferred", "Switch");
		m_preference.addObject("Scale Preferred", "Scale");
		SmartDashboard.putData("Auto Preference", m_preference);
		
		WPI_TalonSRX arm = Robot.armwinch.arm;
		arm.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 25, 10);
		arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		//Im not sure if this is going to work.
		//I will need to test this. This will write a text file of a log of what we did in a match
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public static String gameData;
	@Override
	public void autonomousInit() {
		position = m_position.getSelected();
		preference = m_preference.getSelected();
	
	gameData = DriverStation.getInstance().getGameSpecificMessage();
	SmartDashboard.putString("Game Data", gameData);
	if(gameData.length() > 0) {
		if(position == "Center") {
			autoSelected = forwardAuto;
		}
		else if(preference == "Switch") {
			if(gameData.charAt(0) == 'L' && position == "Left"){
				//Do left switch
				SmartDashboard.putString("Auto Doing", "Left Switch");
				autoSelected = leftSwitchAuto;
				} 
			else if(gameData.charAt(0) == 'R' && position == "Right") {
				//Do right switch
				SmartDashboard.putString("Auto Doing", "Right Switch");
				autoSelected = rightSwitchAuto;
			}
			else if(position == "Right" && gameData.charAt(1) == 'R') {
				//Do right scale even though we wanted to do switch. Switch is too far away.
				SmartDashboard.putString("Auto Doing", "Right Scale");
				//autoSelected = rightScaleAuto;
				autoSelected = forwardAuto;
			}
			else if(position == "Left" && gameData.charAt(1) == 'L') {
				//Do left scale even though we wanted to do switch. Switch is too far away.
				SmartDashboard.putString("Auto Doing", "Left Scale");
				//autoSelected = leftScaleAuto;
				autoSelected = forwardAuto;
			}
			else {
				autoSelected = forwardAuto;
			}
			
		}
		else if(preference == "Scale") {
			if(gameData.charAt(1) == 'L' && position == "Left"){
				//Do left scale
				SmartDashboard.putString("Auto Doing", "Left Scale");
				//autoSelected = leftScaleAuto;
				autoSelected = forwardAuto;
				} 
			else if(gameData.charAt(1) == 'R' && position == "Right") {
				//Do right scale
				SmartDashboard.putString("Auto Doing", "Right Scale");
				//autoSelected = rightScaleAuto;
				autoSelected = forwardAuto;
			}
			else if(position == "Right" && gameData.charAt(0) == 'R') {
				//Do right switch even though we wanted to do scale. Switch is too far away.
				SmartDashboard.putString("Auto Doing", "Right Switch");
				autoSelected = rightSwitchAuto;
			}
			else if(position == "Left" && gameData.charAt(0) == 'L') {
				//Do left switch even though we wanted to do scale. Switch is too far away.
				SmartDashboard.putString("Auto Doing", "Left Switch");
				autoSelected = leftSwitchAuto;
			}
		}
		else if(position == "Center") {
			SmartDashboard.putBoolean("Centered Thing", true);
			autoSelected = forwardAuto;
		}
		else {
			autoSelected = forwardAuto;
		}
		
	}
	if (autoSelected != null) {
		SmartDashboard.putString("AAA", "TTTTTT");
		autoSelected.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		}

	@Override
	public void teleopInit() {
		//I also need to see if this will work. I dont know if it will or not. 
		//I need to make sure that the flip flop buttons work.
		//Robot.pneu.TeleInit();
		if (autoSelected != null) {
			autoSelected.cancel();
		}
		}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
