/*
 * Assignment 6
 * 
 * TCSS305 - Autumn 2015
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
/**
 * Creates a Bomb Tracker Panel that tracks the number of bombs available, adds bombs,
 * removes bombs and displays the remaining bombs in the GUI.
 * 
 * @author Jeremy Wolf
 * @version 10 December 2015
 *
 */
public class BombTracker extends JPanel implements PropertyChangeListener, Observer {
    
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -2395580530668241611L;

    /**
     * Static Field for Border Color.
     */
    private static final Color COLOR_DARK_GREEN = new Color(88, 122, 23);
    
    /**
     * Static field for the Bomb String.
     */
    private static final String BOMB_STRING = "BOMBS AVAILABLE:  ";
    
    /**
     * Static field for the Number of Bombs.
     */
    private static final int BOMB_NUM = 3;
    
    /**
     * Static field for Title Font.
     */
    private static final Font DEFAULT_TITLE = new Font("Title", Font.BOLD, 17);
    
    /**
     * Field to store number of bombs available.
     */
    private int myBombs;
    
    /**
     * Field to store the full bombs available string.
     */
    private String myBombString;
    /**
     * Field to store the PieceMovement object.
     */
    private final PieceMovement myMovement;
    
    /**
     * Constructs the Bomb Tracker panel that displays the number
     * of bombs the player has remaining.
     * 
     * @param theMovement contains all key controls.
     */
    public BombTracker(final PieceMovement theMovement) {
        super();
        myMovement = theMovement;
        final Border one = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        final Border two = BorderFactory.createMatteBorder(4, 4, 4, 4, COLOR_DARK_GREEN);
        setBorder(BorderFactory.createCompoundBorder(one, two));
        myBombs = BOMB_NUM;
        updateString();
        setBackground(Color.BLACK);
    }
    
    /**
     * Updates the Bomb String.
     */
    private void updateString() {
        myBombString = " " + myBombs;
    }
    
    /**
     * Paints the bomb tracker background and text.
     * 
     * @param theGraphics the Graphic to be drawn. 
     */
    protected void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;

        
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        final Point2D start = new Point2D.Float(0, 0);
        final Point2D end = new Point2D.Float(30, 45);
        final float[] linearDist = {0.0f, 0.5f, 1.0f};
        final Color[] linearColors = {Color.YELLOW, Color.RED, Color.YELLOW};
        final LinearGradientPaint linearGradient = 
                        new LinearGradientPaint(start, end, linearDist, 
                                                linearColors, CycleMethod.REPEAT);
        final int bombStringX = 10;
        final int bombStringY = 30;
        final int numBombStringX = 80;
        final int numBombStringY = 60;
        g2D.setPaint(linearGradient);
        g2D.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        g2D.setPaint(Color.BLACK);
        g2D.setFont(DEFAULT_TITLE);
        g2D.drawString(BOMB_STRING, bombStringX, bombStringY);
        g2D.drawString(myBombString, numBombStringX, numBombStringY);

    }
    
    /**
     * Adds Bombs to the total number of bombs available. 
     */
    public void addBomb() {
        myBombs += 1;
        updateString();
        myMovement.setBombsAvailable(true);
    }
    
    /**
     * Remove a Bomb from the total number of bombs available. 
     */
    public void removeBomb() {
        myBombs -= 1;
        updateString();
        if (myBombs == 0) {
            myMovement.setBombsAvailable(false);
        }
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("BombUsed".equals(theEvent.getPropertyName())) {
            removeBomb();
            repaint();
        }
    }

    @Override
    public void update(final Observable theO, final Object theArg) {
        if (theO instanceof Score) {
            if (((Score) theO).getAddBomb()) {
                addBomb();
                repaint();
            }
        }
    }
    
    /**
     * Resets the bomb field to ins default starting value.
     */
    public void resetBombs() {
        myBombs = BOMB_NUM;
        updateString();
        repaint();
    } 
}
