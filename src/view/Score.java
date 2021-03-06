/*
 * Assignment 6
 * 
 * TCSS305 Autumn 2015
 */
package view;

import java.util.Observable;

/**
 * Creates a Score object that contains the level, score, 
 * and lines cleared. 
 * 
 * @author Jeremy Wolf 
 * @version 6 December 2015
 */
public class Score extends Observable {

    /**
     * Static field for the base score.
     */
    private static final int BASE_SCORE = 50;
    
    /**
     * Static field for the next level step.
     */
    private static final int STEP = 7;
    /**
     * Field to store the score.
     */
    private int myScore;
    
    /**
     * Field to store the number of lines cleared.
     */
    private int myNumLines;
    
    /**
     * Field to store the current Level.
     */
    private int myCurrentLevel;
     
    /**
     * Field to store the number of lines until next level.
     */
    private int myLinesUntil;
    
    /**
     * Field to the boolean on if a new bomb is added.
     */
    private boolean myAddBomb;
    /**
     * Constructor for the Score object.
     */
    public Score() {
        super();
        myScore = 0;
        myNumLines = 0;
        myCurrentLevel = 1;
        myLinesUntil = STEP;
        myAddBomb = false;
    }
    
    /**
     * Updates the lines until counter to determine when to go
     * to the next level.
     * @param theNum the number of lines cleared this step.
     */
    private void updateLinesUntil(final int theNum) {
        myLinesUntil -= theNum;
        if (myLinesUntil == 0) {
            levelUp();
            myLinesUntil = STEP;
            myAddBomb = false;
        }
    }
    
    /**
     * Steps the difficulty level up.
     */
    private void levelUp() {
        final int levelMark = 7;
        myCurrentLevel += 1;
        if (myCurrentLevel % levelMark == 0) {
            myAddBomb = true;
            setChanged();
            notifyObservers();
        }  
    }
    
    /**
     * adds a line to the score and line tracker.
     * @param theNum the number of lines cleared this step.
     */
    public void addNumLines(final int theNum) {
        myNumLines += theNum;
        myScore += BASE_SCORE * myCurrentLevel;
        updateLinesUntil(theNum);
        setChanged();
        notifyObservers();
    }
    
    /**
     * Getter method for the current score.
     * 
     * @return Integer value for the score.
     */
    public int getScore() {
        return myScore;
    }
    
    /**
     * Getter method for the current level.
     * 
     * @return Integer value for the level.
     */
    public int getLevel() {
        return myCurrentLevel;
    }
    
    /**
     * Getter method for the number of lines cleared.
     * 
     * @return Integer value for the lines cleared.
     */
    public int getLines() {
        return myNumLines;
    }
    
    /**
     * Getter method for the number of lines left to level up.
     * 
     * @return Integer value for the lines left to level up..
     */
    public int getLinesLeft() {
        return myLinesUntil;
    }
    
    /**
     * Getter method for the number of lines left to level up.
     * 
     * @return Boolean value to determine if a new bomb was earned..
     */
    public Boolean getAddBomb() {
        return myAddBomb;
    }
    
    /**
     * Resets all score fields. myScore, myNumLines, myCurrentLevel, and 
     * myLinesUntil will be reset to default values.
     */
    public void resetScore() {
        myScore = 0;
        myNumLines = 0;
        myCurrentLevel = 1;
        myLinesUntil = STEP;
    }
}   
