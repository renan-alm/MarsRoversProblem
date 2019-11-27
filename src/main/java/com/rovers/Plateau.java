package com.rovers;

public class Plateau {
    private int edgeX;// = -1;
    private int edgeY;// = -1;

    public Plateau() {
        this(1,1);
    }

    public Plateau(int edgeX, int edgeY) {
        this.edgeX = edgeX;
        this.edgeY = edgeY;
        System.out.println("Plateau initialized with dimension (" + this.edgeX + "," + this.edgeY + ")");
    }

    public void setEdgeX(int edgeX) {
        this.edgeX = edgeX;
        System.out.println("Plateau edge X set to " + edgeX + ".");
    }
    public void setEdgeY(int edgeY) {
        this.edgeY = edgeY;
        System.out.println("Plateau edge Y set to " + edgeY + ".");
    }
    public int getEdgeX() {
        return edgeX;
    }
    public int getEdgeY() {
        return edgeY;
    }
}
