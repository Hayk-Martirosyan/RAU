package durak_game;

import java.util.*;

public class CardDeck {

    static final String[] SUITS = {"H", "S", "C", "D"};
    static final String[] RANKS = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private Queue<Card> cardQueue;
    private Card trumpCard;
    private int size;

    public CardDeck() {
        List<Card> cardList = new ArrayList<>();
        cardQueue = new LinkedList<>();

        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cardList.add(new Card(suit, rank));
            }
        }

        Collections.shuffle(cardList);

        cardQueue.addAll(cardList);

        trumpCard = cardQueue.peek();
        size = cardQueue.size();
    }

    public Card getTrumpCard() {
        return trumpCard;
    }

    public int getSize() {
        return size;
    }

    Card pop() {
        if (size != 0) {
            --size;
            return cardQueue.poll();
        }

        throw new NullPointerException("The deck is empty!");
    }
}
