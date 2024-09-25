package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.example.State.*;

public class Board {
    private final int size;
    private final Sign[][] table;
    private State state = ONGOING;
    private Sign winner;

    public Board(int size) {
        this.size = size;
        table = new Sign[size][size];
    }

    void printState() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String sign = table[i][j] == null ? " " : table[i][j].toString();
                System.out.print(" | " + sign + " | ");
            }
            System.out.println();
        }
    }

    public boolean checkWin() {
        // horizontal
        for (int i = 0; i < size; i++) {
            Sign sign = table[i][0];
            boolean result = Arrays.asList(table[i]).subList(0, size).stream()
                    .allMatch(s -> sign != null && s == sign);
            if (result) {
                state = WON;
                winner = sign;
                return true;
            }
        }

        // vertical
        for (int i = 0; i < size; i++) {
            Sign sign = table[0][i];
            List<Sign> toCheck = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                toCheck.add(table[j][i]);
            }
            boolean result = toCheck.stream().allMatch(s -> sign != null && s == sign);
            // Going through the array twice - it could be checked in for loop already
            if (result) {
                state = WON;
                winner = sign;
                return true;
            }
        }

        // diagonals
        // 1st & 2nd
        Sign sign = table[0][0];
        int maxIndex = size - 1;
        Sign sign2 = table[0][maxIndex];
        List<Sign> toCheck = new ArrayList<>();
        List<Sign> toCheck2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            toCheck.add(table[i][i]);
            toCheck2.add(table[i][maxIndex - i]);
        }
        boolean result = toCheck.stream().allMatch(s -> s == sign);
        boolean result2 = toCheck2.stream().allMatch(s -> s == sign2);
        if (result || result2) {
            state = WON;
            winner = sign;
            return true;
        }

        // tie
        boolean tieResult = Arrays.stream(table).allMatch(Objects::nonNull);
        if (tieResult) {
            state = TIE;
            winner = null;
        }

        return false;
    }

    public Sign getWinner() {
        if (state == ONGOING) {
            throw new IllegalStateException("not yet");
        }
        return winner;
    }

    public void addMove(Coordinates move) {
        if (table[move.x()][move.y()] != null) {
            throw new IllegalStateException("That place is taken");
        } else {
            table[move.x()][move.y()] = move.sign();
        }
    }
}
