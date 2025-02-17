/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cnc;

import java.io.PrintWriter;

/**
 *
 * @author AdamB
 */
public class Printable {
        public static PrintWriter writer;
    static {
        try {
            writer = new PrintWriter("CnCcode.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void closerWriter() {
        if (writer != null) {
            writer.close();
        }
    }
}
