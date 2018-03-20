package durak_game.card;

import java.util.HashMap;
import java.util.Map;

public class Rank {

    private static final int RANK_OFFSET = 11;
    private static final int MAX_RANK = 14;
    private static final int MIN_RANK = 6;
    private static final Map<Integer, Rank> CACHE =
            new HashMap<>();

    private final int rankInt;

    private Rank(int rankInt) {
        if (rankInt < MIN_RANK || rankInt > MAX_RANK) {
            throw new IllegalArgumentException("Illegal rank value.");
        } else {
            this.rankInt = rankInt;
        }
    }

    public static Rank makeWithInt(final int value) {
        return Rank.CACHE.computeIfAbsent(
            value, rankInt -> new Rank(rankInt)
        );
    }

    public int getRankInt() {
        return rankInt;
    }

    public static int getMaxRank() {
        return MAX_RANK;
    }

    public static int getMinRank() {
        return MIN_RANK;
    }

    public static int getRankOffset() {
        return RANK_OFFSET;
    }

    public int compareTo(final Rank that) {
        return this.rankInt - that.getRankInt();
    }

    @Override
    public String toString() {
        String result = "";
        if (rankInt < RANK_OFFSET) {
            result = String.valueOf(rankInt);
        } else {
            result = String.valueOf("JQKA".charAt(rankInt - RANK_OFFSET));
        }

        return result;
    }
}
