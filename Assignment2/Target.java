/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
    private int winWidth, winHeight;
	public void run() {
		/* You fill this in. */
        winWidth = getWidth();
        winHeight= getHeight();
        drawOval(1.00, java.awt.Color.RED);
        drawOval(0.65, java.awt.Color.WHITE);
        drawOval(0.30, java.awt.Color.RED);
	}
    //returns a GOval object specified width at the center of window. 
    //The constructor for GOval, Goval(x,y, w, h), creates an oval whose top left corner is at x,y.
    //We want an oval such that center of oval is at center of window
    //and the oval has specified width.

    private GOval circleAtCenter(double width){
        GOval oval = new GOval((winWidth-width)/2, (winHeight - width)/2, width,width); 
        return oval; 
    }
   
    //Draws an oval (circle) of the specified width at the center of the window. 
    //radius is specified in inches. 
    private void drawOval(double radius, java.awt.Color color){
        double radiusInPixels = inchToPixel(radius);
        double ovalWidth = radiusToWidth(radiusInPixels);
        GOval oval = circleAtCenter(ovalWidth);
        oval.setFilled(true);
        oval.setFillColor(color);
        add(oval);
    }
    //convert the radius of cirle to width of circle.
    private double radiusToWidth(double r){
        return 2*r;
    }
    private double inchToPixel(double inch){
        return inch*72;
    }
}
