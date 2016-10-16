/*
 * Assignment 6
 * 
 * TCSS305 Autumn 2015
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 * Creates a Score Panel that contains the level, score, 
 * and lines cleared. 
 * 
 * @author Jeremy Wolf 
 * @version 6 December 2015
 */

public class InfoPanel extends JPanel {
    
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = 4004589993078867269L;

    /**
     * Static field storing the background color.
     */
    private static final Color PANEL_COLOR = Color.BLACK;
    
    /**
     * Static field for Title Font.
     */
    private static final Font DEFAULT_TITLE = new Font("Title", Font.BOLD, 15);
    
    /**
     * Static field for Text Font.
     */
    private static final Font DEFAULT_TEXT = new Font("Text", Font.PLAIN, 13);
    
    /**
     * Static filed for the Left Control String.
     */
    private static final String LEFT_CONTROL = "Left : ";
    
    /**
     * Static filed for the Right Control String.
     */
    private static final String RIGHT_CONTROL = "Right : ";
    
    /**
     * Static filed for the Down Control String.
     */
    private static final String DOWN_CONTROL = "Down : ";
    
    /**
     * Static filed for the Drop Control String.
     */
    private static final String DROP_CONTROL = "Drop : ";
    
    /**
     * Static filed for the Rotate Control String.
     */
    private static final String ROTATE_CONTROL = "Rotate : ";
    
    /**
     * Static filed for the BOMB Control String.
     */
    private static final String BOMB_CONTROL = "Bomb : ";
    
    /**
     * Static Field for Border Color.
     */
    private static final Color COLOR_DARK_GREEN = new Color(88, 122, 23);
    
    /**
     * String containing the complete Title String.
     */
    private String myTitle;
    
    /**
     * String containing the complete left Control String.
     */
    private String myLeft;
    
    /**
     * String containing the complete right Control String.
     */
    private String myRight;
    
    /**
     * String containing the complete down Control String.
     */
    private String myDown;
    
    /**
     * String containing the complete Drop Control String.
     */
    private String myDrop;
    
    /**
     * String containing the complete rotate Control String.
     */
    private String myRotate;
    
    /**
     * String containing the complete Bomb Control String.
     */
    private String myBomb;
    
    /**
     * Field to store the PiecesMovement.
     */
    private final PieceMovement myMovement;
    
    /**
     * Constructs a Info Panel object.
     * 
     * @param theMovement is the PieceMovementObject.
     */
    public InfoPanel(final PieceMovement theMovement) {
        super();
        this.setBackground(PANEL_COLOR);
        myMovement = theMovement;
        initialSetUp();
    }
    
    /**
     * Sets up the initial complete strings for the score panel.
     */
    private void initialSetUp() {
        final Border one = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        final Border two = BorderFactory.createMatteBorder(4, 4, 4, 4, COLOR_DARK_GREEN);
        setBorder(BorderFactory.createCompoundBorder(one, two));
        myTitle = "Survival Controls";
        myLeft = LEFT_CONTROL + keyString(myMovement.getLeft());
        myRight  = RIGHT_CONTROL + keyString(myMovement.getRight());
        myDown  = DOWN_CONTROL + keyString(myMovement.getDown());
        myDrop = DROP_CONTROL + keyString(myMovement.getDrop());
        myRotate = ROTATE_CONTROL + keyString(myMovement.getRotate());
        myBomb = BOMB_CONTROL + keyString(myMovement.getBomb());
    }
    /**
     * Generates a the Char representation of the KeyStroke Value.
     * 
     * @param theVal the int value assigned to the key.
     * @return the Char value of the int.
     */
    private String keyString(final int theVal) {
        
        final String kS = KeyEvent.getKeyText(theVal);
        
        return kS;
        
    }
    
    /**
     * Method is used to draw Tetris score board.
     * 
     * @param theGraphics the Graphic to be drawn. 
     */
    protected void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;

        
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        final Point2D start = new Point2D.Float(0, 0);
        final Point2D end = new Point2D.Float(getWidth(), getHeight());
        final float[] linearDist = {0.0f, 1.0f};
        final Color[] linearColors = {PANEL_COLOR, Color.DARK_GRAY};
        final LinearGradientPaint linearGradient = 
                        new LinearGradientPaint(start, end, linearDist, linearColors);
        
        g2D.setPaint(linearGradient);
        g2D.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        final int titleX = 30;
        final int titleY = 20;
        final int textX = 25;
        g2D.setPaint(Color.LIGHT_GRAY);
        g2D.setFont(DEFAULT_TITLE);
        g2D.drawString(myTitle, titleX, titleY);
        g2D.setFont(DEFAULT_TEXT);
        g2D.drawString(myLeft, textX, 40);
        g2D.drawString(myRight, textX, 60);
        g2D.drawString(myDown, textX, 80);
        g2D.drawString(myDrop, textX, 100);
        g2D.drawString(myRotate, textX, 120);
        g2D.drawString(myBomb, textX, 140);
    }

}
