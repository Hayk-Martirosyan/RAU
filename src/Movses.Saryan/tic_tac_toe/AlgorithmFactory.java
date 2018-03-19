


public class AlgorithmFactory {
    public Algorithm createPerfectAlgorithm() {
        return new Megamax();
    }

    public Algorithm createHeuristicAlgorithm() {
        return new Stupid();
    }
}
