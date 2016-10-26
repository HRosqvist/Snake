/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

/**
 *
 * @author Henrik Rosqvist
 */
public class Board extends JPanel implements GlobalValues {
    private Timer timer;
    private Head h;
    private ArrayList<Body> b;
    
    public Board()
    {
        initialize();
    }
    
    private void initialize()
    {
        setFocusable(true);
        setDoubleBuffered(true);
        
        h = new Head(0, 0);
        b = new ArrayList();
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new scheduleTask(), DELAY, PERIOD);
        
        System.out.println("Window created");
    }
    
    @Override
    public void addNotify()
    {
        super.addNotify();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.GRAY);
        Graphics g2d = (Graphics2D) g;
        
        drawHead((Graphics2D) g2d);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawHead(Graphics2D g)
    {
        g.fillRect(GlobalValues.WIDTH / 2, GlobalValues.HEIGHT / 2, TILE, TILE);
    }
    
    private class scheduleTask extends TimerTask
    {
        @Override 
        public void run()
        {
            //Lägg till den kod som uppdateras varje frame
            repaint();
        }
    }
}
