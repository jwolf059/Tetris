/*
 * Assignment 6
 * 
 * TCSS305 - Autumn 2015
 */

package model;

/**
 * Defines the Tetris BPiece. This Piece is a bomb.
 * 
 * @author Jeremy Wolf
 * @version 7 December 2015
 */
public final class BPiece extends AbstractPiece {

    /**
     * The x and y-coordinates for all rotations of a ZPiece.
     * The x coordinate is listed first, then the y coordinate.
     */
    private static final int[][][] MY_ROTATIONS = {{{0, 1}, {1, 0}, {1, 2}, {2, 1}}};
    
    /**
     * Creates a new Z piece at the given coordinates.
     * 
     * @param theX The x coordinate of the Piece.
     * @param theY The y coordinate of the piece
     */
    protected BPiece(final int theX, final int theY) {
        super(MY_ROTATIONS, theX, theY, Block.B);
    }

}
