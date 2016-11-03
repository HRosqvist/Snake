/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Rectangle;

/**
 *
 * @author Henrik Rosqvist
 */

//Den här klassen hanterar ormen och dess kropp
public class Body {
    //Deklarera variabler
    private int x, y, width, height;
    private int[] lastPosition;
    private String direction;
    
    public Body(int x, int y, String direction) //Konstruktor
    {
        this.x = x;
        this.y = y;
        
        this.width = GlobalValues.TILE;
        this.height = GlobalValues.TILE;
        
        this.lastPosition = new int[2];
        
        this.direction = direction;
    }
    
    public void move() //Uppdaterar den förra positionen denna kroppsbiten hade
    {
        lastPosition[0] = x;
        lastPosition[1] = y;
    }
    
    public Rectangle getRect() //Rektangeln används för kollisioner
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
