/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

	// You fill in this part
    private int putAllowed=1; //initially put is allowed.
    private int east=1; // initially moving east    
    public void run(){
           fillRow();
           goToBeginRow();
           while(leftIsClear()){
               moveUp();
               fillRow();
               goToBeginRow();
           }
    }

    private void putIfAllowed(){
            if(putAllowed == 1){
                putBeeper();
                putAllowed =0;
            }
            else{
                putAllowed=1;
            }

    }
    //Fill row. Go East untill row is full.
    //When row is full, turn Left, and Fill the next row going West
    //At the end of this row, go up and face East. Repeat.
    private void fillRow(){
        while(frontIsClear()){
            putIfAllowed();
            move();
        }
        putIfAllowed();
    }
    private void turnBack(){
        turnLeft();
        turnLeft();
    }
    /**
     * After Karel has finished filling a row, 
     * it goes back to be begining of row.
     */
    //Precondition: Karel facing east at the end of a row just filled.
    //Poscondition: karel facing east at the beginning of a filled row
    //After moving to the begining of a filled row, karel checks whether
    //the first squre of next row should contain a beeper.
    private void goToBeginRow(){
        turnBack();
        while(frontIsClear()){
            move();
        }
        turnBack();
        if(beepersPresent())
            putAllowed=0;
        else
            putAllowed=1;
    }
    
    //When karel is standing at the beginning of a filled row,
    //it needs to move up the next row.
    // Precondition: Karel facing east at the beginning of a filled row.
    //Post condition: Karel facing east at the begining of next unfilled row.

    private void moveUp(){
        turnLeft();
        move();
        turnRight();
    }
    //Tests if there is another row to be filled.
    //Test this when karel has filled a  row and has returned to begining

}
