import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MazeTester {

    char[][] test = {{'-', '-', '-', '-'}, //4x4
                     {'-', 'X', '-', '-'},
                     {'-', 'X', '-', '-'},
                     {'E', 'X', '-', 'P'}};

    char[][] test2 = {{'-', '-', '-', '-', '-', 'X', '-'},//7x7
                      {'-', '-', '-', '-', '-', 'p', 'X'},
                      {'-', '-', '-', 'X', '-', '-', '-'},
                      {'-', '-', 'X', 'P', 'X', '-', '-'},
                      {'-', 'X', '-', '-', '-', '-', '-'},
                      {'X', 's', '-', '-', '-', 'X', 'X'},
                      {'-', '-', 'X', '-', '-', '-', 'E'}};

    char[][] test3 = {{'-', 'X', '-', '-', 'X', '-', '-', '-', 'X', 's'}, //10x10
                      {'-', 'X', '-', '-', '-', '-', '-', '-', 'X', '-'},
                      {'-', '-', '-', '-', 'X', '-', 'X', '-', 'X', '-'},
                      {'-', 'X', '-', '-', 'X', '-', 'p', '-', 'X', '-'},
                      {'-', 'X', 'X', 'X', 'X', '-', 'X', '-', '-', '-'},
                      {'X', 'X', '-', '-', '-', '-', '-', '-', 'X', 'X'},
                      {'-', '-', '-', 'X', '-', '-', '-', '-', '-', '-'},
                      {'-', 'X', '-', 'X', '-', '-', '-', '-', 'X', '-'},
                      {'-', 'X', '-', 'X', 'P', 'X', '-', '-', 'X', '-'},
                      {'E', '-', '-', 'X', 'X', '-', '-', 'X', 'X', 'P'},};

    char [][] maze2 = { {'-', 's', 'P', 'P', '-', 'P', '-', 'P', '-', '-', '-'},
                        {'-', '-', 'P', '-', '-', '-', 'P', '-', '-', '-', '-'},
                        {'-', 'P', '-', '-', 's', 'P', '-', '-', '-', '-', 'p'},
                        {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', 'P'},
                        {'s', 'E', 's', '-', 's', 's', '-', '-', '-', '-', '-'},
                        {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-'},
                        {'-', '-', '-', 'p', '-', 'p', 's', '-', '-', 's', '-'} };

    private final ByteArrayOutputStream capture_out = new ByteArrayOutputStream();
    private final PrintStream original_out = System.out;


    @org.junit.jupiter.api.Test
    void inDepthFirst() {
        Maze game = new Maze(test);
        //game.printBoard();
        int [] Scores = game.inDepthFirst();
        //System.out.println();
        //game.printBoard();
        int expectedPoints = 65;
        int expectedSteps = 16;
        int checkPoints = Scores[0];
        int checkSteps = Scores[1];
        //System.out.println("Points: " + Scores[0] + " " + "Number of steps: " + Scores[1]);
        assertEquals(expectedPoints, checkPoints);
        assertEquals(expectedSteps, checkSteps);
    }
    @org.junit.jupiter.api.Test
    void inDepthFirst2() {
        Maze game = new Maze(test2);
        //game.printBoard();
        int [] Scores = game.inDepthFirst();
        //System.out.println();
        //game.printBoard();
        int expectedPoints = 75;
        int expectedSteps = 23;
        int checkPoints = Scores[0];
        int checkSteps = Scores[1];
        //System.out.println("Points: " + Scores[0] + " " + "Number of steps: " + Scores[1]);
        assertEquals(expectedPoints, checkPoints);
        assertEquals(expectedSteps, checkSteps);
    }
    @org.junit.jupiter.api.Test
    void inDepthFirst3() {
        Maze game = new Maze(test3);
        //game.printBoard();
        int [] Scores = game.inDepthFirst();
        //System.out.println();
        //game.printBoard();
        int expectedPoints = 80;
        int expectedSteps = 50;
        int checkPoints = Scores[0];
        int checkSteps = Scores[1];
        //System.out.println("Points: " + Scores[0] + " " + "Number of steps: " + Scores[1]);
        assertEquals(expectedPoints, checkPoints);
        assertEquals(expectedSteps, checkSteps);
    }
    //****************************************************************************************************
    @Test
    void byLevel() {
        Maze game = new Maze(test);
        //game.printBoard();
        int [] Scores = game.byLevel();
        //System.out.println();
        //game.printBoard();
        int expectedPoints = 50;
        int expectedSteps = 6;
        int checkPoints = Scores[0];
        int checkSteps = Scores[1];
        //System.out.println("Points: " + Scores[0] + " " + "Number of steps: " + Scores[1]);
        assertEquals(expectedPoints, checkPoints);
        assertEquals(expectedSteps, checkSteps);
    }
    @Test
    void byLevel2() {
        Maze game = new Maze(test2);
        //game.printBoard();
        int [] Scores = game.byLevel();
        //System.out.println();
        //game.printBoard();
        int expectedPoints = 75;
        int expectedSteps = 35;
        int checkPoints = Scores[0];
        int checkSteps = Scores[1];
        //System.out.println("Points: " + Scores[0] + " " + "Number of steps: " + Scores[1]);
        assertEquals(expectedPoints, checkPoints);
        assertEquals(expectedSteps, checkSteps);
    }
    @Test
    void byLevel3() {
        Maze game = new Maze(test3);
        //game.printBoard();
        int [] Scores = game.byLevel();
        //System.out.println();
        //game.printBoard();
        int expectedPoints = 95;
        int expectedSteps = 68;
        int checkPoints = Scores[0];
        int checkSteps = Scores[1];
        //System.out.println("Points: " + Scores[0] + " " + "Number of steps: " + Scores[1]);
        assertEquals(expectedPoints, checkPoints);
        assertEquals(expectedSteps, checkSteps);
    }
    //****************************************************************************************************
    @Test
    void QScompetition() {
        System.setOut(new PrintStream(capture_out));
        Maze game = new Maze(test);
        String extected = "Stacks win!!!";
        game.QScompetition();
        String capture = capture_out.toString();
        assertEquals(extected, capture);
        System.setOut(original_out);
    }
    @Test
    void QScompetition2() {
        System.setOut(new PrintStream(capture_out));
        Maze game = new Maze(test2);
        String extected = "Queues win!!!";
        game.QScompetition();
        String capture = capture_out.toString();
        assertEquals(extected, capture);
        System.setOut(original_out);
    }
    @Test
    void QScompetition3() {
        System.setOut(new PrintStream(capture_out));
        Maze game = new Maze(test3);
        String extected = "Queues win!!!";
        game.QScompetition();
        String capture = capture_out.toString();
        assertEquals(extected, capture);
        System.setOut(original_out);
    }
    @Test
    void QScompetition4() {
        //System.setOut(new PrintStream(capture_out));
        Maze game = new Maze(maze2);
        //String extected = "Queues win!!!";
        game.QScompetition();
        //String capture = capture_out.toString();
        //assertEquals(extected, capture);
        //System.setOut(original_out);
    }
}