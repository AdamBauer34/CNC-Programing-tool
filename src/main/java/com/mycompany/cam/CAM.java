/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cam;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author AdamB
 */
public class CAM extends Application {
    
    @Override
    public void start(Stage stage) {
        theController controller = new theController();
        Scene scene = new Scene(controller.getView());
        
        stage.setScene(scene);
        stage.show();

    /*public static void main(String[] args) throws FileNotFoundException {
        
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        
        ui.start();
        
        Printable.closerWriter();*/
        
        //PrintWriter writer = new PrintWriter("CnCcode.txt");
        
        /*//tool call and changes to that tool
        writer.println("N1 T1 M06");
        //Moves tool to start location
        writer.println("N2 M03 S1000");
        writer.println("N3 G90 G0 G54 X0.0 Y0.0 Z1.0");
        writer.println("N4 G1 Z0.01");
        writer.println("N5 G1 F10.0");
        BigDecimal x = new BigDecimal("0.0");
        BigDecimal y = new BigDecimal("0.0");
        BigDecimal step = new BigDecimal("0.01");
        BigDecimal xDistance = new BigDecimal("10.0");
        BigDecimal yDistance = new BigDecimal("2.0");
        BigDecimal feed = new BigDecimal("0.1");
        BigDecimal xReturn = new BigDecimal("0.0");
        int index = 6;
        while(y.doubleValue() <= yDistance.doubleValue()) {
            writer.println("N" + index + " G1 Y" + y);
            index++;
            writer.println("N" + index + " G1 X" + xDistance);
            index++;
            y = y.add(step);
            writer.println("N" + index + " G1 Y" + y);
            index++;
            writer.println("N" + index + " G1 X" + xReturn);
            index++;
            y = y.add(step);
        }
        writer.println("N" + index + " G0 Z10.0");
        index++;
        writer.println("N" + index + " G0 G53 X0.0 Y10.0");
        index++;
        writer.println("N" + index + " M30");
        writer.close();
        System.out.println("Closed");*/

        
    }
}
