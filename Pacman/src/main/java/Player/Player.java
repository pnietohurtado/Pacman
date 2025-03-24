/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Player;

import com.mycompany.pacman.GamePanel;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author pablo
 */
public class Player extends Entity{
    
    GamePanel gp = new GamePanel(); 
    
    public final int screenX; 
    public final int screenY; 
    
    public Player(GamePanel gp){
        this.gp = gp; 
        
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
        worldX = gp.tileSize * 23 ; 
        worldY = gp.tileSize * 19 ; 
        speed = 4; 
        direction = "down"; 
    }
    
    public void getPlayerImage()
    {
        try{
            f1 = ImageIO.read(getClass().getResourceAsStream("/player/Front1.png"));
            f2 = ImageIO.read(getClass().getResourceAsStream("/player/Front2.png"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/player/Rigth1.png"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/player/Rigth2.png"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/player/Left1.png"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/player/Left2.png"));
            d1 = ImageIO.read(getClass().getResourceAsStream("/player/Up1.png"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/player/Up2.png"));
        }catch(IOException e){
            e.printStackTrace(); 
        }
    }
    
    
    
    
}
