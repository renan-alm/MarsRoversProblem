package com.rovers.service;

public class RestServiceFactory {
    /*
     *  This class responds with a rest service that depending of the service will execute
     *  a specific service (method) within the code.
     * */
    public static RestServiceInterface getRestService(final ServiceType service) { // Where ServiceType is a enum class
        switch (service) {
            case SET_PLATEAU_COORDINATES_Service:
                return new PlateauService();
            case SET_ROVER_Service:
                return new RoverService();
            case MOVE_Service:
                return null; //new MoveRoverForward();
            case CHECK_ROVER_POSITION_Service:
                return null; //new CheckRoverPositionServiceInterface();
            default:
                return null;
        }
    }

    public enum ServiceType {
        SET_PLATEAU_COORDINATES_Service,
        SET_ROVER_Service,
        CHECK_ROVER_POSITION_Service,
        TURN_N_Service,
        TURN_S_Service,
        TURN_L_Service,
        TURN_W_Service,
        MOVE_Service
    }
}
