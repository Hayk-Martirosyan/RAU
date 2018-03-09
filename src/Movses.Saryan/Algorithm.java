import java.awt.*;

public interface Algorithm {
    void stepWasMade(Point step);

    void prepare();

    Point makeStep();
}
