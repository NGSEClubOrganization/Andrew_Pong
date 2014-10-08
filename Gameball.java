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

import javax.swing.JFrame;
import javax.swing.Timer;

public class GameBall {

private int x, y, mvX, mvY, size;

public GameBall(int parx, int pary, int parmvX, int parmvY, int parSize) {
    x = parx;
    y = pary;
    mvX = parmvX;
    mvY = parmvY;
    size = parSize;
}

public void move() {
    x += mvX;
    y += mvY;
}

//Sets
public void setX(int parX) {x = parX;}
public void setY(int parY) {x = parY;} 
public void setmvX(int parmvX) { mvX = parmvX;}
public void setmvY(int parmvY) { mvY = parmvY;}
public void setSize(int parSize) {size = parSize;}

//Gets
public Rectangle2D sigh(){return new Rectangle2D.Double(x, y, size, size);}
public int getSize() {return size;}
public int getCenterY() {return y;}
public int getCenterX() {return x;}
public int getX() {return x;}
public int getY() {return y;}
public int getmvX() {return mvX;}
public int getmvY() {return mvY;}    
}
