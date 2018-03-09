package SnakesAndLadders;

import java.util.ArrayList;

public class Desk {
    private ArrayList<ArrayList<String>> desk;
    private ArrayList<Ladders> ladders;
    private ArrayList<Snakes> snakes;
    private final DeskPoint START = new DeskPoint(0, 0);
    private final DeskPoint FINISH = new DeskPoint(9, 9);
    private boolean crossedFinishLine;

    public static int step = 0;//TODO public fields

    Desk() {
        this.crossedFinishLine = false;

        desk = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 10; ++i) {
            desk.add(new ArrayList<String>());
            for (int j = 0; j < 10; ++j) {
                desk.get(i).add(" ");
            }
        }

        ladders = new ArrayList<>();
        ladders.add(new Ladders(new DeskPoint(0, 2), new DeskPoint(2, 0)));
        ladders.add(new Ladders(new DeskPoint(0, 7), new DeskPoint(2, 9)));
        ladders.add(new Ladders(new DeskPoint(2, 7), new DeskPoint(8, 3)));
        ladders.add(new Ladders(new DeskPoint(5, 2), new DeskPoint(7, 3)));
        ladders.add(new Ladders(new DeskPoint(7, 0), new DeskPoint(9, 0)));
        ladders.add(new Ladders(new DeskPoint(7, 5), new DeskPoint(8, 5)));
        ladders.add(new Ladders(new DeskPoint(8, 9), new DeskPoint(9, 9)));

        snakes = new ArrayList<>();
        snakes.add(new Snakes(new DeskPoint(1, 3), new DeskPoint(1, 7)));
        snakes.add(new Snakes(new DeskPoint(5, 8), new DeskPoint(2, 8)));
        snakes.add(new Snakes(new DeskPoint(5, 4), new DeskPoint(3, 0)));
        snakes.add(new Snakes(new DeskPoint(6, 1), new DeskPoint(2, 1)));
        snakes.add(new Snakes(new DeskPoint(8, 7), new DeskPoint(1, 2)));
        snakes.add(new Snakes(new DeskPoint(9, 5), new DeskPoint(6, 9)));
        snakes.add(new Snakes(new DeskPoint(9, 3), new DeskPoint(7, 1)));
    }

    public void checkForLaddersAndSnakes(DeskPoint point, String nick) {
        ++step;
        if (point.equals(this.FINISH) || point.getX() > this.FINISH.getX()) {
            desk.get(this.FINISH.getX()).set(this.FINISH.getY(), nick);
            this.crossedFinishLine = true;
            System.out.println(nick + " WON!!!!!");
            return;
        }

        for (Ladders ladder : ladders) {
            if (ladder.getBottom().equals(point)) {
                point.setX(ladder.getTop().getX());
                point.setY(ladder.getTop().getY());
                if (point.equals(this.FINISH)) {
                    desk.get(this.FINISH.getX()).set(this.FINISH.getY(), nick);
                    this.crossedFinishLine = true;
                    System.out.println(nick + " WON!!!!!");
                    return;
                } else {
                    this.drawStep(point, nick);
                }
                return;
            }
        }
        for (Snakes snake : snakes) {
            if (snake.getHead().equals(point)) {
                point.setX(snake.getTail().getX());
                point.setY(snake.getTail().getY());
                this.drawStep(point, nick);
                return;
            }
        }
        this.drawStep(point, nick);
        return;
    }

    private void drawStep(DeskPoint point, String nick) {
        String pointName = desk.get(point.getX()).get(point.getY());
        if (pointName.equals(" ")) {
            desk.get(point.getX()).set(point.getY(), nick + step);
        } else {
            String newName = pointName + " " + nick + step;
            desk.get(point.getX()).set(point.getY(), newName);
        }
    }

    public void drawDesk() {
        for (int i = 0; i < 10; ++i) {//TODO; magic numbers
            System.out.println(desk.get(i).toString());
        }
    }

    public boolean getCrossedFinishLine() {
        return this.crossedFinishLine;
    }
}
