package guru.springframework.chess;

public abstract class Piece {
    private PieceState pieceState= PieceState.ALIVE;

    private String name;
    private Cell currentCell;
    private Color color;

    public abstract boolean canMove(Cell startCell, Cell endCell);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }
}
