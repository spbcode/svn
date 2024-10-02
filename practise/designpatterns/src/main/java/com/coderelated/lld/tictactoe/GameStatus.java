package com.coderelated.lld.tictactoe;

public enum GameStatus {
    ONGOING("ongoing"), WON("won"), DRAW("draw"), NOT_STARTED("not started"), CANCEL("Cancel");

    GameStatus(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }
}
