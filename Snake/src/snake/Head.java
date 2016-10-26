/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author Henrik Rosqvist
 */
public class Head {
    private int x, y;
    private int foodEaten;
    private String direction;
    
    public Head(int x, int y)
    {
        this.x = x;
        this.y = y;
        
        this.foodEaten = 0;
        this.direction = "default";
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
    
    
}
