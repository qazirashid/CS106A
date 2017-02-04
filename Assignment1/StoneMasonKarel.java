/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {

	// You fill in this part
    private int dir=0; // 0 =East, 1= North, 2=West, 3 = South
    private int street=1; // current street of Karel
    private int avenue=1; // Avenue of Karel
    public void run(){
        //Move up the avenue. As long as frontIsClear(), 
        //check if beeper is present. if not put a beeper.
        while(frontIsClear()){
            buildCol();
            moveToNextAvenue();
        }
        buildCol();
    }
    private void buildCol(){
        //Move up the avenue. As long as frontIsClear(), 
        //check if beeper is present. if not put a beeper.
        //karel now faces North on 1st avenue.
        turnLeft();
        while(frontIsClear()){
            if(noBeepersPresent()){
                putBeeper();
            }
            move();
        }
        if(noBeepersPresent())
            putBeeper();
    }
    private void turnBack(){
        turnLeft();
        turnLeft();
    }
    private void goToBottom(){
        //karel is at the top of a column. he should move to the bottom
        //He turns back and moves forward until front is clear.
        turnBack();
        while(frontIsClear())
            move();
        turnLeft();
        //At the bottom, karel faces East and waits.
    }
    private void moveEast4Avenues(){
        for(int i=1; i<5; i++) 
            move();
    }
    private void moveToNextAvenue(){
        //karel has just finished building a column.
        //He starts by turning south going down until he reaches the bottom.
        goToBottom();
        moveEast4Avenues();
    }


}
