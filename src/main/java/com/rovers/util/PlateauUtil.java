package com.rovers.util;

public class PlateauUtil {
    private static ThreadLocal<Coordinates> plateauDimensions = new ThreadLocal<>();

    private PlateauUtil(Coordinates coordinates) {
        plateauDimensions.set(coordinates);
    }

    public static Coordinates createOrRetrievePlateau(){
        if (plateauDimensions.get() == null){
            plateauDimensions.set(new Coordinates(5,5));
        }
        return plateauDimensions.get();
    }
}
