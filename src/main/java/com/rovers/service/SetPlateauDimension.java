package com.rovers.service;

import com.rovers.resource.Coordinates;
import javax.ws.rs.core.Response;

public class SetPlateauDimension implements IRestService<Coordinates> {  // Service to manage coordinates

    @Override
    public Response execute(Coordinates coordinates) {
        Response response = null;

        //FIXME
        Boolean plateauSet = PlateauUtil.setPlateauDimensions(coordinates.getY(), coordinates.getX());

        return null;
    }
}
