
import java.awt.*;


//TODO may be different player implementations instead of alghorithms
public class Player {
    public Player(Algorithm alg) {
        this.algorithm = alg;
    }

    public void prepare() {
        this.algorithm.prepare();
    }

    public void stepWasMade(Point enemyMove) {
        this.algorithm.stepWasMade(enemyMove);
    }

    public Point makeStep() {
        return this.algorithm.makeStep();
    }

    private Algorithm algorithm;
}
