package com.company;

import java.awt.*;
import java.util.Arrays;

public class Board {
    public static final int SIZE = 3;

    public Board() {
        for (int i = 0; i < SIZE; ++i) {
            Arrays.fill(matrix[i], CellState.EMPTY);
        }
    }

    public final void print() {
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                switch (matrix[i][j]) {
                    case EMPTY:
                        System.out.print('e');
                        break;
                    case X:
                        System.out.print('x');
                        break;
                    case O:
                        System.out.print('o');
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }

    public boolean isWinningStep(final Point step, final CellState stepType) {
        boolean winingAngle1 = true;
        boolean winingAngle2 = true;
        boolean winningRow = true;
        boolean winningCol = true;
        for (int i = 0; i < Board.SIZE; ++i) {
            if (getState(new Point(step.x, i)) != stepType) {
                winningRow = false;
            }
            if (getState(new Point(i, step.y)) != stepType) {
                winningCol = false;
            }
            if (getState(new Point(i, i)) != stepType) {
                winingAngle1 = false;
            }
            if (getState(new Point(i, Board.SIZE - 1 - i)) != stepType) {
                winingAngle2 = false;
            }
        }
        return winningRow || winningCol || winingAngle1 || winingAngle2;
    }

    public final void setState(Point p, CellState state) {
        matrix[p.x][p.y] = state;
    }

    public final CellState getState(Point p) {
        return matrix[p.x][p.y];
    }

    private final CellState[][] matrix = new CellState[SIZE][SIZE];
}
