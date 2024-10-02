package com.coderelated.lld.tictactoe.strategypattern;

import com.coderelated.lld.tictactoe.Game;

public class ConsoleGameBoardPrinter extends GameBoardPrinter{
    @Override
    public void printBoard(Game game) {

        for (int i = 0; i < game.getGameBoard().getBoardSize(); i++) {
            for (int j = 0; j < game.getGameBoard().getBoardSize(); j++) {
                if (game.getGameBoard().getBoard()[i][j] != null) {
                    System.out.print(game.getGameBoard().getBoard()[i][j].getPieceType().name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }
}
