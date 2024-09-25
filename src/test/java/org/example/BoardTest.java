package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Sign.O;
import static org.example.Sign.X;

class BoardTest {
    @Test
    void shouldFind1stRowXWin() {
        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(0, 0, X));
        board.addMove(new Coordinates(0, 1, X));
        board.addMove(new Coordinates(0, 2, X));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFind2ndRowXWin() {
        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(1, 0, X));
        board.addMove(new Coordinates(1, 1, X));
        board.addMove(new Coordinates(1, 2, X));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFind3rdRowOWin() {
        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(2, 0, O));
        board.addMove(new Coordinates(2, 1, O));
        board.addMove(new Coordinates(2, 2, O));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFind1stColumnXWin() {

        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(0, 0, X));
        board.addMove(new Coordinates(1, 0, X));
        board.addMove(new Coordinates(2, 0, X));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFind3rdColumnXWin() {

        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(0, 2, X));
        board.addMove(new Coordinates(1, 2, X));
        board.addMove(new Coordinates(2, 2, X));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFind1stDiagonalXWin() {

        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(0, 0, X));
        board.addMove(new Coordinates(1, 1, X));
        board.addMove(new Coordinates(2, 2, X));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldFind2ndDiagonalXWin() {

        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(0, 2, X));
        board.addMove(new Coordinates(1, 1, X));
        board.addMove(new Coordinates(2, 0, X));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertTrue(result);
    }

    @Test
    void shouldNotFindWinWhenTie() {

        // Given
        var board = new Board(3);
        board.addMove(new Coordinates(0, 0, X));
        board.addMove(new Coordinates(0, 1, O));
        board.addMove(new Coordinates(0, 2, X));
        board.addMove(new Coordinates(1, 0, O));
        board.addMove(new Coordinates(1, 1, O));
        board.addMove(new Coordinates(1, 2, X));
        board.addMove(new Coordinates(2, 0, O));
        board.addMove(new Coordinates(2, 1, X));
        board.addMove(new Coordinates(2, 2, O));

        // When
        boolean result = board.checkWin();

        // Then
        Assertions.assertFalse(result);
    }

    @Test
    void shouldReturnWinner() {
        // Given
        Board board = new Board(3);
        board.addMove(new Coordinates(0, 0, X));
        board.addMove(new Coordinates(0, 1, X));
        board.addMove(new Coordinates(0, 2, X));
        board.checkWin();

        // When
        Sign result = board.getWinner();

        // Then
        Assertions.assertEquals(X, result);
    }

}