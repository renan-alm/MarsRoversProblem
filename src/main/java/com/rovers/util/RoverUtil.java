package com.rovers.util;

public class RoverUtil {

    public static RoverUtil rover = null;
    private Coordinates roverCoordinates;

    public RoverUtil(int y, int x) {
        this.roverCoordinates = new Coordinates(y, x);
    }

/*    public static RoverUtil getRover(int y, int x){
        if (rover == null){
            return new RoverUtil(y, x);
        } else {
            return rover;
        }
    }*/
}
