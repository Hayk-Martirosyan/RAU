package com.company;

import com.company.algo.AlgorithmFactory;
import com.company.result.GameResult;

public class Main {

    public static void main(String[] args) {
        AlgorithmFactory fact = new AlgorithmFactory();
        Player p1 = new Player(fact.createPerfectAlgorithm(), "John");
        Player p2 = new Player(fact.createHeuristicAlgorithm(), "Elise");
        Game game = new Game(p1, p2);
        GameResult result = game.play(true);
        System.out.println(result.toString());
    }
}
