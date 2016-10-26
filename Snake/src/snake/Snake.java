/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author Henrik Rosqvist
 */
public class Snake extends JFrame {

    public Snake()
    {
        startGraphics();
    }
    
    private void startGraphics()
    {
        add(new Board());
        setTitle("Snake");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(GlobalValues.WIDTH, GlobalValues.HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable()
        {
           @Override
           public void run()
           {
               Snake snake = new Snake();
               snake.setVisible(true);
           }
        });
    }
    
}
