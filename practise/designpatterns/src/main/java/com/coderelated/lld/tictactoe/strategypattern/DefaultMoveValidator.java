package com.coderelated.lld.tictactoe.strategypattern;

import com.coderelated.lld.tictactoe.GameBoard;
import com.coderelated.lld.tictactoe.Piece;
import com.coderelated.lld.tictactoe.PieceType;

public class DefaultMoveValidator implements MoveValidator{

    @Override
    public boolean isValidMove(GameBoard gameBoard, Piece piece) {
        return piece.getX()>=0 && piece.getX()<gameBoard.getBoardSize() && piece.getY()>=0 && piece.getY()<gameBoard.getBoardSize()
                && gameBoard.isCellEmpty(piece.getX(),piece.getY()) && !gameBoard.hasSamePiece(piece.getX(),piece.getY(),piece.getPieceType());
    }
}
