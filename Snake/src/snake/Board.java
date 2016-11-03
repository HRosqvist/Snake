/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;

/**
 *
 * @author Henrik Rosqvist
 */

//Den här klassen hanterar den största delen av spelet
public class Board extends JPanel implements GlobalValues {
    //Deklarerar objekt
    private Timer timer;
    private Random random;
    private Head h;
    private ArrayList<Body> b;
    private Food f;
    
    //Deklarerar variabler
    private boolean ingame = true;
    private int score;
    
    public Board() //Konstruktor
    {
        initialize();
    }
    
    //Den här metoden startar spelet och skapar alla objekt på sin startposition
    private void initialize()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        
        random = new Random();
        
        score = 0;
        
        h = new Head(0, 0);
        b = new ArrayList();
        f = new Food(random.nextInt(GlobalValues.TILESWIDE) * GlobalValues.TILE, random.nextInt(GlobalValues.TILESHIGH) * GlobalValues.TILE);
        System.out.println("New food created at: " + f.getX() + "," + f.getY());
        
        timer = new Timer();
        timer.scheduleAtFixedRate(new scheduleTask(), DELAY, PERIOD);
        
        System.out.println("Window created");
        System.out.println("Speed: " + (DELAY/PERIOD));
    }
    
    //Den här metoden ritar ut grafiken
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.GRAY);
        Graphics g2d = (Graphics2D) g;
        
        for (Body body : b)
        {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(body.getX(), body.getY(), body.getWidth(), body.getHeight());
        }
        
        drawHead((Graphics2D) g2d);
        drawFood((Graphics2D) g2d);
        drawText((Graphics2D) g2d);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawHead(Graphics2D g) //Ritar huvudet
    {
        g.setColor(Color.BLACK);
        g.fillRect(h.getX(), h.getY(), h.getWidth(), h.getHeight());
    }
    
    private void drawFood(Graphics2D g) //Ritar maten
    {
        g.setColor(Color.RED);
        g.fillRect(f.getX(), f.getY(), f.getWidth(), f.getHeight());
    }
    
    private void drawText(Graphics2D g) //Ritar texten
    {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        g.setColor(Color.WHITE);
        g.drawString("Head position: (" + h.getX() + ", " + h.getY() + ")", 0, 18);
        g.drawString("Score:" + score, 0, 36);
    }
    
    //Den här metoden anropas i en loop tills programmet stängs
    private class scheduleTask extends TimerTask
    {
        @Override 
        public void run()
        {
            //Rörelser för huvudet och kroppen
            h.move();
            
            for (Body body : b)
            {
                body.move();
            }
            
            checkCollision();
            bodyMovement();
            repaint();
        }
    }
    
    private class TAdapter extends KeyAdapter //Knapptryckningar
    {   
        @Override
        public void keyPressed(KeyEvent e)
        {
            h.KeyPressed(e);
            System.out.println("New direction set to: " + h.getDirection());
        }
    }
    
    private void bodyMovement() //Flyttar varje del av kroppen till den position som den framför hade förra steget
    {
        if (!b.isEmpty())
        {
            b.get(0).setX(h.getLastPosition()[0]);
            b.get(0).setY(h.getLastPosition()[1]);
        }
        
        for (int i = 1; i < b.size(); i++)
        {
            b.get(i).setX(b.get(i - 1).getLastPosition()[0]);
            b.get(i).setY(b.get(i - 1).getLastPosition()[1]);
        }
    }
    
    private void checkCollision() //Kollisionskoden
    {
        if (h.getRect().intersects(f.getRect())) //När huvudet går över maten
        {
            score += 10;
            
            //Lägger till en ny kroppsdel
            if (b.isEmpty())
            {
                b.add(new Body(h.getLastPosition()[0], h.getLastPosition()[1], h.getDirection()));
            }
            else 
            {
                b.add(new Body(b.get(b.size() - 1).getLastPosition()[0], b.get(b.size() - 1).getLastPosition()[1], b.get(b.size() - 1).getDirection()));
            }
            
            //Sätter en ny position för matbiten
            f.setX(random.nextInt(GlobalValues.TILESWIDE) * GlobalValues.TILE);
            f.setY(random.nextInt(GlobalValues.TILESHIGH) * GlobalValues.TILE);
            System.out.println("New body created at " + b.get(b.size() - 1).getX() + "," + b.get(b.size() - 1).getY());
            System.out.println("New food piece created at: " + f.getX() + "," + f.getY());
        }
        
        //När huvudet går ut på y-axeln kommer det tillbaka på andra sidan
        if (h.getY() < 0)
        {
            h.setY(TILESHIGH * TILE);
        }
        else if (h.getY() > TILESHIGH * TILE)
        {
            h.setY(0);
        }
        
        //När huvudet går ut på x-axeln kommer det tillbaka på andra sidan
        if (h.getX() < 0)
        {
            h.setX(TILESWIDE * TILE);
        }
        else if (h.getX() > TILESWIDE * TILE)
        {
            h.setX(0);
        }
        
        for (Body body : b)
        {
            if (body.getRect().intersects(h.getRect())) //Om huvudet kommer i kontakt med kroppen avslutas spelet
            {
                //Game over
                gameOver();
                break;
            }
        }
    }
    
    private void gameOver() //Den här metoden avslutar spelet och startar om
    {
        int finalScore = score;
        score = 0;
        h.setX(0);        
        h.setY(0);
        b.clear();
        h.setDirection("default");
                
        showMessage("GAME OVER\nYour score was: " + finalScore);
    }
    
    private void showMessage(String message)  //Visar en dialog med ett meddelande
    { 
        EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                JOptionPane.showMessageDialog(null, message);
            }
        });
    }
}
