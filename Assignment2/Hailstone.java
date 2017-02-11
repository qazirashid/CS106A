/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		/* You fill this in */
        println("Enter an positive integer to get its Hailstone sequence");
        int input = readInt();
        
        int prevInput=input;
        String str;
        while(input > 1){
            str = ( input % 2 == 0) ? "\tis even, so I take half:\t" : "\tis odd,  so I make 3n+1:\t";
            prevInput = input;
            input = (input %2 == 0)? input/2 : 3*input+1;
            println(prevInput + str + input);
        }
        println("Done");

	}
}

