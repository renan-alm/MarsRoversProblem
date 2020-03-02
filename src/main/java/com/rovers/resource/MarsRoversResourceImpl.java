package com.rovers.resource;

import javax.ws.rs.core.Response;

import com.rovers.service.RestServiceInterface;
import com.rovers.service.RestServiceFactory;
import com.rovers.util.Coordinates;

public class MarsRoversResourceImpl implements MarsRoversResource {

    private RestServiceInterface service;

    @Override
    public Response setPlateauDimensions(int setY, int setX) {
        Coordinates coordinates = new Coordinates(setY, setX);
        service = RestServiceFactory.getRestService(RestServiceFactory.ServiceType.SET_PLATEAU_COORDINATES_Service);

        return service.execute(coordinates);
    }

    @Override
    public Response deployRover(int setY, int setX) {
        Coordinates coordinates = new Coordinates(setY, setX);
        service = RestServiceFactory.getRestService(RestServiceFactory.ServiceType.SET_ROVER_Service);

        return service.execute(coordinates);
    }

}


