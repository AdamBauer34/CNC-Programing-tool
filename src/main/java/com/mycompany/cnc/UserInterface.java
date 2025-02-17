/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cnc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author AdamB
 */
public class UserInterface {

    private Scanner scanner;
    private Drill drill;
    //private ToPrint print;
    private Calculations calculations;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.drill = new Drill();
        this.calculations = new Calculations();
        //this.print = new ToPrint();
    }

    public void start() throws FileNotFoundException {
        boolean valid = false;
        while (!valid) {
            System.out.println("Commands");
            System.out.println("1 - Mill");
            System.out.println("2 - Drill");
            System.out.println("3 - MISC");
            System.out.println("4 - Execute Code");
            System.out.println("0 - End");
            String command = scanner.nextLine();

            switch (command) {
                case "0": {
                    valid = true;
                    break;
                }
                case "1": {
                    System.out.println("Mill isnt made yet");
                    break;
                }
                case "2": {
                    drillCycle();
                    break;
                }
                case "3": {
                    System.out.println("Misc isnt made yet");
                    break;
                }
                case "4": {
                    //see about making the whole of the program get made at the end of the program instead. Using this method.
                    System.out.println("Exectute code is antiquated at this time.");
                    break;
                }
                default: {
                    System.out.println("Invalid input.");
                    break;
                }
            }

//            if (command.equals("0")) {
//                break;
//            }
//            if (command.equals("1")) {
//
//            }
//            if (command.equals("2")) {
//
//                //print.setDrill(drill);
//            }
//            if(command.equals("2")){
//                
//                String cmd = "null";
//                System.out.println("Tool number?");
//                drill.setToolnumber(Integer.valueOf(scanner.nextLine()));
//                System.out.println("Feed?");
//                drill.setFeed(Double.valueOf(scanner.nextLine()));
//                System.out.println("Spindle Speed?");
//                drill.setSpindle(Integer.valueOf(scanner.nextLine()));
//                System.out.println("Diameter?");
//                drill.setDiameter(Double.valueOf(scanner.nextLine()));
//                System.out.println("Depth?");
//                drill.setDepth(Double.valueOf(scanner.nextLine()));
//                System.out.println("Peck?");
//                drill.setPeck(Double.valueOf(scanner.nextLine()));
//                System.out.println("Starting X Position");
//                drill.setX(Double.valueOf(scanner.nextLine()));
//                System.out.println("Starting Y Position");
//                drill.setY(Double.valueOf(scanner.nextLine()));
//                drill.toolCallSetup();
//                drill.drillCycle();
//                //print.setDrill(drill);
//            }
//            if (command.equals("3")) {
//
//            }
//            if (command.equals("4")) {
//                //print.printCode();
//            }
        }
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
        if (command.equals("2")){
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
            while(index < number){
                num = (calculations.boltCircle(xStart, yStart, angle, radius, round));
                //System.out.println(calculations.boltCircle(xStart, yStart, angle, radius, round));
                //System.out.println("Nums equals " + num);
                x = num[0];
                y = num[1];
                drill.addLocations(x, y);
                System.out.println("X: " + x + " Y: " + y);
                index++;
                angle = angle + anglePer;
            }
            
    }

//        System.out.println("Starting X Position");
//        drill.setX(0);
//        System.out.println("Starting Y Position");
//        drill.setY(0);
        drill.toolCallSetup();
        drill.drillCycle();

    }

}
