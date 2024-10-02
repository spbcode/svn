package com.coderelated.lld.chess;

import java.util.Set;

public class Key {
    public enum KeyType{
        KING("king",1),
        QUEEN("queen",2),
        BISHOP("bishop",3),
        HORSE("horse",4),
        ELEPHANT("elephant",5),
        SOLDIER("soldier",6);
        private String keyName;
        private int id;

        KeyType(String keyName, int id) {
            this.keyName = keyName;
            this.id = id;
        }
    }

    public enum KeyColor{
        BLACK("black",1),
        WHITE("white",2);
        private String color;
        private int id;

        KeyColor(String color, int id) {
            this.color = color;
            this.id = id;
        }
    }

    public enum Status{
        ALIVE("alive", 1),
        KILLED("killed",2),
        CHECKMATE("checkmate",3),;

        private String status;
        private int id;

        Status(String status, int id) {
            this.status = status;
            this.id = id;
        }
    }

    private KeyType keyType;
    private KeyColor keyColor;
    private int positionX;
    private int positionY;
    private Status status;
    private Set<Key> kills;
}
