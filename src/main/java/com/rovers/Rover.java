package com.rovers;

import java.util.ArrayList;
import java.util.Scanner;

public class Rover implements Machine {

    // NEW Requirements:
    // 5. Objects out of Status or History - Check
    // 6. Implement a REST API   --- CXF

    private int edgeX;
    private int edgeY;
    private Direction d = Direction.NORTH;
    private Coordinates coordinates = new Coordinates();
    private final ArrayList<String> history = new ArrayList<>();

    Rover(Plateau plateau){
        this.edgeX = plateau.getEdgeX();
        this.edgeY = plateau.getEdgeY();
    }

    Rover withCoordinates(int x, int y) {
        coordinates.setCoordinates(x, y);
        this.d = Direction.NORTH;
        showStatus();
        return this;
    }
    Rover withDirection(Direction d){
        this.d = d;
        return this;
    }

    public void showStatus(){
        System.out.println("Rover current position: (" + coordinates.getX() + ", " + coordinates.getY() + ", "  + d.toString() + ")");
    }

    void start() {
        boolean exit = false;
        String option;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println(" == Pick an action:");
            System.out.println("M: Move forward     S: Status       H: History/logs");
            System.out.println("L: Turn left        R: Turn right   E: Exit rover");
            option = scanner.nextLine();

            if (option.equals("L"))
                turnRover("L");
            else if(option.equals("R"))
                turnRover("R");
            else if(option.equals("M"))
                moveForward();
            else if(option.equals("S"))
                showStatus();
            else if(option.equals("H"))
                displayHistory();
            else {
                System.out.println("Exiting rover execution.");
                exit = true;
            }
        }
    }

    private void turnRover(String leftRight) {
        if (leftRight.equals("R")){  // TURN RIGHT
            if (d.toString().equals(Direction.WEST.toString())){
                this.d = Direction.NORTH;
            }else{
                this.d = d.next();
            }
        }else{    // TURN LEFT
            if ( d.toString().equals(Direction.NORTH.toString()) ) {
                this.d = Direction.WEST;
            }else{
                this.d = d.previous();
            }
        }
        System.out.println("Rover set to " + d.toString()+ ".");
    }

    private void moveForward() {
        String n = d.toString();
        int x = coordinates.getX();
        int y = coordinates.getY();

        if (n.equals("NORTH") && coordinates.getY() != edgeY) {
            history.add(coordinates.setCoordinates(x, y+1));
        } else if (n.equals("EAST") && x != edgeX) {
            history.add(coordinates.setCoordinates(x+1, y));
        } else if (n.equals("SOUTH") && y != 0) {
            history.add(coordinates.setCoordinates(x, y-1));
        } else if (n.equals("WEST") && x != 0) {
            history.add(coordinates.setCoordinates(x-1, y));
        }
        else {
            System.out.println("You are by the edge of the plateau. Do something else.");
        }
        showStatus();
    }

    private void displayHistory() {
        System.out.println(" -- Rover logs");
        for (String i : history)
            System.out.println(i);
        System.out.println(" -- ");
    }
}
