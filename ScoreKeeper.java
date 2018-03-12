package com.game.mainclasses;

public class ScoreKeeper {
    private String PlayerName1;
    private String PlayerName2;

    private int Score1;
    private int Score2;

    ScoreKeeper(String Name1, String Name2){
        PlayerName1=Name1;
        PlayerName2=Name2;

        Score1=0;
        Score2=0;
    }
    public void addScore1(){
        Score1++;
    }
    public void addScore2(){
        Score2++;
    }
    public int getScore1(){
        return Score1;
    }
    public int getScore2(){
        return Score2;
    }
    public void show(){

    }
}
