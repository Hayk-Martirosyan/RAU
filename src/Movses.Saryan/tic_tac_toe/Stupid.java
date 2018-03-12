

//TODO use your own point
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
        throw new RuntimeException("there is no step to make");//TOD IllegalStateException
    }

    private Board board = new Board();
}
