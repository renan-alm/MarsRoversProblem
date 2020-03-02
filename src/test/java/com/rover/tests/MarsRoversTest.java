package com.rover.tests;

import com.rovers.util.Direction;
import com.rovers.resource.MarsRoversResourceImpl;
import com.rovers.util.RoverInterface;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoversTest {

    @Test
    public void testRoverWithPlateauLimits(){
        // Given a Rover deployed on a plateau
        MarsRoversResourceImpl marsRoversResourceImpl = new MarsRoversResourceImpl(8,8);
        // When a Rover is instantiated
        RoverInterface rover = new RoverInterface().withPlateau(marsRoversResourceImpl);
        // Then the rover limits will be defined according to the plateau
        Assert.assertEquals(8, rover.getEdgeX());
        Assert.assertEquals(8, rover.getEdgeY());
    }
    @Test
    public void testTurnRoverRightFromNorth(){
        //Given a rover deployed assuming NORTH as default
        RoverInterface rover = new RoverInterface();
        //When the rover is moved to the right
        rover.turnRover("R");
        //Then the rover variable will be towards RIGHT
        Assert.assertEquals("EAST", rover.getD().toString() );
        Assert.assertEquals("1, 1", rover.showStatus() );
    }
    @Test
    public void testTurnRoverLeftFromNorth(){
        //Given a rover deployed facing NORTH (default)
        RoverInterface rover = new RoverInterface();
        //When the rover turns right
        rover.turnRover("L");
        //Then the rover variable will be towards RIGHT
        Assert.assertEquals("WEST", rover.getD().toString() );
        Assert.assertEquals("1, 1", rover.showStatus() );
    }
    @Test
    public void testTurnRoverRightFromWest(){
        //Given a rover deployed facing WEST
        RoverInterface rover = new RoverInterface().withDirection(Direction.WEST);
        //When the rover turns right
        rover.turnRover("R");
        //Then the rover should be facing NORTH
        Assert.assertEquals("NORTH", rover.getD().toString() );
        Assert.assertEquals("1, 1", rover.showStatus() );
    }
    @Test
    public void testRoverMovingForward(){
        RoverInterface rover = new RoverInterface(); //Default (1,1,N)
        rover.moveForward();
        Assert.assertEquals("1, 2",rover.showStatus());
    }
    @Test
    public void testRoverDontCrossEdges(){
        MarsRoversResourceImpl marsRoversResourceImpl = new MarsRoversResourceImpl(4,4);
        RoverInterface rover = new RoverInterface().withCoordinates(4,4).withPlateau(marsRoversResourceImpl); // Default NORTH
        rover.moveForward();
        Assert.assertEquals("4, 4", rover.showStatus());
    }
    @Test
    public void testRoverHasAPlateau(){
        RoverInterface rover = new RoverInterface(); // Given a rover deployed without a plateau
        Assert.assertFalse(rover.isDeployed()); // Returns false
    }
}
