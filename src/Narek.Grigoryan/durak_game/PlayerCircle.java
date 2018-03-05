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
            return this.head.player;
        }
        throw new NullPointerException();//TODO: don't throw NullPointerException, for this case IllegalStateException is better
    }

    public Player last() {
        if (!isEmpty()) {
            return tail.player;
        }
        throw new NullPointerException();
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return 0;
    }

    public Player next() {
        head = head.nextPlayer;
        return head.player;
    }

    private class PlayerNode {
        Player player;
        PlayerNode nextPlayer;
    }
}
