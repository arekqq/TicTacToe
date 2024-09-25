package org.example;

/*
Develop a Java application for playing Tic-Tac-Toe on a 3x3 board.
The game should support two players taking turns,
detect the winner or declare a tie, and allow multiple rounds of play.

To do:
- Implement a 3x3 game board where two players can place their
symbols (X and O) alternately.
- The game should detect and announce the winner when a player
aligns three of their symbols horizontally, vertically, or diagonally,
or declare a tie if the board is full with no winner.
- Provide a user interface (console or GUI) that displays the
board, prompts players for their moves, and shows game results.
- Include unit tests for the game logic to validate moves,
detect wins, and handle ties.
 */

import java.io.Console;

import static org.example.Sign.O;
import static org.example.Sign.X;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        Console console = System.console();
        console.printf("Hello in Tic-Tac-Toe Game!");
        console.printf(System.lineSeparator());
        console.printf("Please insert your move coordinates - e.g: 0,1");
        console.printf(System.lineSeparator());
        console.printf("X starts");
        console.printf(System.lineSeparator());

        boolean moveSemaphore = true;
        while (true) {
            String input = console.readLine();
            Sign sign = moveSemaphore ? O : X;
            Coordinates move = Coordinates.parse(input, sign);
            board.addMove(move);
            board.printState();
            if (board.checkWin()) {
                console.printf("%s won!", board.getWinner());
                return;
            }
            console.printf("Now it's " + sign + "move, enter coordinates: ");
            moveSemaphore = !moveSemaphore;
        }
    }
}