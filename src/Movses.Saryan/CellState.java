
public enum CellState {
    X("x"), O("o"), EMPTY("e");


    private String name;

    private CellState(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
