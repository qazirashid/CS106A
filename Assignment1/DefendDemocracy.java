/**
 * Karel defends democracy
 */

import stanford.karel.*;

public class DefendDemocracy extends SuperKarel{
    public void run(){
        while(frontIsClear())
            processRectangle();
    }
    // Karel enters a new rectangle and checks whether a beeper is present.
    // If there is a beeper, karel moves out of the rectangle.
    // Else, karel cleans the rectangle.
    // Precondition: Karel facing east at the enterance of a rectangle.
    // Postcondition: Karel facing east at the exit (enterance of next rectangle)
    // of the processed rectangle.
    private void processRectangle(){
        move();
        //karel stepped into the rectangle.
        if(beepersPresent()){
            //Karel found a beeper. he needs to move out.
            move(); 
            //Karel is at the exit. Done.
        }else{
            //Karel did not find a beeper.
            //Karel must clean the neigbouring squares.
            cleanUpperSquare();
            cleanLowerSquare();
            move();
        }
        
    }
    private void turnBack(){
        turnLeft();
        turnLeft();
    }
    // Karel cleans the upper square
    // Precondition: karel at the center square, facing East.
    // Postcondition: Karel at the center squre, facing East. No beeper in upper square.
    private void cleanUpperSquare(){
        turnLeft();
        move();
        while(beepersPresent())
            pickBeeper();
        turnBack();
        move();
        turnLeft();
    }
    private void cleanLowerSquare(){
        turnRight();
        move();
        while(beepersPresent())
            pickBeeper();
        turnBack();
        move();
        turnRight();
    }


}
