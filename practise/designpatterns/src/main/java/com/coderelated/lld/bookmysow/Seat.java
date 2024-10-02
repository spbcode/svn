package com.coderelated.lld.bookmysow;

public class Seat {
    public enum SeatType{
        RECLINER("recliner"),
        REGULAR("regular");
        private String name;

        SeatType(String name) {
            this.name = name;
        }
    }

    private int number;
    private int rowNumber;
    private MallMovieScreen screen;
}
