package com.rovers;

import java.util.ArrayList;
import java.util.Scanner;

public class Rover implements Machine {

    // New requirements:
    // 1. Plateau as an input to Rovers -- CHECK
    // 2. Save history of the Rover -- CHECK
    // 3. Create a correction/validation method to reduce lines from moving left and right -- CHECK
    // 4. Exercise the use of methods to initialize objects --
    // 5. Implement a REST API   --- CXF
    // 6. Objects out of Status or History

    private int edgeX;
    private int edgeY;
    private int marker;
    private Coordinate coordinate = new Coordinate();
    private final ArrayList<String> history = new ArrayList<>();

    private static final ArrayList<String> orientation = new ArrayList<String>(){{
        add("N");
        add("E");
        add("S");
        add("W");
    }};


    Rover(Plateau plateau){
        this.edgeX = plateau.getEdgeX();
        this.edgeY = plateau.getEdgeY();
    }

    Rover withCoordinates(int x, int y) {
        coordinate.setCoordinates(x, y);
        this.marker = 0;
        showStatus();
        return this;
    }
    Rover withOrientation(int marker){
        this.marker = marker;
        return this;
    }

    public void showStatus(){
        System.out.println("Rover current position: (" + coordinate.getX() + ", " + coordinate.getY() + ", "  + orientation.get(marker) + ")");
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
        if (leftRight.equals("R")){  // Meaning, string equals to right
            marker++;
            if (marker == 4)
                marker = 0;
        }else{                      // Meaning, string equals to left
            marker--;
            if (marker == -1)
                marker = 3;
        }
        System.out.println("Rover set to " + orientation.get(marker) + ".");
    }

    private void moveForward() {
        String n = orientation.get(marker);
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (n.equals("N") && coordinate.getY() != edgeY) {
            history.add(coordinate.setCoordinates(x, y+1));
        } else if (n.equals("E") && x != edgeX) {
            history.add(coordinate.setCoordinates(x+1, y));
        } else if (n.equals("S") && y != 0) {
            history.add(coordinate.setCoordinates(x, y-1));
        } else if (n.equals("W") && x != 0) {
            history.add(coordinate.setCoordinates(x-1, y));
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
