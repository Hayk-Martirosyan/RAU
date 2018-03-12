package durak_game.game_logic;

import durak_game.card.Card;
import durak_game.player.Player;

public class Defense {

    private Player defeder;
    private PlayerCircle attackers;
    private Player expectedPlayer;
    private Player currentAttacker;

    private GameTable gameTable;

    private int passCount;
    private boolean isFinished;

    public Defense(Player defeder, PlayerCircle attackers) {
        this.defeder = defeder;
        this.attackers = attackers;

        gameTable = new GameTable();
        expectedPlayer = attackers.first();
        isFinished = false;
        passCount = 0;
    }

    public boolean beatCard(final Card cardToBeat, final Card card) {
        if (expectedPlayer.equals(defeder)) {
            return gameTable.defendCard(cardToBeat, card);
        }
        return false;
    }

    public boolean attackWith(final Player player, final Card card) {
        if (player.equals(currentAttacker)) {
            return gameTable.attackCard(card);
        }
        return false;
    }

    public void passMove(final Player playerPassing) {
        if (currentAttacker.equals(playerPassing)) {
            ++passCount;
        }

        if (passCount == attackers.size()) {
            isFinished = true;
            return;
        }

        expectedPlayer = currentAttacker = attackers.next();
    }
}