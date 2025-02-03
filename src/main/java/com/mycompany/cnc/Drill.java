/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cnc;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 *
 * @author AdamB
 */
public class Drill {
    
    private double diameter;
    private int spindle;
    private double feed;
    private double x;
    private double y;
    private double depth;
    private double peck;
    private int toolnumber;
    
    public Drill(){
        this.diameter = diameter;
        this.spindle = spindle;
        this.feed = feed;
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.peck = peck;
        this.toolnumber = toolnumber;
    }

    public void setToolnumber(int toolnumber) {
        this.toolnumber = toolnumber;
    }

    public int getToolnumber() {
        return toolnumber;
    }
    public void setDiameter(double diameter){
        this.diameter = diameter;
        System.out.println(diameter);
    }

    public void setSpindle(int spindle) {
        this.spindle = spindle;
    }

    public void setFeed(double feed) {
        this.feed = feed;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setPeck(double peck) {
        this.peck = peck;
    }

    public double getDiameter() {
        return diameter;
    }

    public int getSpindle() {
        return spindle;
    }

    public double getFeed() {
        return feed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDepth() {
        return depth;
    }

    public double getPeck() {
        return peck;
    }
    
    public String toString(){
        return "Drill\n" + "g17g40g90\n" + "T" + getToolnumber() + "M6\ng0g54x" + getX() + "y" + getY() + "s" + getSpindle() + "m3\nz3.0m7\nf" + getFeed();
    }
    
    
}
