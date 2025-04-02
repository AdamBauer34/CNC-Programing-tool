/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;


import java.util.ArrayList;
import javafx.geometry.Point2D;

/**
 *
 * @author AdamB
 */
public class Calculations {
    
    //private Point2D cords;
    private ArrayList locations;
    private double[] nums;
    private double tempX;
    private double tempY;
    private CoordinatePoints cords;

    public Calculations() {
        this.locations = new ArrayList<Double>();
        this.nums = new double[2];
    }

    public CoordinatePoints boltCircle(double X, double Y, double angle, double R, String round) {
        System.out.println("Sup");
        if (round.equals("2")) {
            tempX = ((roundToTwo(Math.cos(Math.toRadians(angle)) * R)) + X);
            tempY = ((roundToTwo(Math.sin(Math.toRadians(angle)) * R)) + Y);
            cords.set2d(tempX,tempY);
            //cords.setLocation(tempX,tempY);
            return cords;
        }
        if (round.equals("3")) {
            System.out.println("3");
            tempX = ((roundToThree(Math.cos(Math.toRadians(angle)) * R)) + X);
            tempY = ((roundToThree(Math.sin(Math.toRadians(angle)) * R)) + Y);
            System.out.println("Before return");
            cords.set2d(tempX,tempY);
            return cords;
        }
        if (round.equals("4")) {
            tempX = ((roundToFour(Math.cos(Math.toRadians(angle)) * R)) + X);
            tempY = ((roundToFour(Math.sin(Math.toRadians(angle)) * R)) + Y);
            cords.set2d(tempX,tempY);
            return cords;
        }
        return null;
    }
    
    public double[] rectPattern(double X, double Y, double xDist, double yDist) {
        return null;
    }

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
