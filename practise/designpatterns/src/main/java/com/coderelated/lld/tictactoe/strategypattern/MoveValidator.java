package com.coderelated.lld.tictactoe.strategypattern;

import com.coderelated.lld.tictactoe.GameBoard;
import com.coderelated.lld.tictactoe.Piece;

public interface MoveValidator {
    public boolean isValidMove(GameBoard gameBoard, Piece piece);
}
