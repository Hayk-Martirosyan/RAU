package com.game.mainclasses;

public class Player {

    private String PlayerName;
    private int[]  ScoreHistory;
    private int    HighScore;

    Player(String Name){
        PlayerName=Name;
        ScoreHistory=new int[100];
        HighScore=0;
    }
    void expendScoreHistory(int newScore){

    }

    String getPlayerName(){
        return PlayerName;
    }
    int getHighScore(){
        return HighScore;
    }
    int [] getScoreHistory(){
        return ScoreHistory;
    }

}


