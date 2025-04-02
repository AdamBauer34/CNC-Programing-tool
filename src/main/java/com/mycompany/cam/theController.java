/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;


import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.geometry.Point2D;
import javafx.scene.layout.Region;
import javafx.util.Builder;

/**
 *
 * @author AdamB
 */
public class theController {

    private CoordinatePoints cords;
    private Scanner scanner;
    private Drill drill;
    private Calculations calculations;
    private BlockNumber bNum;
    //private Blocks block;

    // this part of the model controls the threading
    private final Builder<Region> view;

    public theController() {
        //this.block = new Blocks();
        this.bNum = BlockNumber.getInstance();
        this.scanner = new Scanner(System.in);
        this.calculations = new Calculations();
        
        theModel model = new theModel();
        view = new theView(model);
    }

    public Region getView() {
        System.out.println("Before view.build");
        return view.build();
    }
      

    /*public void drillCycle(int toolnumber, int spindle, double feed, double sHeight, double rHeight, double depth, double peck) {
        System.out.println("Tool number?");
        drill.setToolnumber(toolnumber);
        System.out.println("Spindle Speed?");
        drill.setSpindle(spindle);
        System.out.println("Feed?");
        drill.setFeed(feed);
//        System.out.println("Diameter?");
//        drill.setDiameter(0.20);
        System.out.println("Safe Tool Height?");
        drill.setSafe(sHeight);
        System.out.println("Drill Retract Height?");
        drill.setDrillRetract(rHeight);
        System.out.println("Drill Depth?");
        drill.setDepth(depth);
        System.out.println("Peck?");
        drill.setPeck(peck);
    }

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

    }*/


}
