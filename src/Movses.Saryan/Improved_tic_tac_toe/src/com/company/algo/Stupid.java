package com.company.algo;

import com.company.Board;
import com.company.CellState;
import com.company.algo.Algorithm;

import java.awt.*;

public class Stupid implements Algorithm {
    @Override
    public void stepWasMade(Point step) {
        board.setState(step, CellState.X);
    }

    @Override
    public void prepare() {
    }

    @Override
    public Point makeStep() {
        for (int i = 0; i < Board.SIZE; ++i) {
            for (int j = 0; j < Board.SIZE; ++j) {
                Point p = new Point(i, j);
                if (board.getState(p) == CellState.EMPTY) {
                    board.setState(p, CellState.X);
                    return p;
                }
            }
        }
        throw new RuntimeException("there is no step to make");
    }

    private Board board = new Board();
}
