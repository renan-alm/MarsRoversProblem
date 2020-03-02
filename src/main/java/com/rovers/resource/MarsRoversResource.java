package com.rovers.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("appname")
@Produces(MediaType.APPLICATION_JSON)
public interface MarsRoversResource {

    @GET
    @Path("{plateau}")
    Response setPlateauDimensions(@QueryParam("setY")int setY, @QueryParam("setX") int setX);

    @GET
    @Path("{rover}")
    Response deployRover(@QueryParam("setY")int setY, @QueryParam("setX") int setX);

}
