/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;

/**
 *
 * @author AdamB
 */
public class Nnumber {
    
    private int count = 1;
    private static Nnumber instance;
    
    private Nnumber() {
        this.count = count;
    }
    
    public static Nnumber getInstance(){
        if(instance == null) {
            instance = new Nnumber();
        }
        return instance;
    }
    
    public String addToN(){
        String N = String.valueOf(count);
        count = count + 1;
        return "N" + N;
    }
    
}
