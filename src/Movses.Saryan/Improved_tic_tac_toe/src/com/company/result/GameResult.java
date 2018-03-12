package com.company.result;

import com.company.Player;

public class GameResult {
    public GameResult(final Player player, final GameState state) {
        this.state = state;
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public GameState getState() {
        return state;
    }

    @Override
    public String toString() {
        if (state == GameState.DRAW){
            return state.toString();
        }else {
            return String.format("player %s %s", this.player.getName(), this.state.toString());
        }
    }

    private final GameState state;
    private final Player player;
}
