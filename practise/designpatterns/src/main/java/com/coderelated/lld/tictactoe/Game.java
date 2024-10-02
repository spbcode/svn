package com.coderelated.lld.tictactoe;

import com.coderelated.lld.tictactoe.strategypattern.ConsoleGameBoardPrinter;
import com.coderelated.lld.tictactoe.strategypattern.DefaultMoveValidator;
import com.coderelated.lld.tictactoe.strategypattern.GameBoardPrinter;
import com.coderelated.lld.tictactoe.strategypattern.MoveValidator;

import java.util.*;

public class Game {
    private List<Player> players;
    private GameBoard gameBoard;
    private GameStatus gameStatus;
    private MoveValidator moveValidator;
    GameBoardPrinter gameBoardPrinter = new ConsoleGameBoardPrinter();


    Deque<Player> playerTurnQueue = null;

    public Game(List<Player> players, GameBoard gameBoard, GameStatus gameStatus) {
        this.players = players;
        this.gameBoard = gameBoard;
        this.gameStatus = gameStatus;
        moveValidator = new DefaultMoveValidator();
    }

    public void startGame(){
        playerTurnQueue= new LinkedList<>(players);
        System.out.println("player count:"+playerTurnQueue.size());
        gameStatus = GameStatus.ONGOING;
        while(gameStatus.getStatus().equals(GameStatus.ONGOING.getStatus())){
            Player currPlayer = playerTurnQueue.poll();

            System.out.print("Player:" + currPlayer.getPlayerName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);
            Piece currPiece = new Piece(currPlayer.getPieceType(),inputRow,inputColumn);
            if(!gameBoard.addPiece(inputRow,inputColumn,currPiece)){
                System.out.println("Incorrect position, try again");
                playerTurnQueue.addFirst(currPlayer);
                continue;
            }
            gameBoardPrinter.printBoard(this);
            playerTurnQueue.addLast(currPlayer);
            boolean winner = isThereWinner(inputRow,inputColumn,currPiece.getPieceType());
            if(winner){
                System.out.println("Player:" + currPlayer.getPlayerName() +" has won the game");
                gameStatus = GameStatus.WON;
                return;
            }

        }
        gameStatus = GameStatus.DRAW;
        System.out.println("Game Tie");
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.getBoardSize();i++) {

            if(gameBoard.getBoard()[row][i] == null || gameBoard.getBoard()[row][i].getPieceType()!=pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.getBoardSize();i++) {

            if(gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column].getPieceType()!=pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.getBoardSize();i++,j++) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType()!=pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.getBoardSize()-1; i<gameBoard.getBoardSize();i++,j--) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType()!=pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public MoveValidator getMoveValidator() {
        return moveValidator;
    }

    public Deque<Player> getPlayerTurnQueue() {
        return playerTurnQueue;
    }
}
