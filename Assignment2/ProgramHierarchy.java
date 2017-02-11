/*
 * File: ProgramHierarchy.java
 * Name: Qazi Hamid
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
/** 
 * Draws a Program Hierarchy of acm.program 
 */
public class ProgramHierarchy extends GraphicsProgram {	
	private final double  rectWidth = 120, rectHeight=50;
    private final double level1Y = 20, level2Y = level1Y + 100 + rectHeight;
    private double winWidth, winHeight, centerX, centerY;
    public void run() {
        winWidth = getWidth();
        winHeight = getHeight();
        centerX = winWidth/2;
        centerY = winHeight/2;
        /** 
         * instantiate 4 rectangle. 1 on level 1 and 3 on level 2.
         * The rectangle on level 1 is X centered on screen.
         * The three rectangles on level 2 are distributed with the middle
         * rectangle X centered.
         * The X separation between the rectangles is rectWidth/2;
        */
        GRect r0     = new GRect(centerX - rectWidth/2, level1Y, rectWidth, rectHeight);
        GRect r10    = new GRect(centerX - 2*rectWidth, level2Y,rectWidth, rectHeight);
        GRect r11    = new GRect(centerX - rectWidth/2, level2Y,rectWidth, rectHeight);
        GRect r12    = new GRect(centerX + rectWidth, level2Y,rectWidth, rectHeight);
        
        /**
         * instantiate three lines. From the rectangle on level 1 to each of the 3
         * rectangles on level 2.
         */
        GLine line10 = getLine(r0, r10);
        GLine line11 = getLine(r0, r11);  
        GLine line12 = getLine(r0, r12);
        
        /**
         * instantiate 4 labels, one for each rectangle
         */

        GLabel l0     = getLabel("Program", r0);
        GLabel l10    = getLabel("GraphicsProgram", r10);
        GLabel l11    = getLabel("ConsoleProgram", r11);
        GLabel l12    = getLabel("DialogProgram", r12);
        
        /**
         * Draw 4 rectangles, 3 lines, and 4 labels on canvas
         */
        add(r0);add(r10); add(r11); add(r12);
        add(l0); add(l10); add(l11); add(l12);
        add(line10); add(line11); add(line12);
	}
    

    /** GLine getLine(GRect, GRect) returns a line that connects the
    * two rectangle. The line joins the center of bottom of upper triangle
    * to the center of top of the lower triangle.
    */

    private GLine getLine(GRect r1, GRect r2){
        // Determine which rectangle is upper rectangle.
        double x1, y1, x2, y2;
        GRect upper, lower;
        upper = r1;
        lower = r2;
        if( r1.getY() > r2.getY()){
            upper = r2;
            lower = r1;
        }
        x1 = upper.getX() + upper.getWidth()/2;
        x2 = lower.getX() + lower.getWidth()/2;
        y1 = upper.getY() + upper.getHeight();
        y2 = lower.getY();
        GLine line = new GLine(x1,y1,x2,y2);
        return line; 
    }
    
    /**
     * returns a GLabel with given String
     * centered at the specified rectangle.
     */
    GLabel getLabel(String text, GRect r){
        double rxCenter = r.getX() + r.getWidth()/2;
        double ryCenter = r.getY() + r.getHeight()/2;
    
        GLabel label = new GLabel(text);
        double lx  = rxCenter - label.getWidth()/2;
        double ly  = ryCenter + label.getHeight()/2;

        label = new GLabel(text, lx, ly);
        return label;
    }

    /**
     * Draw a label with specified text and coordinates of center
     */

     private void drawLabel(String text, double xCenter, double yCenter){
        GLabel label = new GLabel(text, xCenter, yCenter);
        //label's left hand corner is at xCenter, yCenter
        double lw = label.getWidth();
        double lh = label.getHeight();
        //label.move(lw, lh);
        add(label);
        GLabel lSize = new GLabel("(" + lw + "," + lh + ")", 20, 300);
        add(lSize);
        GRectangle boundaryRect = label.getBounds();
        GRect enclosingRect = new GRect(lw, lh);
        enclosingRect.setBounds(boundaryRect);
        add(enclosingRect);
    }

    private void drawLine(double x1, double y1, double x2, double y2){
        GLine line = new GLine(x1, y1, x2, y2);
        add(line);
    }
    private void drawGrid(double gSize){
        int i;
        //draw horizontal lines
        for(i=0; i<20; i++)
            drawLine(0, i*gSize, 20*gSize, i*gSize);
        //draw vertical lines
        for(i=0; i<20; i++)
            drawLine(i*gSize, 0, i*gSize, 20*gSize);
    }
}

