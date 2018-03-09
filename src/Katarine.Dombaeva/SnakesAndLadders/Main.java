package SnakesAndLadders;

public class Main {
    public static void main(String args[]) {
        Desk desk = new Desk();
        Dice dice = new Dice();
        Player p1 = new Player("Katya");
        Player p2 = new Player("Armen");
        Player p3 = new Player("newPlayer");

        while (!desk.getCrossedFinishLine()) {
            //TODO start
            dice.rollTheDice();
            System.out.print("p1 --> ");System.out.println(dice.getDiceFace());//TODO one statement per line
            p1.step(dice.getDiceFace(), desk);
            desk.drawDesk();
            //TODO end code duplication bellow
            if (!desk.getCrossedFinishLine()) {
                dice.rollTheDice();
                System.out.print("p2 --> ");System.out.println(dice.getDiceFace());
                p2.step(dice.getDiceFace(), desk);
                desk.drawDesk();
//                if (!desk.getCrossedFinishLine()) {
//                    dice.rollTheDice();
//                    System.out.print("p3 --> ");System.out.println(dice.getDiceFace());
//                    p3.step(dice.getDiceFace(), desk);
//                    desk.drawDesk();
//                }
            }
        }
    }

}

