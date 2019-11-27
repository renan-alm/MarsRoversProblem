package com.rovers;

class Plateau {
    private int edgeX;// = -1;
    private int edgeY;// = -1;

    Plateau(int edgeX, int edgeY) {
        this.edgeX = edgeX;
        this.edgeY = edgeY;
        System.out.println("Plateau defined with dimension (" + this.edgeX + "," + this.edgeY + ")");
    }

    public void setEdgeX(int edgeX) {
        this.edgeX = edgeX;
    }
    public void setEdgeY(int edgeY) {
        this.edgeY = edgeY;
    }
    public int getEdgeX() {
        return edgeX;
    }
    public int getEdgeY() {
        return edgeY;
    }
}
