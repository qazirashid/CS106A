/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 20;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 20;
    private static final int PHI=1;
    private int winWidth;
    private int winHeight;

	public void run() {
        //draw a pyramid, layer by layer.
        winWidth  = getWidth();
        winHeight = getHeight(); 
        for(int layer=0; layer < BRICKS_IN_BASE; layer++)
            drawPyramidLayer(layer, BRICKS_IN_BASE - layer);
	}
    //drawBrick() draws a single brick at the given coordinate.
    //The coordinates are traditional graph coordinates and not the screen coordinate.
    //(0,0) is the bottom left corner.

    private void drawBrick(int x, int y){
        GRect rect = new GRect(x, winHeight - y - BRICK_HEIGHT-1, BRICK_WIDTH, BRICK_HEIGHT);        
        add(rect);
    }
    //drawBrickLine(int xStart, int yStart, int N) 
    //Draws a sequence of N Bricks. Starting at x = xstart and y=ystart.
    //it is a horizontal line of bricks.
    private void drawBrickLine(int xStart, int yStart, int N){
        for ( int i=0; i < N; i++)
            drawBrick(xStart + i * BRICK_WIDTH, yStart );
    }
    //drawPyramidLayer(Layer, N), draws layer number Layer with N bricks)
    // xStart of layer is calculated so that the layer is in the centre screen along x-axis.
    private void drawPyramidLayer(int Layer, int N){
       // Layer is the layer number. layer 0 starts at y=0. layer 1 starts at y=BRICK_HEIGHT
       int yStart = Layer * BRICK_HEIGHT;
       int xStart = (winWidth - N * BRICK_WIDTH)/2;
       drawBrickLine(xStart, yStart, N);
    }
}

