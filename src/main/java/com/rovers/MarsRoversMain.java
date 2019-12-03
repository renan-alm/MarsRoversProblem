package com.rovers;

public class MarsRoversMain {

    public static void main(String[] args) {

        // NEW Requirements:
        // 5. Objects out of Status or History - Check
        // 6. Implement a REST API   --- CXF
        // 7. Can you use Stream?


        Config config = Config.getInstance();

        System.out.println("== Mars Rovers Problem ==");

        RestServer server = new RestServer();


        Plateau plateau = new Plateau(5,5);

        Rover rover1 = new Rover().withCoordinates(1,2).withDirection(Direction.NORTH).withPlateau(plateau);
        rover1.start();

        Rover rover2 = new Rover().withCoordinates(3,3).withDirection(Direction.EAST).withPlateau(plateau);
        rover2.start();
    }
}
