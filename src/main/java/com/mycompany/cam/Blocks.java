/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam;

/**
 *
 * @author AdamB
 */
public class Blocks {
    
    private String name;
    private Drill drill;
    private Mill mill;
    
    public Blocks(Drill drill) {
        this.drill = new Drill(drill);
        name = "Drill";
    }
    
    public Blocks(Mill mill) {
        mill = new Mill();
        name = "Mill";
    }

    public String getName() {
        return name;
    }
    
    public Drill getDrill(){
        return drill;
    }
    
    public Mill getMill() {
        return mill;
    }
    
    public boolean checkDrill(){
        if(drill == null){
            return false;
        } else {
            return true;
        }
    }
    
    public boolean checkMill(){
        if(drill == null){
            return false;
        } else {
            return true;
        }
    }
    
    
}
