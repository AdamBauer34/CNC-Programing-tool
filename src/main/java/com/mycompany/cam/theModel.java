/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author AdamB
 */
public class theModel {

    private CoordinatePoints cords;
    private int drillNum;
    private BlockNumber bN;
    //private Point2D cords;
    private Scanner scanner;
    private Drill drill;
    //private ToPrint print;
    private Calculations calculations;
    private ArrayList<Blocks> block;
    private ArrayList<Drill> dList;

    public theModel() {
        this.drillNum = drillNum;
        //drillNum = 1;
        this.dList = new ArrayList<Drill>();
        this.bN = BlockNumber.getInstance();
        this.block = new ArrayList<Blocks>();
        this.scanner = new Scanner(System.in);
        this.drill = new Drill();
        this.calculations = new Calculations();
    }
    
    public void printBlocks() {
        
        int drillIndex = 0;
        for(int i = 0; i <= (bN.getNumber() - 1); i++) {
            if(dList.get(drillIndex).getBlockNum() == (i)){
                dList.get(i).drillCycle();
                drillIndex++;
            }/*else if(mList.get(i).getBlockNum() == (i+1)){
                mList.get(i).drillCycle();
            }*/ else {
                continue;
            }
        }
    }

    public void addDrill() {
        block.add(new Blocks(drill));
        drill.cleanLocations();
    }
    
    public Drill getDrillatNum(int num){
        return dList.get(num);
    }
    
    public int getDrillNum(){
        return drillNum;
    }
    
    public void drillNumAdd() {
        dList.get(drillNum).setBlockNum();
        bN.increaseNumber();
        drillNum = drillNum + 1;
    }
    
    public void newDrill(){
        if(dList == null || (dList.size() == drillNum) ){
        dList.add(new Drill());
        
        } else {
            System.out.println("Drill already made");
        }
    }
    
    public Drill drillAtCurrentDNum(){
        return dList.get(drillNum);
    }
    
    public int getCurrentBlockNum(){
        return bN.getNumber();
    }
    
    public void increaseBlockNum(){
        bN.increaseNumber();
    }
    
    public void getLocs() {
        System.out.println(drill.getLocations());
    }
    
    public Blocks getBlockNum(int num) {
        return block.get(num);
    }
    
    public int getBlockSize(){
        return block.size();
    }

    public void drillCycle(int toolnumber, int spindle, double feed, double sHeight, double rHeight, double depth, double peck) {
        System.out.println("DrillCycle Method");
        System.out.println(toolnumber);
        dList.get(drillNum).setToolnumber(toolnumber);
        System.out.println(spindle);
        dList.get(drillNum).setSpindle(spindle);
        System.out.println(feed);
        dList.get(drillNum).setFeed(feed);
//        System.out.println("Diameter?");
//        drill.setDiameter(0.20);
        System.out.println(sHeight);
        dList.get(drillNum).setSafe(sHeight);
        System.out.println(rHeight);
        dList.get(drillNum).setDrillRetract(rHeight);
        System.out.println(depth);
        dList.get(drillNum).setDepth(depth);
        System.out.println(peck);
        dList.get(drillNum).setPeck(peck);
    }

    public void addDrillPatternLocations(double x, double y) {
        System.out.println(x + " " + y);
        dList.get(drillNum).addLocations(x, y);
    }
    
//    public void drillCycle(int toolnumber, int spindle, double feed, double sHeight, double rHeight, double depth, double peck) {
//        System.out.println("DrillCycle Method");
//        System.out.println(toolnumber);
//        drill.setToolnumber(toolnumber);
//        System.out.println(spindle);
//        drill.setSpindle(spindle);
//        System.out.println(feed);
//        drill.setFeed(feed);
//        System.out.println("Diameter?");
//        drill.setDiameter(0.20);
//        System.out.println(sHeight);
//        drill.setSafe(sHeight);
//        System.out.println(rHeight);
//        drill.setDrillRetract(rHeight);
//        System.out.println(depth);
//        drill.setDepth(depth);
//        System.out.println(peck);
//        drill.setPeck(peck);
//    }
//
//    public void addDrillPatternLocations(double x, double y) {
//        System.out.println(x + " " + y);
//        drill.addLocations(x, y);
//    }

