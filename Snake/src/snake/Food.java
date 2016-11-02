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
public class Food {
    private int x, y, width, height;
    
    public Food(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.width = GlobalValues.TILE;
        this.height = GlobalValues.TILE;
    }
    
    public Rectangle getRect()
    {
        return new Rectangle(x, y, width, height);
    }
    
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
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getHeight()
    {
        return this.height;
    }
}
