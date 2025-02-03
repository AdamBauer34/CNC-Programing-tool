/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cnc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author AdamB
 */
public class UserInterface {
    private Scanner scanner;
    private Drill drill;
    private ToPrint print;
    
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.drill = new Drill();
        this.print = new ToPrint();
    }
    
    public void start() throws FileNotFoundException {
        while (true) {
            System.out.println("Commands");
            System.out.println("1 - Mill");
            System.out.println("2 - Drill");
            System.out.println("3 - MISC");
            System.out.println("4 - Execute Code");
            System.out.println("0 - End");
            String command = scanner.nextLine();
            if(command.equals("0")){
                break;
            }
            if(command.equals("1")){
                
            }
            if(command.equals("2")){
                
                String cmd = "null";
                System.out.println("Tool number?");
                drill.setToolnumber(Integer.valueOf(scanner.nextLine()));
                System.out.println("Feed?");
                drill.setFeed(Double.valueOf(scanner.nextLine()));
                System.out.println("Spindle Speed?");
                drill.setSpindle(Integer.valueOf(scanner.nextLine()));
                System.out.println("Diameter?");
                drill.setDiameter(Double.valueOf(scanner.nextLine()));
                System.out.println("Depth?");
                drill.setDepth(Double.valueOf(scanner.nextLine()));
                System.out.println("Starting X Position");
                drill.setX(Double.valueOf(scanner.nextLine()));
                System.out.println("Starting Y Position");
                drill.setY(Double.valueOf(scanner.nextLine()));
                print.setDrill(drill);
            }
            if(command.equals("3")){
                
            }
            if(command.equals("4")){
                print.printCode();
            }
        }
    }
    
    
            
}
