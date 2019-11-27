package com.rovers;

public class MarsRoversMain {

    public static void main(String[] args) {

        Config config = Config.getInstance();

        System.out.println("== Mars Rovers Problem ==");

/*        RestServer server = new RestServer();
        server.initializeServer(config).start();*/

        Plateau plateau = new Plateau(5,5);

        Rover rover1 = new Rover(plateau).withCoordinates(1,2).withDirection(Direction.NORTH);
        rover1.start();

        Rover rover2 = new Rover(plateau).withCoordinates(3,3).withDirection(Direction.EAST);
        rover2.start();
    }
}
