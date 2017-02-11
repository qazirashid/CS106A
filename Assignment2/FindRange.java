/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		int max=0, min=0, next=0, sentinel=0;
        println("This program finds the largest and smallest integers among all integers entered by user");
        println("Enter " + sentinel + " to stop data entery");
        while( (next = readInt()) != sentinel){
            max = (max < next) ? next: max ;
            min = (min > next) ? next: min ;
        }
        println(" Smallest: " + min);
        println(" Largest: " + max);

	}
}

