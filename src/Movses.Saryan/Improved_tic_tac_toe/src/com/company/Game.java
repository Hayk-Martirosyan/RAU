package com.company;

import java.awt.*;

import com.company.result.GameResult;
import com.company.result.GameState;

public class Game {
    public Game(final Player player1, final Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public final GameResult play(final boolean printBoard) {
        boolean firstPlayerTurn = (Math.random() < 0.5);
        player1.prepare();
        player2.prepare();
        final Board board = new Board();
        for (int i = 0; i < Board.SIZE * Board.SIZE; ++i) {
            GameState state;
            if (firstPlayerTurn) {
                state = makeStep(player1, player2, board, CellState.X);
            } else {
                state = makeStep(player2, player1, board, CellState.O);
            }
            if (state != GameState.NONE) {
                final Player currentPlayer = firstPlayerTurn ? this.player1 : this.player2;
                return new GameResult(currentPlayer, state);
            } else {
                firstPlayerTurn = !firstPlayerTurn;
            }
        }
        if (printBoard) {
            board.print();
        }
        return new GameResult(null, GameState.DRAW);
    }

    private final GameState makeStep(final Player p1, final Player p2, final Board board, final CellState turn) {
        final Point p = p1.makeStep();
        if (!isEmpty(board, p)) {
            return GameState.DISQUOLIFICATION;
        } else {
            board.setState(p, turn);
            if (board.isWinningStep(p, turn)) {
                return GameState.WIN;
            } else {
                p2.stepWasMade(p);
                return GameState.NONE;
            }
        }
    }

    private final boolean isEmpty(final Board board, final Point step) {
        return board.getState(step) == CellState.EMPTY;
    }

    private final Player player1;
    private final Player player2;
}
