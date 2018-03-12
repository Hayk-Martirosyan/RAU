package durak_game.game_logic;

import durak_game.player.Player;

public class PlayerCircle {

    private int size;
    private PlayerNode tail;
    private PlayerNode head;

    public void add (final Player attacker) {
        //TODO
    }

    public Player first() {
        if (this.isEmpty()) {
            throw new IllegalStateException("The circle is empty!");
        } else {
            return this.head.player;
        }
    }

    public Player last() {
        if (this.isEmpty()) {
            throw new IllegalStateException("The circle is empty!");
        } else {
            return this.tail.player;
        }
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
