/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author pablo
 */
public class KeyHandler implements KeyListener{
    
    public boolean up, left, right, down; 
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int code = e.getKeyCode(); 
        
        if(code == KeyEvent.VK_W)
        {
            this.up = true; 
        }
        if(code == KeyEvent.VK_S)
        {
            this.down = true; 
        }
        if(code == KeyEvent.VK_A)
        {
            this.left = true; 
        }
        if(code == KeyEvent.VK_D)
        {
            this.right= true; 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int code = e.getKeyCode(); 
        
        
        if(code == KeyEvent.VK_W)
        {
            this.up = false; 
        }
        if(code == KeyEvent.VK_S)
        {
            this.down = false; 
        }
        if(code == KeyEvent.VK_A)
        {
            this.left = false; 
        }
        if(code == KeyEvent.VK_D)
        {
            this.right = false; 
        }
    }
    
}
