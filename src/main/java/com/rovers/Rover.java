package com.rovers;

import java.util.ArrayList;
import java.util.Scanner;

public class Rover implements Machine {

    public int getEdgeX() {
        return edgeX;
    }

    public int getEdgeY() {
        return edgeY;
    }

    private int edgeX = -1;
    private int edgeY = -1;

    public Direction getD() {
        return d;
    }

    private Direction d;
    private Coordinates coordinates = new Coordinates();
    private final ArrayList<String> history = new ArrayList<>();

    public Rover() {
        this.edgeX = 2;
        this.edgeX = 2;
        d = Direction.NORTH;
        coordinates = new Coordinates(1,1); // Coordinates cannot be bigger than the edges of the plateau
    }
    public Rover withCoordinates(int x, int y) {
        coordinates.setCoordinates(x, y);
        return this;
    }
    public Rover withDirection(Direction d){
        this.d = d;
        return this;
    }
    public Rover withPlateau(Plateau plateau){
        this.edgeX = plateau.getEdgeX();
        this.edgeY = plateau.getEdgeY();
        return this;
    }
    @Override  // From the interface Machine
    public String showStatus(){
        return ( coordinates.getX() + ", " + coordinates.getY() );
    }

    void start() {
        boolean exit = false;
        String option;
        String status;
        Scanner scanner = new Scanner(System.in);
        while (!exit){
            System.out.println(" == Pick an action:");
            System.out.println("M: Move forward     S: Status       H: History/logs");
            System.out.println("L: Turn left        R: Turn right   E: Exit rover");
            option = scanner.nextLine();

            if (option.equals("L")){
                turnRover("L");
            }
            else if(option.equals("R")) {
                turnRover("R");
            }
            else if(option.equals("M")) {
                moveForward();
            }
            else if(option.equals("S")) {
                status = showStatus();
                System.out.println("Rover current position: (" + status + ", "  + d.toString() + ")");
            }
            else if(option.equals("H")) {
                displayHistory();
            }
            else {
                System.out.println("Exiting rover execution.");
                exit = true;
            }
        }
    }

    public void turnRover(String leftRight) {
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

    public void moveForward() {
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

    public boolean isDeployed(){
        if (edgeY == -1 || edgeX == -1){
            return false;
        }else{
            return true;
        }
    }
}
