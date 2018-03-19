package com.company;

import com.company.algo.Algorithm;

import java.awt.*;

public class Player {
    public Player(Algorithm alg, String name) {
        this.algorithm = alg;
        this.name = name;
    }

    public void prepare() {
        this.algorithm.prepare();
    }

    public void stepWasMade(Point enemyMove) {
        this.algorithm.stepWasMade(enemyMove);
    }

    public Point makeStep() {
        return this.algorithm.makeStep();
    }

    public String getName() {
        return name;
    }

    private Algorithm algorithm;
    private String name;
}
