/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cnc;

import java.util.ArrayList;

/**
 *
 * @author AdamB
 */
public class Calculations {

    private ArrayList locations;
    private double[] nums;

    public Calculations() {
        this.locations = new ArrayList<Double>();
        this.nums = new double[2];
    }

    public double[] boltCircle(double X, double Y, double angle, double R, String round) {
        System.out.println("Sup");
        if (round.equals("2")) {
            //locations.add((roundToTwo(Math.cos(Math.toRadians(angle)) * R)) + X);
            //locations.add((roundToTwo(Math.sin(Math.toRadians(angle)) * R)) + Y);
            nums[0] = ((roundToTwo(Math.cos(Math.toRadians(angle)) * R)) + X);
            nums[1] = ((roundToTwo(Math.sin(Math.toRadians(angle)) * R)) + Y);
            
            return nums;
        }
        if (round.equals("3")) {
            System.out.println("3");
            nums[0] = ((roundToThree(Math.cos(Math.toRadians(angle)) * R)) + X);
            nums[1] = ((roundToThree(Math.sin(Math.toRadians(angle)) * R)) + Y);
            System.out.println("Before return");
            return nums;
        }
        if (round.equals("4")) {
            nums[0] = ((roundToFour(Math.cos(Math.toRadians(angle)) * R)) + X);
            nums[1] = ((roundToFour(Math.sin(Math.toRadians(angle)) * R)) + Y);
            return nums;
        }
        return null;
    }

//    public ArrayList boltCircle(double X, double Y, double angle, double R, String round) {
//        System.out.println("Sup");
//        locations.clear();
//        if (round.equals("2")) {
//            locations.add((roundToTwo(Math.cos(Math.toRadians(angle)) * R)) + X);
//            locations.add((roundToTwo(Math.sin(Math.toRadians(angle)) * R)) + Y);
//            return locations;
//        }
//        if (round.equals("3")) {
//            System.out.println("3");
//            locations.add((roundToTwo(Math.cos(Math.toRadians(angle)) * R)) + X);
//            locations.add((roundToTwo(Math.sin(Math.toRadians(angle)) * R)) + Y);
//            return locations;
//        }
//        if (round.equals("4")) {
//            locations.add((roundToTwo(Math.cos(Math.toRadians(angle)) * R)) + X);
//            locations.add((roundToTwo(Math.sin(Math.toRadians(angle)) * R)) + Y);
//            return locations;
//        }
//        return null;
//    }
    public double roundToTwo(double number) {
        return Double.valueOf(Math.round(number * 100)) / 100;
    }

    public double roundToThree(double number) {
        return Double.valueOf(Math.round(number * 1000)) / 1000;
    }

    public double roundToFour(double number) {
        return Double.valueOf(Math.round(number * 10000)) / 10000;
    }

}
