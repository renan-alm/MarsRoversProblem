package com.rover.tests;

import com.rovers.resource.Direction;
import com.rovers.resource.PlateauResourceImpl;
import com.rovers.resource.Rover;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoversTest {

    @Test
    public void testRoverWithPlateauLimits(){
        // Given a Rover deployed on a plateau
        PlateauResourceImpl plateauResourceImpl = new PlateauResourceImpl(8,8);
        // When a Rover is instantiated
        Rover rover = new Rover().withPlateau(plateauResourceImpl);
        // Then the rover limits will be defined according to the plateau
        Assert.assertEquals(8, rover.getEdgeX());
        Assert.assertEquals(8, rover.getEdgeY());
    }
    @Test
    public void testTurnRoverRightFromNorth(){
        //Given a rover deployed assuming NORTH as default
        Rover rover = new Rover();
        //When the rover is moved to the right
        rover.turnRover("R");
        //Then the rover variable will be towards RIGHT
        Assert.assertEquals("EAST", rover.getD().toString() );
        Assert.assertEquals("1, 1", rover.showStatus() );
    }
    @Test
    public void testTurnRoverLeftFromNorth(){
        //Given a rover deployed facing NORTH (default)
        Rover rover = new Rover();
        //When the rover turns right
        rover.turnRover("L");
        //Then the rover variable will be towards RIGHT
        Assert.assertEquals("WEST", rover.getD().toString() );
        Assert.assertEquals("1, 1", rover.showStatus() );
    }
    @Test
    public void testTurnRoverRightFromWest(){
        //Given a rover deployed facing WEST
        Rover rover = new Rover().withDirection(Direction.WEST);
        //When the rover turns right
        rover.turnRover("R");
        //Then the rover should be facing NORTH
        Assert.assertEquals("NORTH", rover.getD().toString() );
        Assert.assertEquals("1, 1", rover.showStatus() );
    }
    @Test
    public void testRoverMovingForward(){
        Rover rover = new Rover(); //Default (1,1,N)
        rover.moveForward();
        Assert.assertEquals("1, 2",rover.showStatus());
    }
    @Test
    public void testRoverDontCrossEdges(){
        PlateauResourceImpl plateauResourceImpl = new PlateauResourceImpl(4,4);
        Rover rover = new Rover().withCoordinates(4,4).withPlateau(plateauResourceImpl); // Default NORTH
        rover.moveForward();
        Assert.assertEquals("4, 4", rover.showStatus());
    }
    @Test
    public void testRoverHasAPlateau(){
        Rover rover = new Rover(); // Given a rover deployed without a plateau
        Assert.assertFalse(rover.isDeployed()); // Returns false
    }
}
