package com.coderelated.lld.tictactoe;

public class GameBoard {
    private Piece[][] board;
    private Piece currentPiece;
    private int boardSize;

    public GameBoard(Piece[][] board,int boardSize) {
        this.board = board;
        this.boardSize=boardSize;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public boolean isCellEmpty(int x, int y){return board[x][y]==null;}
    public boolean hasSamePiece(int x, int y, PieceType pieceType){return board[x][y]!=null && board[x][y].getPieceType()==pieceType;}
    public boolean addPiece(int inputRow,int inputColumn,Piece currentPiece){
        if(board[inputRow][inputColumn]!=null){
            return false;
        }
        board[inputRow][inputColumn] = currentPiece;
        return true;
    }
}
