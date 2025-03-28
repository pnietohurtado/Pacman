/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pacman;

import Player.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import tile.TileManager;

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
    
    public final int maxWorldCol = 16; 
    public final int maxWorldRow = 12; 
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeigth = tileSize * maxWorldRow;

    // Hilo del juego
    Thread game; 
    
    TileManager tile = new TileManager(this); 
    
    // Declaramos las teclas para mover el personaje 
    public KeyHandler kh = new KeyHandler (); 
    
    // Declaramos el personaje 
    public Player player = new Player(this,kh); 
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
        this.setBackground(Color.black); 
        this.setDoubleBuffered(true); 
        this.addKeyListener(kh);
        this.setFocusable(true);
    }
    
    // Declaramos el hilo 
    public void startGame(){
        game = new Thread(this); 
        game.start(); 
    }
    
    public void update(){
        player.update(); 
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
        
        player.draw(g2);
        
        g2.dispose();
        
        
        
    }
    
}
