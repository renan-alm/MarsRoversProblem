package com.rovers.util;

import com.rovers.resource.MarsRoversResourceImpl;

import java.util.ArrayList;

public interface RoverInterface {
    Direction d = null;
    final ArrayList<String> history = new ArrayList<>();

    public Direction getDirection();
    public RoverInterface withCoordinates(int x, int y);
    public RoverInterface withDirection(Direction d);
    public RoverInterface withPlateau(MarsRoversResourceImpl marsRoversResourceImpl);
    public String showStatus();
    void start();
    void displayHistory();
    public void turnRover(String leftRight);
    public void moveForward();
    public boolean isDeployed();

}
