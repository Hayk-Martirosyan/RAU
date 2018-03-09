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
                //TODO matrix[i][j].getName()
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

    public final void setState(Point p, CellState state) {
        matrix[p.x][p.y] = state;
    }

    public final CellState getState(Point p) {
        return matrix[p.x][p.y];
    }

    private final CellState[][] matrix = new CellState[SIZE][SIZE];
}
