/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author pablo
 */
public class Entity {
    public int worldX; 
    public int worldY; 
    
    public int speed; //  La velocidad a la que va a ir el personaje  
    
    public BufferedImage f1,f2,l1,l2,r1,r2,d1,d2; 
    public String direction; 
    
    public int spriteCounter  = 0; 
    public int spriteNum = 1; 
    
    public Rectangle collisionArea; 
    public int collisionAreaX; 
    public int collisionAreaY; 
    public boolean collision = false; 
    
}
