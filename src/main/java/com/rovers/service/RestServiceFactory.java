package com.rovers.service;

public class RestServiceFactory {
    /*
     *  This class responds with a rest service that depending of the service will execute
     *  a specific service (method) within the code.
     *
     * */
    public static IRestService getRestService(final ServiceType service) { // Where ServiceType is a enum class
        switch (service) {
            case CHECK_ROVER_POSITION:
                return new CheckRoverPositionService();
            case SET_PLATEAU_COORDINATES:
                return new SetPlateauDimension();
            case MOVE:
                return new MoveRoverForward();
            default:
                return null;
        }
    }
}
