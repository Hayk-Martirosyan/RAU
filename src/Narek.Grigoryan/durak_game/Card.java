package durak_game;

public class Card {

    private static final int RANK_OFFSET = 11;

    private String suit;
    private String rank;
    private int rankInt;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        try {
            rankInt = Integer.parseInt(rank);
        } catch (NumberFormatException e) {
            rankInt = "JQKA".indexOf(rank) + RANK_OFFSET;
        }
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getRankInt() {
        return rankInt;
    }

    Integer compareTo(final Card c) {
        if (this.suit.equals(c.suit)) {
            return this.rankInt - c.rankInt;
        }
        return null;
    }

    @Override
    public String toString() {
        return suit + rank;
    }

    boolean equals (final Card c) {
        return this.rank.equals(c.rank) && this.suit.equals(c.suit);
    }

}
