package durak_game.card;

import java.util.Objects;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        if (suit == null) {
            throw new IllegalArgumentException("Suit cannot be null!");
        }
        if (rank == null) {
            throw new IllegalArgumentException("Rank cannot be null!");
        }
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int compareTo(final Card that) {
        if (this.suit.equals(that.suit)) {
            return this.rank.compareTo(that.rank);
        }
        throw new RuntimeException("Incomparable! The suits don't match.");
    }

    @Override
    public String toString() {
        return suit.name() + rank.toString();
    }

    public boolean equals (final Card that) {
        return this.suit.equals(that.suit)
                && this.rank.equals(that.rank);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass().equals(o.getClass())) {
            Card that = (Card) o;
            return this.suit.equals(that.suit)
                    && this.rank.equals(that.rank);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.suit, this.rank);
    }
}