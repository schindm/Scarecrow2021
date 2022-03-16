// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //drive train IDs

    public static final int FrontLeft = 1;
    public static final int FrontRight = 2;
    public static final int BackLeft = 3;
    public static final int BackRight = 4;

    //TOF Sensors

    public static final int TOFLeft = 0;
    public static final int TOFRight = 1;

    // Conversion

    public static final double encoderInchConversion = 8100 / 12.5; // 648    #ticks / 648 = #inches
    // the ticks per rotation are SUPER loose, basically eyeballed - not good but will work



}
