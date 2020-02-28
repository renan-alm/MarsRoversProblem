package com.rovers.resource;

import com.rovers.service.IRestService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;

public class PlateauResourceImpl implements PlateauResource {
    private int edgeX;// = -1;
    private int edgeY;// = -1;

    private static final Logger cLogger = LoggerFactory.getLogger(PlateauResourceImpl.class);
    private IRestService service;

    public PlateauResourceImpl() {
        this(1,1);
    }

    public PlateauResourceImpl(int edgeX, int edgeY) {
        this.edgeX = edgeX;
        this.edgeY = edgeY;
        String str = "Plateau initialized with dimension (" + this.edgeX + "," + this.edgeY + ")";
        cLogger.info(str);
        //System.out.println("Plateau initialized with dimension (" + this.edgeX + "," + this.edgeY + ")");
    }

    @Override
    public Response setRoverOnPlateau(Long setY, Long setX) {
        // service = RestServiceFactory // FIXME
        return null;
    }

    public void setEdgeX(int edgeX) {
        this.edgeX = edgeX;
        System.out.println("Plateau edge X set to " + edgeX + ".");
    }
    public void setEdgeY(int edgeY) {
        this.edgeY = edgeY;
        System.out.println("Plateau edge Y set to " + edgeY + ".");
    }
    public int getEdgeX() {
        return edgeX;
    }

    public int getEdgeY() {
        return edgeY;
    }
}
