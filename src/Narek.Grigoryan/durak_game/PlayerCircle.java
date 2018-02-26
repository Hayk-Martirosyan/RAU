package durak_game;

public class PlayerCircle {

    private int size;
    private PlayerNode tail;
    private PlayerNode head;

    public void add (Player attacker) {
        //TODO
    }

    public Player first() {
        if (!isEmpty()) {
            return this.head.attacker;
        }
        throw new NullPointerException();
    }

    public Player last() {
        if (!isEmpty()) {
            return tail.attacker;
        }
        throw new NullPointerException();
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return 0;
    }

    private class PlayerNode {
        Player attacker;
        PlayerNode next;
    }
}
