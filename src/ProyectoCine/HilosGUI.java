/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoCine;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Ricar
 */
public class HilosGUI extends Thread {
    javax.swing.JLabel jLabel1;
    int contador;

    public HilosGUI(){
        contador=1;
    }
    
    public void run(){
            int cont = 1;
        while(true){
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/promos/promo" + cont + ".jpg"));
            icon = new ImageIcon(icon.getImage().getScaledInstance(396, 496, java.awt.Image.SCALE_DEFAULT));
            jLabel1.setIcon(icon);
            try {
                sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HilosGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (cont == 5) {
                cont = 1;
            } else {
              cont++;   
            }
        }
    }
    
    public void recibeJLabel(javax.swing.JLabel jLabel1){
        this.jLabel1= jLabel1;
    }
    
}
