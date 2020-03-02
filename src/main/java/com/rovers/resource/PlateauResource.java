package com.rovers.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("rovers")
@Produces(MediaType.APPLICATION_JSON)
public interface PlateauResource {

    @GET
    Response setRoverOnPlateau(@QueryParam("setY")Long setY, @QueryParam("setX") Long setX);

}
