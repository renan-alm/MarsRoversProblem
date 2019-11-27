package com.rover.tests;

import com.rovers.Direction;
import com.rovers.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoversTest {

    @Test
    public void testPlateauDimension(){
        // Given a plateau
        Plateau plateau = new Plateau();
        // When the plateau has the below dimensions
        plateau.setEdgeX(8);
        plateau.setEdgeY(8);
        // Then
        Assert.assertEquals(8, plateau.getEdgeX());
        Assert.assertEquals(8, plateau.getEdgeY());
    }

    @Test
    public void testDirectionEnum(){
        Direction d = Direction.WEST;

        //System.out.println(d.next().toString());
        //

/*
        Assert.assertEquals(Direction.NORTH, d.next());
        d = Direction.NORTH;
        Assert.assertEquals(Direction.WEST, d.previous());
*/


        //Assert.assertEquals("NORTH", Direction.values()[0].toString());
        //Assert.assertEquals("NORTH", Direction.values()[0].toString());
    }
}
