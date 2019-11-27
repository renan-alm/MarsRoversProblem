package com.rover.tests;

import com.rovers.Plateau;
import org.junit.Assert;
import org.junit.Test;

public class MarsRoversTest {

    @Test
    public void  testPlateauDimension(){
        // Given a plateau
        Plateau plateau = new Plateau();
        // When the plateau has the below dimensions
        plateau.setEdgeX(8);
        plateau.setEdgeY(8);
        // Then
        Assert.assertEquals(8, plateau.getEdgeX());
        Assert.assertEquals(8, plateau.getEdgeY());
    }
}
