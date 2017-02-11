/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		/* You fill this in */
        int x, y; double c;
        print(" values to compute Pythagorean Theorem. \n a:");
        x = readInt();
        print(" b: ");
        y = readInt();

        c = Math.sqrt(x*x + y*y);
        println("\n c:" + c);

	}
}
