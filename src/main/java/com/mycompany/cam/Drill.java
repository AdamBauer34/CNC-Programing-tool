/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;

/**
 *
 * @author AdamB
 */
public class Drill {

    private Nnumber N;
    private BlockNumber bN;
    private int bNum;
    //private Point2D cords;
    private CoordinatePoints cords;
    //private Point2D.Double tempCord;
    private double diameter;
    private int spindle;
    private double feed;
    private double x;
    private double y;
    private double depth;
    private double peck;
    private int toolnumber;
    private BigDecimal absDepth;
    private BigDecimal absPeck;
    private ArrayList<CoordinatePoints> locations;
    //private ArrayList<Point2D> locations;
    private double safe;
    private double drillRetract;
    private Calculations calculations;

    public Drill() {
        this.bNum = bNum;
        this.N = Nnumber.getInstance();
        this.bN = BlockNumber.getInstance();
        this.safe = safe;
        this.drillRetract = drillRetract;
        this.locations = new ArrayList<CoordinatePoints>();
        this.diameter = diameter;
        this.spindle = spindle;
        this.feed = feed;
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.peck = peck;
        this.toolnumber = toolnumber;
        this.cords = new CoordinatePoints();
        this.absDepth = new BigDecimal("0.0");
        this.absPeck = new BigDecimal("0.0");
        this.calculations = new Calculations();
    }
    
    //Drill copy constructor
    public Drill(Drill drill) {
        this.bNum = drill.bNum;
        this.N = drill.N;
        this.bN = drill.bN;
        this.safe = drill.safe;
        this.drillRetract = drillRetract;
        this.locations = new ArrayList<CoordinatePoints>(drill.locations);
        for(CoordinatePoints i : this.locations) {
            drill.locations.add(i);
        }
        this.diameter = drill.diameter;
        this.spindle = drill.spindle;
        this.feed = drill.feed;
        this.x = drill.x;
        this.y = drill.y;
        this.depth = drill.depth;
        this.peck = drill.peck;
        this.toolnumber = drill.toolnumber;
        this.cords = drill.cords;
        this.absDepth = drill.absDepth;
        this.absPeck = drill.absPeck;
        this.calculations = drill.calculations;
    }

    public void setSafe(double safe) {
        this.safe = safe;
    }
    
    public void setBlockNum() {
        bNum = bN.getNumber();
    }
    
    public int getBlockNum() {
        return bNum;
    }

    public void setDrillRetract(double drillRetract) {
        this.drillRetract = drillRetract;
    }

    public double getSafe() {
        return safe;
    }

    public double getDrillRetract() {
        return drillRetract;
    }

    public void setToolnumber(int toolnumber) {
        this.toolnumber = toolnumber;
    }

    public int getToolnumber() {
        return toolnumber;
    }

    public void setDiameter(double diameter) {
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
        absDepth = BigDecimal.valueOf(depth);
    }

    public void setPeck(double peck) {
        this.peck = peck;
        absPeck = BigDecimal.valueOf(peck);
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

    public ArrayList getLocations() {
        return locations;
    }

    public void addLocations(double X, double Y) {
        locations.add(new CoordinatePoints(X,Y)); 
    }
    
    public void cleanLocations() {
        locations.clear();
    }
    
    

    public void drillCycle() {
        System.out.println("Drill Cycle Loop Called");
        BigDecimal index = new BigDecimal("0.0");
        //add in saftey distance Z, for now just using 0.1
        //double safe = 0.10;
        toolCallSetup();
        System.out.println("");
        Printable.writer.println("\n(Start of drill Cycle)");
        System.out.println("Location size" + locations.size());
        //Negative drill value. need to fix this here with peck
        for (int i = 0; i < locations.size(); i++) {
            cords.set2d(locations.get(i));
            Printable.writer.println("\n(Start of Drill)");
            index = new BigDecimal("0.0");
            Printable.writer.println(N.addToN() + " G0 X" + cords.getX() + " Y" + cords.getY());
            //Printable.writer.println("G0 Z" + safe);
            
            while (index.doubleValue() < Math.abs(absDepth.doubleValue())) {
                index = index.add(absPeck);
                System.out.println(index);
                Printable.writer.println(N.addToN() + " G0 Z" + drillRetract + "\n" + N.addToN() + " G1" + " Z" + (index.doubleValue() * -1.0) + "\n" + N.addToN() + " G0 Z" + drillRetract);
            }
            Printable.writer.println(N.addToN() + " G0 Z" + safe);
        }
        Printable.writer.println("(end of actual drill)\n\n");
    }

    public void toolCallSetup() {
        System.out.println("Drill Cycle Start Called");
        Printable.writer.println("(Start of Drill Tool Call)\n" + N.addToN() + " g17g40g90\n" + N.addToN() + " T" + getToolnumber() + "M6\n" + N.addToN() + " S" + getSpindle() + " M3 M7\n" + "\n(End of Drill)" + "\n\n");
        //Printable.writer.println("(Start of Drill Cycle)\n" + "g17g40g90\n" + "T" + getToolnumber() + "M6\nS" + getSpindle() + " M3 M7\n" + "\n(End of Drill)" + "\n\n");
    }
    
    public void writeCode() {
        toolCallSetup();
        drillCycle();
    }

}
