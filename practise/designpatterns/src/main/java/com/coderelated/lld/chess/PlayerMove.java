package com.coderelated.lld.chess;

import java.util.Date;

public class PlayerMove {
    private Player player;
    private Key movedKey;
    private int positionX;
    private int positionY;
    private Date keyMoveTime;

    public PlayerMove(Player player, Key movedKey, int positionX, int positionY, Date keyMoveTime) {
        this.player = player;
        this.movedKey = movedKey;
        this.positionX = positionX;
        this.positionY = positionY;
        this.keyMoveTime = keyMoveTime;
    }
}
