/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class intake extends Subsystem {
  WPI_VictorSPX vac = new WPI_VictorSPX(5);
  WPI_VictorSPX intakeR = new WPI_VictorSPX(6);
  WPI_VictorSPX intakeL = new WPI_VictorSPX(8);
  DoubleSolenoid hatcher = new DoubleSolenoid(2, 3);
  Solenoid vacrelease = new Solenoid(4);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ballPickUp(){
    intakeR.set(-.6);
    intakeL.set(-.6);
  }

  public void ballSpitOut(){
    intakeR.set(1);
    intakeL.set(1);
  }

  public void ballStop(){
    intakeR.set(0);
    intakeL.set(0);
  }

  public void hatchIntake(){
    vac.set(1);
  }

  public void hatchIntakeOut(){
    hatcher.set(DoubleSolenoid.Value.kForward);
  }

  public void hatchIntakeIn(){
    hatcher.set(DoubleSolenoid.Value.kReverse);
  }

  public void stopVacuum(){
    vac.set(0);
  }

  public void hatchRelease(){
    vacrelease.set(true);
  }

  public void AllowAir(){
    vacrelease.set(false);
  }
}
