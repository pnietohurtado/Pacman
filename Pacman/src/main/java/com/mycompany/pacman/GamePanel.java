/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author pablo
 */
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; 
    final int escala = 3; 
    
    public final int tileSize = originalTileSize * escala; 
    public final int maxScreenCol = 16; 
    public final int maxScreenRow = 12; 
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight = tileSize * maxScreenRow; 

    // Hilo del juego
    Thread game; 
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        //this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }
    
    // Declaramos el hilo 
    public void startGame(){
        game = new Thread(this); 
        game.start(); 
    }
    
    public void update(){
        
    }
    
    public final int FPS = 60; 
    
    @Override
    public void run() {
        
        double drawInterval = 1000000000 / FPS; 
        double delta = 0; 
        long lastTime = System.nanoTime(); 
        long currentTime; 
        
        long timer = 0; 
        int drawCount = 0; 
        
        
        while(game != null)
        {
            currentTime = System.nanoTime(); 
            
            delta += (currentTime - lastTime) / drawInterval; 
            timer += (currentTime - lastTime); 
            lastTime = currentTime; 
            
            if(delta >= 1){
                update(); 
                repaint(); 
                delta--; 
                drawCount++; 
            }
            
            if(timer >= 1000000000){
                System.out.println("FPS:"+drawCount);
                drawCount = 0; 
                timer = 0; 
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; 
        
        
        
        
        
    }
    
}
