package com.rovers.resource;

public class Coordinates {
    private int x;
    private int y;

    public String setCoordinates(int x, int y){
        this.x = x;
        this.y = y;
        return "(" + this.x + ", " + this.y + ")";
    }

    public Coordinates() { // Default values for a coordinate
        this.x = 0;
        this.y = 0;
    }

    public Coordinates(int x, int y) { // Default values for a coordinate
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}