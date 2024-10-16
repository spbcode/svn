package guru.springframework.chess;

public class Player {

    private String name;
    private Color playColor;
    private int nofmoves;
    private int nofkills;

    public Player(String name, Color playColor, int nofmoves, int nofkills) {
        this.name = name;
        this.playColor = playColor;
        this.nofmoves = nofmoves;
        this.nofkills = nofkills;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
