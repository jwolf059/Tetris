/*
 * Assignment 6
 * 
 * TCSS305 - Autumn 2015
 */
package view;
import java.awt.EventQueue;

/**
 * Driver Class for the Tetris Game.
 * 
 * @author Jeremy Wolf
 * @version 24 November 2015
 */

public final class TetrisMain {

    /**
     * Private Constructor to ensure this class can not be created.
     */
    private TetrisMain() {
        throw new IllegalStateException();
    }

    /**
     * Driver method that starts the PowerPaintGUI.
     * @param theArgs Command line arguments, ignored.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TetrisGUI();
            }
        });
    }

}
