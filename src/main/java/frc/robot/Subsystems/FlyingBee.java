/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class FlyingBee extends Subsystem {
  DigitalInput Limit1 = new DigitalInput(1);
  DigitalInput Limit2 = new DigitalInput(2);
  WPI_TalonSRX Bee = new WPI_TalonSRX(2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Forward(){
    Bee.set(.6);
    if (Limit1.get()){
      Reverse();
    }
  }

  public void Reverse(){
    Bee.set(-.6);
    if (Limit2.get()){
      Forward();
    }
  }

  public void Stop(){
    Bee.set(0);
  }
}
