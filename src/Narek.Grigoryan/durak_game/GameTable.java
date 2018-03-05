package durak_game;

import java.util.ArrayList;
import java.util.List;

public class GameTable {
    //TODO:great! its good practise to not use exact implementation names in variable definitions
    private List<Card> openCards;
    private List<Card> allCards;

    public GameTable() {
        openCards = new ArrayList<>();
        allCards = new ArrayList<>();
    }

    public boolean rankExists(final Rank rank) {
        return allCards.stream()
                .anyMatch(card -> card.getRank().equals(rank));
    }

    public boolean defendCard(final Card attackCard,
                                final Card defenseCard) {
        if (openCards.contains(defenseCard)) {
            try {
                if (defenseCard.compareTo(attackCard) > 0) {
                    openCards.remove(attackCard);
                    allCards.add(defenseCard);
                    return true;
                }
                return false;
            } catch (RuntimeException e) {
                return false;
            }
        }

        return false;
    }

    public boolean attackCard(Card attackCard) {
        if (rankExists(attackCard.getRank())) {
            allCards.add(attackCard);
            openCards.add(attackCard);
            return true;
        }
        return false;
    }

}
