package durak_game;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    int compareTo(final Card that) {
        if (this.suit.equals(that.suit)) {
            return this.rank.compareTo(that.rank);
        }
        throw new RuntimeException("Incomparable! The suits don't match.");
    }

    @Override
    public String toString() {
        return suit.name() + rank.toString();// TODO: don't use to string, its for debugging
    }

    public boolean equals (final Card that) {
        return this.suit.equals(that.suit)//TODO:if suit and rank cant be null then check it in constructor othervise here
                && this.rank.equals(that.rank);
    }

}