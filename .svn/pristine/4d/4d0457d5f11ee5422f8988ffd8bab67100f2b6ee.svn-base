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
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import model.AbstractPiece;
import model.Block;
import model.Board;
import model.Piece;

/**
 * Creates a Score Panel that contains the level, score, 
 * and lines cleared. 
 * 
 * @author Jeremy Wolf 
 * @version 6 December 2015
 */

public class ScorePanel extends JPanel implements Observer {
    
    /**
     * A generated serial version UID for object Serialization.
     */
    private static final long serialVersionUID = -7001743376006618386L;
    
    /**
     * Static field storing the background color.
     */
    private static final Color PANEL_COLOR = Color.BLACK;
    
    /**
     * Static field for Title Font.
     */
    private static final Font DEFAULT_TITLE = new Font("Title", Font.BOLD, 13);
    
    /**
     * Static field for Text Font.
     */
    private static final Font DEFAULT_TEXT = new Font("Text", Font.PLAIN, 11);
    
    /**
     * Static field to store the score string.
     */
    private static final String SCORE_STRING = "Score: ";
    
    /**
     * Static field to store the Lines Cleared string.
     */
    private static final String LINESCLEARED_STRING = "Lines Cleared: ";
    
    /**
     * Static field to store the Level string.
     */
    private static final String LEVEL_STRING = "Current Level: ";
    
    /**
     * Static field to store the score string.
     */
    private static final String LINESUNTIL_STRING = "Lines Until Next Level: ";
    
    /**
     * Static Field to store the Bomb status string.
     */
    private static final String BOMB_STATUS = "Bomb Status: ";
    
    /**
     * Static Field to store the Bomb status string.
     */
    private static final String BOMB_READY = "READY";
    
    /**
     * Static Field for Border Color.
     */
    private static final Color COLOR_DARK_GREEN = new Color(88, 122, 23);
    
    /**
     * Complete score string.
     */
    private String myScoreString;
    
    /**
     * Complete lines cleared string.
     */
    private String myCleared;
    
    /**
     * Complete current level string.
     */
    private String myCurrentLevel;
    
    /**
     * Complete lines until next level string.
     */
    private String myNextLevelCount;
    
    /**
     * Field to store the score object.
     */
    private final Score myScore;
    
    /**
     * Complete Bomb Status String.
     */
    private String myBombStatus;
    
    /**
     * Field to store the BombTracker object.
     */
    private final BombTracker myBombTracker;
    /**
     * Constructs a Score Panel object.
     * 
     * @param theTracker the Bomb Tracker Object.
     */
    public ScorePanel(final BombTracker theTracker) {
        super();
        this.setBackground(PANEL_COLOR);
        myBombTracker = theTracker;
        myScore = new Score();
        myScore.addObserver(this);
        myScore.addObserver(theTracker);
        initialSetUp();
    }
    
    /**
     * Sets up the initial complete strings for the score panel.
     */
    private void initialSetUp() {
        final Border one = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        final Border two = BorderFactory.createMatteBorder(4, 4, 4, 4, COLOR_DARK_GREEN);
        setBorder(BorderFactory.createCompoundBorder(one, two));

        myScoreString =  SCORE_STRING + myScore.getScore();
        myCleared = LINESCLEARED_STRING + myScore.getLines();
        myCurrentLevel = LEVEL_STRING + myScore.getLevel();
        myNextLevelCount = LINESUNTIL_STRING + myScore.getLinesLeft();
        myBombStatus = BOMB_STATUS + BOMB_READY;  
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
        final Point2D start = new Point2D.Float(0, getWidth() / 2);
        final Point2D end = new Point2D.Float(getWidth(), getHeight());
        final float[] linearDist = {0.0f, 1.0f};
        final Color[] linearColors = {PANEL_COLOR, Color.DARK_GRAY};
        final LinearGradientPaint linearGradient = 
                        new LinearGradientPaint(start, end, linearDist, linearColors);
        final int titleX = 40;
        final int titleY = 30;
        final int textX = 25;
        g2D.setPaint(linearGradient);
        g2D.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        g2D.setPaint(Color.LIGHT_GRAY);
        g2D.setFont(DEFAULT_TITLE);
        g2D.drawString(myCurrentLevel, titleX, titleY);
        g2D.setFont(DEFAULT_TEXT);
        g2D.drawString(myScoreString, textX, 50);
        g2D.drawString(myCleared, textX, 70);
        g2D.drawString(myNextLevelCount, textX, 90);
        g2D.drawString(myBombStatus, textX, 110);
    }
    /**
     * Update method when notification is received from the Observable object.
     */
    @Override
    public void update(final Observable theO, final Object theArg) {
        myScoreString =  SCORE_STRING + myScore.getScore();
        myCleared = LINESCLEARED_STRING + myScore.getLines();
        myCurrentLevel = LEVEL_STRING + myScore.getLevel();
        myNextLevelCount = LINESUNTIL_STRING + myScore.getLinesLeft();
        if (theO instanceof Board) {
            final Piece current = ((Board) theO).getCurrentPiece();
            if (((AbstractPiece) current).getBlock() == Block.B) {
                myBombStatus = BOMB_STATUS + "INCOMING";
            } else {
                myBombStatus = BOMB_STATUS + BOMB_READY;
            }
        }
        repaint();
    }

    
    /**
     * Getter method for the Score object.
     * 
     * @return the myScore Object.
     */
    public Score getScoreObject() {
        return myScore;
    }
    
    /**
     * Resets all fields for a new game. Fields in the BombTracker and 
     * Score objects will be reset to default values.
     */
    public void resetValues() {
        myScore.resetScore();
        myBombTracker.resetBombs();
        repaint();
    }

}
