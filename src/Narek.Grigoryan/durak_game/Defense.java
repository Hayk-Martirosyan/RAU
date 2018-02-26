package durak_game;

import java.util.ArrayList;
import java.util.List;

public class Defense {

    private Player defender;
    private PlayerCircle attackers;
    private Player expectedPlayer;
    private Player currentAttacker;
    private List<Card> tableCards;
    private String trumpSuit;
    private int passCount;
    private boolean isFinished;

    public Defense(Player defender, PlayerCircle attackers, String trumpSuit) {
        this.defender = defender;
        this.attackers = attackers;
        this.trumpSuit = trumpSuit;

        tableCards = new ArrayList<>();
        expectedPlayer = attackers.first();
        passCount = 0;
        isFinished = false;
    }

    public boolean acceptCard(Player player, Card card) {
        if (player.equals(expectedPlayer)) {
            return false;
        }

        boolean valid;

        if (!player.equals(defender)) {
            currentAttacker = player;
            valid = attack(card);
        } else {
            valid = defend(card);
        }

        if (valid) {
            player.give(card);
        }

        return valid;
    }

    private boolean defend(Card card) {
        if (card.compareTo(tableCards.get(tableCards.size() - 1)) > 0 ||
                (card.getSuit().equals(trumpSuit) &&
                !tableCards.get(tableCards.size() - 1).getSuit().equals(trumpSuit))) {
            tableCards.add(card);
            expectedPlayer = currentAttacker;

            return true;
        }

        if (defender.handCards.size() == 0 || tableCards.size() >= 12) {
            isFinished = true;
            return true;
        }

        return false;
    }

    private boolean attack(Card card) {
        if (tableCards.size() == 0 || rankExists(card.getRank())) {
            tableCards.add(card);
            expectedPlayer = defender;

            passCount = 0;

            return true;
        }

        return false;
    }

    private boolean rankExists(String rank) {
        return tableCards.stream()
                .anyMatch(card -> rank.equals(card.getRank()));
    }

    public void passMoveTo(Player player) {
        //TODO
    }

    public void giveCardsTo(Player player) {
        if (passCount == attackers.size()) {
            player.take(tableCards);
            tableCards.clear();
            player.setPickedUp(true);
            isFinished = true;
        }

        expectedPlayer = currentAttacker;

        //TODO
    }
}
