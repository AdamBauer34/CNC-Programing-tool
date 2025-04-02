/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;

/**
 *
 * @author AdamB
 */
public class BlockNumber {

    private int count = 0;
    private static BlockNumber instance;
    
    private BlockNumber() {
        this.count = count;
    }
    
    public static BlockNumber getInstance(){
        if(instance == null) {
            instance = new BlockNumber();
        }
        return instance;
    }
    
    public int getNumber(){
        return count;
    }
    
    public void increaseNumber() {
        count = count + 1;
    }

}
