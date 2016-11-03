/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Henrik Rosqvist
 */

//Den här klassen hanterar huvudet av ormen
public class Head {
    //Deklarerar variabler
    private int x, y, width, height;
    private int[] lastPosition;
    private String direction;
    
    public Head(int x, int y) //Konstruktor
    {
        this.x = x;
        this.y = y;
        
        this.width = GlobalValues.TILE;
        this.height = GlobalValues.TILE;
        
        lastPosition = new int[2];
        
        this.direction = "default";
    }
    
    public void move() //Sparar x och y värdena huvudet hade innan det flyttade sig
    {
        switch (direction) {
            case "up":
                lastPosition[0] = x;
                lastPosition[1] = y;
                y -= height;
                break;
            case "down":
                lastPosition[0] = x;
                lastPosition[1] = y;
                y += height;
                break;
            case "left":
                lastPosition[0] = x;
                lastPosition[1] = y;
                x -= width;
                break;
            case "right":
                lastPosition[0] = x;
                lastPosition[1] = y;
                x += width;
                break;
            default:
                break;
        }
    }
    
    public void KeyPressed(KeyEvent e) //Ändrar riktningen när man trycker på en knapp
    {
        int key = e.getKeyCode();
        
        switch (key) {
            case KeyEvent.VK_A:
                direction = "left";
                break;
            case KeyEvent.VK_D:
                direction = "right";
                break;
            case KeyEvent.VK_W:
                direction = "up";
                break;
            case KeyEvent.VK_S:
                direction = "down";
                break;
            default:
                break;
        }
    }
    
    //Den här rektangeln används för kollisioner
    public Rectangle getRect()
    {
        return new Rectangle(x, y, GlobalValues.TILE, GlobalValues.TILE);
    }
    
    
    //Getters och setters efter denna raden
    public int getX()
    {
        return this.x;
    }
    
    public void setX(int x)
    {
        this.x = x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public String getDirection()
    {
        return this.direction;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public int[] getLastPosition()
    {
        return this.lastPosition;
    }
}
