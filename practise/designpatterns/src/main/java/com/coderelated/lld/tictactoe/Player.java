package com.coderelated.lld.tictactoe;

public class Player {

    private String playerName;
    private PieceType pieceType;
    private Piece currentPiece;

    public Player(String playerName, PieceType pieceType) {
        this.playerName = playerName;
        this.pieceType = pieceType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }
}
