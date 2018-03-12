
import java.awt.*;


public class Game {
    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public final GameResult play(boolean printBoard) {
        Player p1 = player1;
        Player p2 = player2;
        if (Math.random() < 0.5) {
            p1 = player1;
            p2 = player2;
        } else {
            p1 = player2;
            p2 = player1;
        }

        boolean firstPlayerTurn = true;
        GameResult result = GameResult.NONE;
        p1.prepare();
        p2.prepare();
        Board board = new Board();
        for (int i = 0; i < Board.SIZE * Board.SIZE; ++i) {

            Point p = p1.makeStep();
            if (!isEmpty(board, p)) {
                result = p1 == player1 ? GameResult.FIRST_PLAYER_DISQUOLIFICATION : GameResult.SECOND_PLAYER_DISQUOLIFICATION;
                break;
            }
            board.setState(p, toEnum(firstPlayerTurn));
            if (GameRules.isWinningStep(board, p, toEnum(firstPlayerTurn))) {
                result = p1 == player1 ? GameResult.FIRST_PLAYER : GameResult.SECOND_PLAYER;
                break;
            }
            p2.stepWasMade(p);

            Player temp = p1;
            p1 = p2;
            p2 = temp;
            firstPlayerTurn = !firstPlayerTurn;
        }
        if (printBoard) {
            board.print();
        }
        return result;
    }

    private final boolean isEmpty(Board board, Point step) {
        return board.getState(step) == CellState.EMPTY;
    }

    public static class GameRules {
        public static boolean isWinningStep(Board board, Point step, CellState stepType) {
            boolean winingAngle1 = true;
            boolean winingAngle2 = true;
            boolean winningRow = true;
            boolean winningCol = true;
            for (int i = 0; i < Board.SIZE; ++i) {
                if (board.getState(new Point(step.x, i)) != stepType) {
                    winningRow = false;
                }
                if (board.getState(new Point(i, step.y)) != stepType) {
                    winningCol = false;
                }
                if (board.getState(new Point(i, i)) != stepType) {
                    winingAngle1 = false;
                }
                if (board.getState(new Point(i, Board.SIZE - 1 - i)) != stepType) {
                    winingAngle2 = false;
                }
            }
            return winningRow || winningCol || winingAngle1 || winingAngle2;
        }
    }

    private static CellState toEnum(boolean XTurn) {
        return XTurn ? CellState.X : CellState.O;
    }

    //TODO define fields before methods
    private Player player1;
    private Player player2;
}
