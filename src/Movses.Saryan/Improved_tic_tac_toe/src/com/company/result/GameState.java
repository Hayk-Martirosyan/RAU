package com.company.result;

public enum GameState {
    WIN,
    LOSE,
    DISQUOLIFICATION,
    DRAW,
    NONE;

    @Override
    public String toString() {
        String rv;
        switch (this){
            case DRAW:
                rv = "draw";
                break;
            case WIN:
                rv = "win";
                break;
            case LOSE:
                rv = "lose";
                break;
            case DISQUOLIFICATION:
                rv = "disquolification";
                break;
            case NONE:
                rv = "game is running";
                break;
            default:
                throw new IllegalArgumentException();
        }
        return rv;
    }
}
