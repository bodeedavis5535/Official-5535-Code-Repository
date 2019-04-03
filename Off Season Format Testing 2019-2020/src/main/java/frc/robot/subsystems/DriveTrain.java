/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
CANSparkMax frontLeft = new CANSparkMax(0, MotorType.kBrushless);
CANSparkMax rearLeft = new CANSparkMax(1, MotorType.kBrushless);
SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, rearLeft);
CANSparkMax frontRight = new CANSparkMax(2, MotorType.kBrushless);
CANSparkMax rearRight = new CANSparkMax(3, MotorType.kBrushless);
SpeedControllerGroup right = new SpeedControllerGroup(frontRight, rearRight);
DifferentialDrive drive = new DifferentialDrive(left, right);
XboxController xbox = new XboxController(0);
DoubleSolenoid gearswitch = new DoubleSolenoid(0, 1);

  @Override
  public void initDefaultCommand() {
  }

  public void slowDriveMode(){    
    //speed ramp
    frontLeft.setOpenLoopRampRate(.5);
    frontRight.setOpenLoopRampRate(.5);
    rearLeft.setOpenLoopRampRate(.5);
    rearRight.setOpenLoopRampRate(.5);
    drive.curvatureDrive(-xbox.getRawAxis(1), xbox.getRawAxis(4), true);
    gearswitch.set(DoubleSolenoid.Value.kReverse);
  }

  public void fastDriveMode(){
    //speed ramp
    frontLeft.setOpenLoopRampRate(.7);
    frontRight.setOpenLoopRampRate(.7);
    rearLeft.setOpenLoopRampRate(.7);
    rearRight.setOpenLoopRampRate(.7);
    drive.curvatureDrive(-xbox.getRawAxis(1), xbox.getRawAxis(4), false);
    gearswitch.set(DoubleSolenoid.Value.kForward);
  }

  public void autoMode(){    
    //speed ramp
    frontLeft.setOpenLoopRampRate(.7);
    frontRight.setOpenLoopRampRate(.7);
    rearLeft.setOpenLoopRampRate(.7);
    rearRight.setOpenLoopRampRate(.7);
  }
}
