/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pacman;

import javax.swing.JFrame;

/**
 *
 * @author pablo
 */
public class Pacman {

    public static void main(String[] args) {
        JFrame ventana = new JFrame(); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        ventana.setResizable(false); 
        ventana.setTitle("Pacman"); 
        
        ventana.pack(); 
        
        ventana.setLocationRelativeTo(null); // La posición de la ventana va a estar en medio de la pantalla 
        ventana.setVisible(true); 
        
    }
}
