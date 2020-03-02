package com.rovers.util;

public class Coordinates {
    private int y;
    private int x;

    public Coordinates(int y, int x) { // Default values for a coordinate
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}