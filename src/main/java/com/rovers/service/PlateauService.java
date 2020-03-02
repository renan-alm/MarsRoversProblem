package com.rovers.service;

import com.rovers.util.Coordinates;
import com.rovers.util.PlateauUtil;

import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlateauService implements RestServiceInterface<Coordinates> {

    private Coordinates plateauDimensions;
    private static final Logger cLogger = LogManager.getLogger(PlateauService.class);

    @Override
    public Response execute(Coordinates coordinates) {
        Response response = null;

        try{
          plateauDimensions = PlateauUtil.createOrRetrievePlateau();
          cLogger.info("Plateau set with dimensions {}, {}. ", plateauDimensions.getY() , plateauDimensions.getX());
          response = Response.status(Response.Status.OK).build();

        } catch (Exception e){  //FIXME
            System.out.println(e);
        }

        return response;
    }
}
