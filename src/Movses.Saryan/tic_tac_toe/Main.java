
public class Main {

    public static void main(String[] args) {
        AlgorithmFactory fact = new AlgorithmFactory();
        //TODO strategy design pattern
        Player p1 = new Player(fact.createPerfectAlgorithm());
        Player p2 = new Player(fact.createHeuristicAlgorithm());
        Game game = new Game(p1, p2);
        GameResult result = game.play(true);
        System.out.println(result);
    }
}
