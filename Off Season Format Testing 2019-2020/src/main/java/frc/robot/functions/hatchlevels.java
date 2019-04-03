/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.functions;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class hatchlevels extends Subsystem {
  CANSparkMax frontelv = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax middleelv = new CANSparkMax(2, MotorType.kBrushless);
  CANSparkMax backelv = new CANSparkMax(3, MotorType.kBrushless);
  Encoder u1enc = new Encoder(0, 1);
  Encoder u2enc = new Encoder(2, 3);
  Encoder u3enc = new Encoder(4, 5);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    u1enc.setReverseDirection(true);
    u2enc.setReverseDirection(false);
    u3enc.setReverseDirection(true);
  }

  public void top(){
    if (u1enc.get() <= 1775.25) {
      frontelv.set(-1);
  }

  if (u2enc.get() <= 1992.0) {
      middleelv.set(1);
  }

  if (u3enc.get() <= 1829.5) {
      backelv.set(-1);
  }

  if (u1enc.get() >= 1775.25) {
      frontelv.set(0);
  }

  if (u2enc.get() >= 1992.0) {
      middleelv.set(0);
  }

  if (u3enc.get() >= 1829.5) {
      backelv.set(0);
  }

  if (u3enc.get() >= 1829.5 && u2enc.get() >= 1992.0 && u1enc.get() >= 1775.25){
    End();
  }
  }

  public void middle(){
    if (u1enc.get() <= 1065.25) {
      frontelv.set(-1);
  }

  if (u2enc.get() <= 1068.0) {
      middleelv.set(1);
  }

  if (u3enc.get() <= 1039.25) {
      backelv.set(-1);
  }

  if (u1enc.get() >= 1065.25) {
      frontelv.set(0);
  }

  if (u2enc.get() >= 1068.0) {
      middleelv.set(0);
  }

  if (u3enc.get() >= 1039.25) {
      backelv.set(0);
  }

  if (u3enc.get() >= 1039.25 && u2enc.get() >= 1068 && u1enc.get() >= 1065.25){
    End();
  }
  }

  public void bottom(){
  if (u1enc.get() <= 313.25) {
      frontelv.set(-1);
  }
    
  if (u2enc.get() <= 82.0) {
      middleelv.set(1);
  }
    
  if (u3enc.get() <= 231) {
      backelv.set(-1);
  }
    
  if (u1enc.get() >= 313.25) {
      frontelv.set(0);
  }
    
  if (u2enc.get() >= 82.0) {
       middleelv.set(0);
  }
    
  if (u3enc.get() >= 231) {
      backelv.set(0);
  }

  if (u3enc.get() >= 231 && u2enc.get() >= 82 && u1enc.get() >= 313.25){
    End();
  }
  }

  public void player(){
    if (u1enc.get() <= 313.25) {
      frontelv.set(-1);
  }

  if (u2enc.get() <= 82.0) {
      middleelv.set(1);
  }

  if (u3enc.get() <= 231) {
      backelv.set(-1);
  }

  if (u1enc.get() >= 313.25) {
      frontelv.set(0);
  }

  if (u2enc.get() >= 82.0) {
      middleelv.set(0);
  }

  if (u3enc.get() >= 231) {
      backelv.set(0);
  }

  if (u3enc.get() >= 231 && u2enc.get() >= 82 && u1enc.get() >= 313.25){
    End();
  }
  }

  public void End(){
      frontelv.set(0);
      middleelv.set(0);
      backelv.set(0);
  }
}
