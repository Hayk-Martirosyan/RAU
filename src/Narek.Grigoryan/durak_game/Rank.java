package durak_game;
//TODO: private constructor with factory method is better
public class Rank {

    private static final int RANK_OFFSET = 11;
    private static final int MAX_RANK = 14;

    private final int rankInt;

    public Rank(int rankInt) {
        if (rankInt > 0 && rankInt <= MAX_RANK) {
            this.rankInt = rankInt;
        } else {//TODO:check first
            throw new IllegalArgumentException("Illegal rank number.");
        }
    }

    public int getRankInt() {
        return rankInt;
    }

    public static int getMaxRank() {
        return MAX_RANK;
    }

    public static int getRankOffset() {
        return RANK_OFFSET;
    }

    public int compareTo(final Rank that) {
        return this.rankInt - that.getRankInt();
    }

    public boolean equals(final Rank that) {
        return this.rankInt == that.getRankInt();//TODO: can use reference equality if factory method used which will reuse objects
    }

    public String toString() {
        if (rankInt < RANK_OFFSET) {
            return String.valueOf(rankInt);
        }//TODO: else
        return String.valueOf("JQKA".charAt(rankInt - RANK_OFFSET));
    }
}
