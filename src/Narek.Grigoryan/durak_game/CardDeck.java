package durak_game;

import java.util.*;

public class CardDeck {

    private Stack<Card> cardStack;
    private Card trumpCard;
    private int deckSize;

    public CardDeck() {
        cardStack = new Stack<>();

        for (Suit suit : Suit.values()) {
            for (int rankInt = 1; rankInt <= Rank.getMaxRank(); ++rankInt) {
                cardStack.push(new Card(suit, new Rank(rankInt)));//TODO: can use factory method
            }
        }

        Collections.shuffle(cardStack);

        trumpCard = cardStack.peek();
        deckSize = cardStack.size();
    }

    public Card getTrumpCard() {
        return trumpCard;
    }

    public int getDeckSize() {
        return deckSize;
    }

    Card topCard() {
        return cardStack.pop();
    }
}
