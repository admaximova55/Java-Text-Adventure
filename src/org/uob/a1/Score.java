package org.uob.a1;

public class Score {
    private int startingScore;
    private int currentScore;
    private int numRoomsVisited;
    private int numPuzzlesSolved;
    private final int PUZZLE_VALUE = 10;

    public Score( int startingScore){
        this.startingScore = startingScore;
        this.currentScore = startingScore;
        this.numRoomsVisited = 0;
        this.numPuzzlesSolved = 0;
            
    }//Score 

    public void visitRoom(){
        numRoomsVisited += 1;
    }//visitRoom

    public void solvePuzzle(){
        numPuzzlesSolved += 1;
    }//solvePuzzle

    public double getScore(){
        currentScore = startingScore - numRoomsVisited + (numPuzzlesSolved * PUZZLE_VALUE);
        return currentScore;
    }//getScore
    

     
}//class