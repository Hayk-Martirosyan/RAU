package durak_game.card;

import durak_game.card.Card;
import durak_game.card.Rank;
import durak_game.card.Suit;

import java.util.Collections;
import java.util.Stack;

public class CardDeck {

    private Stack<Card> cardStack;
    private Card trumpCard;
    private int deckSize;

    public CardDeck() {
        cardStack = new Stack<>();

        for (Suit suit : Suit.values()) {
            for (int rankInt = Rank.getMinRank(); rankInt <= Rank.getMaxRank(); ++rankInt) {
                cardStack.push(new Card(suit, Rank.makeWithInt(rankInt)));
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

    public Card topCard() {
        return cardStack.pop();
    }
}
