/*
 * Assignment 6
 * 
 * TCSS305 Autumn 2015
 */
package view;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creates a JPanel with a LinearGradient Painted on it. Used as the background
 * for the main JFrame for tetris.
 * 
 * @author Jeremy Wolf
 * @version 9 December 2015
 */
public class GradientPanel extends JPanel {
    
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -547084878890437620L;

    /**
     * Static Field for Color one.
     */
    private static final Color COLOR_OLIVE = new Color(50, 74, 24);
    
    /**
     * Static Field for Color two.
     */
    private static final Color COLOR_TAN = new Color(89, 89, 63);
    
    /**
     * Static Field for Color Three.
     */
    private static final Color COLOR_SAND = new Color(122, 122, 62);
    
    /**
     * Field to store the main JFrame.
     */
    private final  JFrame myFrame;
    
    
    /**
     * Constructor for the Gradient Panel.
     * @param theFrame the JFrame that this panel will be put on.
     */
    public GradientPanel(final JFrame theFrame) {
        super();
        myFrame = theFrame;
        setOpaque(true);
    }
    
    /**
     * Method is used to draw Tetris background Gradient .
     * 
     * @param theGraphics the Graphic to be drawn. 
     */
    protected void paintComponent(final Graphics theGraphics) {

        super.paintComponent(theGraphics);
        final Graphics2D g2D = (Graphics2D) theGraphics;

        g2D.setPaint(COLOR_OLIVE);
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        final Point2D start = new Point2D.Float(0, 0);
        final Point2D end = new Point2D.Float(myFrame.getWidth(), myFrame.getHeight());
        final float[] dist = {0.0f, 0.5f, 1.0f};
        final Color[] colors = {COLOR_SAND, COLOR_OLIVE, COLOR_TAN};
        final LinearGradientPaint gradient = new LinearGradientPaint(start, end, dist, colors);
        
        g2D.setPaint(gradient);
        g2D.fill(new Rectangle(0, 0, myFrame.getWidth(), myFrame.getHeight()));

    }
}
