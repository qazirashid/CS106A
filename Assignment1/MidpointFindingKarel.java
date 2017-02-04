/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {

    public void run(){
        fillRow();
        while(beepersPresent()){
            gotoLeft();
            pickFirstAndLast();
            moveBackward();
        }
        //Karel is facing east standing one square to the left 
        //of the center square.
        //Move one squre and put a beeper.
        move();
        putBeeper();
    }
    
    /*
     * Karel fills a whole row with Beepers.
    */
    //Precondition: Karel facing east on first avenue and first street.
    //Post condition: Karel facing east on last avenue of first street.
    private void fillRow(){
        while(frontIsClear()){
            putBeeper();
            move();
        }
        putBeeper();
    }
    //Karel picks the first and the last beeper in a row.
    //Precondition. Karel standing at the leftMost beeper.
    //Postconditin. If the row contains any beepers then
    //karel standins one square to the right of right most beeper
    //otherwise, if row becomes empty with no beeper, then karel stands
    //At the center square.
    private void pickFirstAndLast(){
        pickBeeper(); //First Beeper picked.
        move();
        while(beepersPresent()){
            if(frontIsClear())
                move(); //Looking for last beeper.
            else{
                break; //karel reached a wall.
            }
        }

        if(beepersPresent())
            pickBeeper(); //picked the last Beeper.
            //This will happen if karel reached a wall and last square had a 
            //a beeper.
        else{
            //Karel did not reach a wall. he just went into a empty squre right
            //of the right most beeper.
            //He moves backward and picks a beeper.
            moveBackward();
            if(beepersPresent())
                pickBeeper();
        }
    }
    //Karel goes to the leftMost Beeper.
    //precondition. Karel facing east standing one square to the right of right
    //most beeper.
    //postcondition. Karel facing east on the left most beeper.
    void gotoLeft(){
        turnBack();
        while(beepersPresent()){
            if(frontIsClear())
                move();
            else
                break;
        }
        turnBack();
        if(noBeepersPresent()){
            move();
        }
    }
    //Karel moves one step backward. Karel does not change direction.
    private void moveBackward(){
        turnBack();
        if(frontIsClear())
            move();
        turnBack();
    }

    //Karel turns back
    private void turnBack(){
        turnLeft();
        turnLeft();
    }
    //Karel checks whether the left most beeper is the last beeper.
    //precondition: Karel facing east standing at left most beeper.
}
