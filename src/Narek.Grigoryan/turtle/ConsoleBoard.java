package turtle;

public class ConsoleBoard implements Board {

    private static ConsoleBoard instance;

    private ConsoleBoard() {}

    public static ConsoleBoard getInstance() {
        if (instance == null) {
            instance = new ConsoleBoard();
        }
        return instance;
    }

    @Override
    public void draw(int x, int y) {

    }
}
