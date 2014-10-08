
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Graphics2D.*;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong extends JFrame implements ActionListener , KeyListener
{

    Timer timer;
    ActionListener actLis;
    
    private static int fSizeX = 800;
    private static int fSizeY = 400;
    
    private static int pSizeX = 25;
    private static int pSizeY = 75;
    
    private static int ballSize = 50;
    private static int ballX = fSizeX/2;
    private static int ballY = fSizeY/2;
    
    private static int p1X = 50;
    private static int p1Y = fSizeY/2;
    private static int p1Dir = 0;
    private static int p1Speed = 1;
    private static Rectangle2D p1 = new Rectangle2D.Double(p1X-pSizeX/2, p1Y-pSizeY/2, pSizeX, pSizeY);
    
    private static int p2X = fSizeX-50;
    private static int p2Y = fSizeY/2;
    private static int p2Dir = 0;
    private static int p2Speed = 1;
    private static Rectangle2D p2 = new Rectangle2D.Double(p2X-pSizeX/2, p2Y-pSizeY/2, pSizeX, pSizeY);
    
    private static GameBall gameBall = new GameBall(fSizeX/2-5,fSizeY/2-5,0,0,20);
    
    private static Rectangle2D rect = new Rectangle2D.Double(0,0,fSizeX,fSizeY);
    
    private static Random rx1 = new Random(10338);
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Pong() {
        timer = new Timer(5,this);
        timer.setInitialDelay(200);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    @Override
    public void paint(Graphics g) {
        
        update();
        
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setColor(Color.WHITE);
        g2.fill(rect);
        
        g2.setColor(Color.BLACK);
        p1.setRect(p1X, p1Y-pSizeY/2, pSizeX, pSizeY);
        g2.fill(p1);
        p2.setRect(p2X, p2Y-pSizeY/2, pSizeX, pSizeY);
        g2.fill(p2);
        
        g2.setColor(Color.RED);
        g2.fill(gameBall.sigh());
    }
    
    public void update() {
    	
        if(p1Dir != 0 && p1Y+pSizeY+p1Speed*p1Dir < fSizeY && p1Y-pSizeY+p1Speed*p1Dir > 0) 
        {
            p1Y += p1Speed*p1Dir*2;
        }
        
        if(p2Dir != 0 && p2Y+pSizeY+p2Speed*p2Dir < fSizeY && p2Y-pSizeY+p2Speed*p2Dir > 0) 
        {
            p2Y += p2Speed*p2Dir*2;
        }
        
        updateGameBall();
    }
    
    public void updateGameBall() {
        //If the gameBall has gotten past either player
        if(gameBall.getX() < 0) score(1);
        if(gameBall.getX() + gameBall.getSize() > fSizeX) score(2);
        
        //If the gameBall hits the p1 paddle
        
        int bCent = gameBall.getCenterY();
        if((gameBall.getX() - gameBall.getSize() <= p1X ) && (gameBall.getX() - gameBall.getSize() >= p1X - 10) ) 
        {
            if(bCent >= p1Y - pSizeY && bCent < p1Y + pSizeY) {
                gameBall.setX(p1X+pSizeX+3);
                switch(Math.abs(rx1.nextInt()%2)+1) 
                {
                	case 1: gameBall.setmvX(1);
        			break;
                	case 2: gameBall.setmvX(2);
        			break;
                }
                switch(Math.abs(rx1.nextInt()%4)+1) 
                {
                    case 1: gameBall.setmvY(2);
        			break;
                    case 2: gameBall.setmvY(1);
        			break;
                    case 3: gameBall.setmvY(-1);
        			break;
                    case 4: gameBall.setmvY(-2);
        			break;
                }
            } 
            System.out.println(Math.abs(rx1.nextInt()%4)+1);
        }
        
        
        //If the gameBall hits the p2 paddle        
        
        if((gameBall.getX() + gameBall.getSize() <= p2X + 10) && (gameBall.getX() + gameBall.getSize() >= p2X ) ) 
        {
            if(bCent >= p2Y - pSizeY && bCent < p2Y + pSizeY) {
                gameBall.setX(p2X-pSizeX-3);
                switch(Math.abs(rx1.nextInt()%2)+1) 
                {
                	case 1: gameBall.setmvX(-1);
                	break;
                	case 2: gameBall.setmvX(-2);
        			break;
                }
                switch(Math.abs(rx1.nextInt()%4)+1) 
                {
                    case 1: gameBall.setmvY(2);
        			break;
                    case 2: gameBall.setmvY(1);
        			break;
                    case 3: gameBall.setmvY(-1);
        			break;
                    case 4: gameBall.setmvY(-2);
        			break;
                }
            } 
        }
        
        
        //If the gameBall hits a wall
        int getY = gameBall.getY();
        if((getY <= 0 + (gameBall.getSize()) || getY >= fSizeY - (gameBall.getSize()))) {
            gameBall.setmvY(gameBall.getmvY() * -1);
        }
        
        int getX = gameBall.getX();
        if(getX <= 0) {
            //gameBall.setmvX(gameBall.getmvX() * -1);
            score(1);
        } else if(getX >= fSizeX - (gameBall.getSize())) {
            score(2);
        }
        
        gameBall.move();
    }
    
    public void score(int player) {
        
        System.out.println("Player " + player + " scores!");
        reset();
        
    }
    
    public void reset() {
        gameBall.setX(fSizeX/2);
        gameBall.setX(fSizeY/2);
        gameBall.setmvY( (int) (Math.random()*2) + 1 );
        gameBall.setmvX( (int) (Math.random()) + 1);
        if(gameBall.getmvX() == 2) { gameBall.setmvX(-1); }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_DOWN) {
            p2Dir = 0;
        } else if(e.getKeyCode()== KeyEvent.VK_UP) {
            p2Dir = 0;
        }
        
        if(e.getKeyCode()== KeyEvent.VK_S) {
            p1Dir = 0;
        } else if(e.getKeyCode()== KeyEvent.VK_W) {
            p1Dir = 0;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    // Main KeyEvent Method
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.print(e.getKeyCode());
        if(e.getKeyCode()== KeyEvent.VK_DOWN) {
            p2Dir = 1;
        } else if(e.getKeyCode()== KeyEvent.VK_UP) {
            p2Dir = -1;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_S) {
            p1Dir = 1;
        } else if(e.getKeyCode()== KeyEvent.VK_W) {
            p1Dir = -1;
        }
      
        repaint();
    }
    
    public static void main(String[] args) {
        JFrame frame = new Pong();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pong");

        frame.setSize(fSizeX,fSizeY);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        gameBall.setmvX(1);
        gameBall.setmvY(1);
        
        frame.setVisible(true);
    }
    
}
