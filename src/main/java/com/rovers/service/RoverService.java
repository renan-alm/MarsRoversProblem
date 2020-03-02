package com.rovers.service;

import javax.ws.rs.core.Response;
import com.rovers.util.Coordinates;
import com.rovers.util.PlateauUtil;
import com.rovers.util.RoverUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoverService implements RestServiceInterface<Coordinates> {


    private static final Logger cLogger = LogManager.getLogger(RoverService.class);
    public static RoverUtil rover = null;

    @Override
    public Response execute(Coordinates roverCoordinates) {
        Response response = null;
        try {
            if (roverCoordinates.getY() <= PlateauUtil.createOrRetrievePlateau().getY()
                    && roverCoordinates.getX() <= PlateauUtil.createOrRetrievePlateau().getX()) {
                rover = new RoverUtil(roverCoordinates.getY(), roverCoordinates.getX());
                cLogger.info("Rover deployed on ({},{}).", roverCoordinates.getY(), roverCoordinates.getX());
            }
            else{
                cLogger.error("Rover exceeds plateau dimensions! Try again.");
            }
        }catch (Exception e){    //FIXME
            System.out.println(e);
        }
        response = Response.status(Response.Status.OK).build();
        return response;
    }
}
