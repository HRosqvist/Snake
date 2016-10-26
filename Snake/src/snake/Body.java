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

//Den här klassen hanterar ormen och dess kropp
public class Body {
    private int x, y;
    private int foodEaten;
    private String direction;
    
    public Body()
    {
        this.foodEaten = 0;
        this.direction = "jag vet shi";
    }
    
    public void move()
    {
        switch (direction) {
            case "up":
                y -= GlobalValues.tile;
                break;
            case "down":
                y += GlobalValues.tile;
                break;
            case "right":
                x += GlobalValues.tile;
                break;
            case "left":
                x -= GlobalValues.tile;
                break;
            default:
                break;
        }
    }
    
    public void addToBody()
    {
        this.foodEaten++;
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
    
    public int getFoodEaten()
    {
        return this.foodEaten;
    }
    
    public void setFoodEaten(int foodEaten)
    {
        this.foodEaten = foodEaten;
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
