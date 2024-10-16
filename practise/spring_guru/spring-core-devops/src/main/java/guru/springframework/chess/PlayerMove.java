package guru.springframework.chess;

public class PlayerMove {
    private Player player;
    private Cell startCell;
    private Cell endCell;
    private Piece piece;

    public void move(Cell newCell){
        endCell = newCell;
        startCell = this.piece.getCurrentCell();
        if(piece.canMove(startCell,endCell)){
            piece.setCurrentCell(endCell);
        }
    }
}