    public void drillCycle() {
        //ArrayList loc = new ArrayList<Double>();
        String cmd = "null";
        System.out.println("Tool number?");
        drill.setToolnumber(1);
        System.out.println("Feed?");
        drill.setFeed(10.0);
        System.out.println("Spindle Speed?");
        drill.setSpindle(1550);
        System.out.println("Diameter?");
        drill.setDiameter(0.20);
        System.out.println("Safe Tool Height?");
        drill.setSafe(3.0);
        System.out.println("Drill Retract Height?");
        drill.setDrillRetract(0.1);
        System.out.println("Drill Depth?");
        drill.setDepth(-2.0);
        System.out.println("Peck?");
        drill.setPeck(0.1);

        String command;

        System.out.println("Pattern type?");
        System.out.println("1 - Manual Locations");
        System.out.println("2 - Bolt circle");
        System.out.println("3 - Retangual Pattern");
        command = scanner.nextLine();

        if (command.equals("1")) {
            while (true) {
                //set up some patterns, Rectangular, Bolt circle, Locational
                int location = 1;
                double x;
                double y;
                System.out.println("Location " + location);
                System.out.println("X:");
                x = Double.valueOf(scanner.nextLine());
                System.out.println("Y:");
                y = Double.valueOf(scanner.nextLine());
                drill.addLocations(x, y);
                System.out.println("More locations?");
                System.out.println("1 - Yes");
                System.out.println("2 - No");
                String com = scanner.nextLine();
                if (com.equals("1")) {
                    location++;
                    continue;
                }
                if (com.equals("2")) {
                    break;
                }
            }
        }
        if (command.equals("2")) {
            double[] num = new double[2];
            double x;
            double y;
            int index = 0;
            System.out.println("Center point X");
            double xStart = Double.valueOf(scanner.nextLine());
            System.out.println("Center point Y");
            double yStart = Double.valueOf(scanner.nextLine());
            System.out.println("Radius of bolt circle");
            double radius = Double.valueOf(scanner.nextLine());
            System.out.println("Starting angle");
            double angleStart = Double.valueOf(scanner.nextLine());
            System.out.println("Angle per hole");
            double anglePer = Double.valueOf(scanner.nextLine());
            System.out.println("Number of holes");
            double number = Double.valueOf(scanner.nextLine());
            System.out.println("Number of decimals? 2-4?");
            String round = scanner.nextLine();
            double angle = angleStart;
            while (index < number) {
                cords.set2d((calculations.boltCircle(xStart, yStart, angle, radius, round)));
                //num = (calculations.boltCircle(xStart, yStart, angle, radius, round));
                //System.out.println(calculations.boltCircle(xStart, yStart, angle, radius, round));
                //System.out.println("Nums equals " + num);
                x = cords.getX();
                y = cords.getY();
                drill.addLocations(x, y);
                System.out.println("X: " + x + " Y: " + y);
                index++;
                angle = angle + anglePer;
            }

        }
        if (command.equals("3")) {
            //Find a way to pattern everything from the same methods, Maybe a method that produces the X/Y you want and then everything after is produced from those
            //drill.addLocations(x, y);
            System.out.println("X start?");
            double xStart = Double.valueOf(scanner.nextLine());
            System.out.println("Y start?");
            double yStart = Double.valueOf(scanner.nextLine());
            System.out.println("How many holes in X?");
            double xNum = Double.valueOf(scanner.nextLine());
            System.out.println("How many holes in Y?");
            double yNum = Double.valueOf(scanner.nextLine());
            System.out.println("Distance between X?");
            double xDist = Double.valueOf(scanner.nextLine());
            System.out.println("Distance between Y?");
            double yDist = Double.valueOf(scanner.nextLine());
            double x = xStart;
            double y = yStart;
            for (int i = 0; i < yNum; i++) {
                for (int j = 0; j < xNum; j++) {
                    drill.addLocations(x, y);
                    x = x + xDist;
                }
                y = y + yDist;
                x = xStart;
            }
        }

        drill.toolCallSetup();
        drill.drillCycle();

    }

    //input code here to determine what the other parts of the program will do
    //for example I believe that this part of the code should be using the JSON
    //to pull the information for the profile? Need to research more.
}
