/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.functions.balllevels;
import frc.robot.functions.hatchlevels;
import frc.robot.functions.vision;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.intake;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static balllevels balllevel = new balllevels();
  public static hatchlevels hatchlevel = new hatchlevels();
  public static vision vision = new vision();
  public static DriveTrain drive = new DriveTrain();
  public static intake intake = new intake();

  Compressor comp = new Compressor(0);
    
   //timer
  Timer timer;
 
  //driver
  XboxController xbox;
 
  //co-driver stuff
  Joystick panel, panel2;
  JoystickButton ballr1, ballr2, ballr3, ballc, ballp, hatchr1, hatchr2, hatchr3, hatchungetter, hatchp, hatchc, ballpickup, manualup, manualdown; 
  JoystickButton startlight1, stoplight, hatchgetter, regcam, limecam, frontclimb, backclimb;
    
  //encoders
  Encoder u1enc, u2enc, u3enc;
   
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    xbox = new XboxController(0);
    vision.cameraOn();
    u1enc.setReverseDirection(true);
    u2enc.setReverseDirection(false);
    u3enc.setReverseDirection(true);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    u1enc.reset();
    u2enc.reset();
    u3enc.reset();
    comp.setClosedLoopControl(true);
    drive.slowDriveMode();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    
    SmartDashboard.putNumber("Up 1 Sensor Position", u1enc.getDistance());
    SmartDashboard.putNumber("Up 2 Sensor Position", u2enc.getDistance());
    SmartDashboard.putNumber("Up 3 Sensor Position", u3enc.getDistance());

    //Change gears
    if (xbox.getBumper(Hand.kRight)){
      drive.fastDriveMode();
    }

    else if (xbox.getBumper(Hand.kLeft)){
      drive.slowDriveMode();
    }

    //intake control
    if (xbox.getAButton()){
      intake.hatchIntake();
    }

    else if (xbox.getXButton()){
      intake.stopVacuum();
    }

    else if (xbox.getYButton()){
      intake.hatchRelease();
    }

    else if (xbox.getTriggerAxis(Hand.kRight) >= 0.1){
      intake.ballPickUp();
    }

    else if (xbox.getTriggerAxis(Hand.kLeft) >= 0.1){ 
      intake.ballSpitOut();
    }

    else if (hatchgetter.get()){
      intake.hatchIntakeOut();
    }

    else if (hatchungetter.get()){
      intake.hatchIntakeOut();
    }

    else {
      intake.AllowAir();
      intake.ballStop();
    }

    //ball functions
    if (ballr1.get()){
      balllevel.high();
    }

    else if (ballr2.get()){
      balllevel.middle();
    }

    else if (ballr3.get()){
      balllevel.bottom();
    }

    else if (ballp.get()){
      balllevel.player();
    }

    else if (ballpickup.get()){
      balllevel.pickup();
    }

    //hatch functions
    else if (hatchr1.get()){
      hatchlevel.top();
    }

    else if (hatchr2.get()){
      hatchlevel.middle();
    }

    else if (hatchr3.get()){
      hatchlevel.bottom();
    }

    else if (hatchp.get()){
      hatchlevel.player();
    }
  }

  /**
   * This function is called periodically during operator control.
   */

   @Override
   public void teleopInit() {
    comp.setClosedLoopControl(true);
   }

  @Override
  public void teleopPeriodic() {

    SmartDashboard.putNumber("Up 1 Sensor Position", u1enc.getDistance());
    SmartDashboard.putNumber("Up 2 Sensor Position", u2enc.getDistance());
    SmartDashboard.putNumber("Up 3 Sensor Position", u3enc.getDistance());

     //Change gears
    if (xbox.getBumper(Hand.kRight)){
      drive.fastDriveMode();
    }

    else if (xbox.getBumper(Hand.kLeft)){
      drive.slowDriveMode();
    }

    //intake control
    if (xbox.getAButton()){
      intake.hatchIntake();
    }

    else if (xbox.getXButton()){
      intake.stopVacuum();
    }

    else if (xbox.getYButton()){
      intake.hatchRelease();
    }

    else if (xbox.getTriggerAxis(Hand.kRight) >= 0.1){
      intake.ballPickUp();
    }

    else if (xbox.getTriggerAxis(Hand.kLeft) >= 0.1){ 
      intake.ballSpitOut();
    }

    else if (hatchgetter.get()){
      intake.hatchIntakeOut();
    }

    else if (hatchungetter.get()){
      intake.hatchIntakeOut();
    }

    else {
      intake.AllowAir();
      intake.ballStop();
    }

    //ball functions
    if (ballr1.get()){
      balllevel.high();
    }

    else if (ballr2.get()){
      balllevel.middle();
    }

    else if (ballr3.get()){
      balllevel.bottom();
    }

    else if (ballp.get()){
      balllevel.player();
    }

    else if (ballpickup.get()){
      balllevel.pickup();
    }

    //hatch functions
    else if (hatchr1.get()){
      hatchlevel.top();
    }

    else if (hatchr2.get()){
      hatchlevel.middle();
    }

    else if (hatchr3.get()){
      hatchlevel.bottom();
    }

    else if (hatchp.get()){
      hatchlevel.player();
    }
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
