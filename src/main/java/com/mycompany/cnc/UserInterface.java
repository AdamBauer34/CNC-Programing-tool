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
public class UserInterface {
    private Scanner scanner;
    private Drill drill;
    
    public UserInterface(){
        this.scanner = new Scanner(System.in);
        this.drill = new Drill();
    }
    
    public void start() {
        while (true) {
            System.out.println("Commands");
            System.out.println("1 - Mill");
            System.out.println("2 - Drill");
            System.out.println("3 - MISC");
            System.out.println("0 - End");
            String command = scanner.nextLine();
            if(command.equals("0")){
                break;
            }
            if(command.equals("1")){
                
            }
            if(command.equals("2")){
                
                String cmd = "null";
                System.out.println("Diameter?");
                drill.setDiameter(Double.valueOf(scanner.nextLine()));
            }
            if(command.equals("3")){
                
            }
        }
    }
    
    
            
}
