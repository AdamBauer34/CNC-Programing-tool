/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;
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
public class ToPrint {
    private Drill drill;
    
    public ToPrint(){
        
    }
    
    public void setDrill(Drill drill){
        this.drill = drill;
    }
    
    public void printCode() throws FileNotFoundException{
        
        //MAKE PrintWriter ITS OWN CLASS SO IT IS ACESSED OUTSIDE OF THE OTHER CLASSES AND WONT RESTART
        
        try (PrintWriter writer = new PrintWriter("CnCcode.txt")) {
            System.out.println(drill.toString());
            writer.println(drill.toString());
        }
    }
    
}
