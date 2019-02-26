/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deloitte.mxers.metvp.test;
import java.awt.GraphicsEnvironment;
 
/**
 *
 * @author Vladimir
 */
public class TestFonts {    
    public static void main(String args[]) {
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for(String font:e.getAvailableFontFamilyNames()) {
            System.out.println(font);
        }    
}    
    
}
