package com.coderelated.lld.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private int boardSize;

    public TicTacToe(Player player1, Player player2, int boardSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardSize = boardSize;
    }

    public void initGame(){
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        Piece[][] gameGrid = new Piece[boardSize][boardSize];
        GameBoard gameBoard = new GameBoard(gameGrid, boardSize);
        Game game = new Game(players,gameBoard,GameStatus.NOT_STARTED);
        game.startGame();
    }
    public static void main(String args[]){
        TicTacToe ticTacToe = new TicTacToe(new Player("sam",PieceType.X), new Player("prem",PieceType.O),3);
        ticTacToe.initGame();
    }
}
