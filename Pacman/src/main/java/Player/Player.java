/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import com.mycompany.pacman.GamePanel;
import com.mycompany.pacman.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pablo
 */
public class Player extends Entity{
    
    GamePanel gp; 
    KeyHandler kh; 
    
    public final int screenX; 
    public final int screenY; 
    
    public Player(GamePanel gp, KeyHandler kh ){
        this.gp = gp; 
        this.kh = kh; 
        
        screenX = gp.screenWidth / 2 - (gp.tileSize / 2); 
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2); 
        
        collisionArea  = new Rectangle(); 
        collisionArea.x = 8; 
        collisionArea.y = 16;
        
        collisionAreaX = collisionArea.x; 
        collisionAreaY = collisionArea.y; 
        
        collisionArea.width = 32; 
        collisionArea.height = 32; 
        
        setDefaultValues(); 
        getPlayerImage(); 
        
    }
    
    
    public void setDefaultValues()
    {
        worldX = gp.tileSize * 2 ; 
        worldY = gp.tileSize * 2 ; 
        speed = 4; 
        direction = "down"; 
    }
    
    public void getPlayerImage()
    {
        try{
            basico = ImageIO.read(getClass().getResourceAsStream("/Player/Pacman.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/Player/PacmanD.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/Player/PacmanL.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/Player/PacmanR.png"));
            up = ImageIO.read(getClass().getResourceAsStream("/Player/PacmanU.png"));
            
        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
    
    public void update()
    {
        if(kh.up == true || kh.down == true ||
                kh.left == true || kh.right == true ){
            
            if(kh.up == true)
            {
                direction = "up"; 
            }
            else if(kh.down == true)
            {
                direction = "down";               
            }
            else if(kh.left == true)
            {
                direction="left";                
            }
            else if(kh.right == true)
            {
                direction="right";                
            }

            
            spriteCounter++; 
            if(spriteCounter > 8){
                if(spriteNum == 1){
                    spriteNum = 2; 
                }else if (spriteNum == 2){
                    spriteNum = 1; 
                }
                spriteCounter = 0; 
            }    
            
        }
    }
    
    
    public void draw(Graphics2D g2) 
    {
        /*
        g2.setColor(Color.white); 
        g2.fillRect(this.x, this.y, gamePanel.tileSize, gamePanel.tileSize);  
        */
        
        BufferedImage image = null; 
        switch(direction) {
            case "up": 
                if(spriteNum == 1) {
                    image = up; 
                }else if(spriteNum == 2){
                    image = basico; 
                }
                break;
            case "down": 
                if(spriteNum == 1) {
                    image = down; 
                }else if(spriteNum == 2){
                    image = basico; 
                }
                break;
            case "left": 
                if(spriteNum == 1) {
                    image = left; 
                }else if(spriteNum == 2){
                    image = basico; 
                }
                break;
            case "right": 
                if(spriteNum == 1) {
                    image = right; 
                }else if(spriteNum == 2){
                    image = basico; 
                }
                break;
        }
        
            g2.drawImage(image,screenX,screenY,gp.tileSize, gp.tileSize,null); 
    }
    
    
    
}
