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
    private int x, y;
    private String direction;
    private Rectangle bodyRec;
    
    public Body()
    {
        this.direction = "default";
    }
    
    public void move()
    {
        switch (direction) {
            case "up":
                y -= GlobalValues.TILE;
                break;
            case "down":
                y += GlobalValues.TILE;
                break;
            case "right":
                x += GlobalValues.TILE;
                break;
            case "left":
                x -= GlobalValues.TILE;
                break;
            default:
                break;
        }
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
    
    public String getDirection()
    {
        return this.direction;
    }
    
    public void setDirection(String direction)
    {
        this.direction = direction;
    }
}
