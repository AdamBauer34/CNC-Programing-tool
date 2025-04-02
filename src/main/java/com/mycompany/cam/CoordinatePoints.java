/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;

/**
 *
 * @author AdamB
 */
public class CoordinatePoints {

    private double x;
    private double y;
    private double z;

    public CoordinatePoints() {
        this.x = x;
        this.y = y;
    }
    
    public CoordinatePoints(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public CoordinatePoints(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public void set2d(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void set2d(CoordinatePoints points) {
       this.x = points.getX();
       this.y = points.getY();
    }
    
    public void set3d(CoordinatePoints points) {
        this.x = points.getX();
        this.y = points.getY();
        this.z = points.getZ();
    }
    
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
