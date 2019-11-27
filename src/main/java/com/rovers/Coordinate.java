package com.rovers;

public class Coordinate {
    private int x;
    private int y;

    public String setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
        return "(" + this.x + ", " + this.y + ")";
    }

    public Coordinate() { // Default values for a coordinate
        this.x = 0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}