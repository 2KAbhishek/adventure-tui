/*
 * File: Adventure.java
 * --------------------
 * This program plays the Adventure game from Assignment #4.
 */

import java.io.*;
import java.util.*;

/* Class: Adventure */
/**
 * This class is the main program class for the Adventure game.
 */

public class Adventure {

    // Use this scanner for any console input
    private static Scanner scan = new Scanner(System.in);

    /**
     * This method is used only to test the program
     */
    public static void setScanner(Scanner theScanner) {
        scan = theScanner;
    }

    /* Private instance variables */
    private ArrayList<AdvRoom> rooms;
    private AdvRoom currentRoom;
    private ArrayList<AdvObject> inventory;
    private HashMap<String, AdvCommand> commands;
    private HashMap<String, AdvObject> objects;

    private final String DATA_PATH = "data/";

    /**
     * Runs the adventure program
     */
    public static void main(String[] args) {
        AdventureStub.main(args); // Replace with your code
    private void setUpRooms(String gameName) {
        try {
            Scanner roomScan = new Scanner(new File(DATA_PATH + gameName + "Rooms.txt"));
            while (roomScan.hasNextLine()) {
                AdvRoom room = AdvRoom.readFromFile(roomScan);
                if (room == null) {
                    continue;
                }
                rooms.add(room);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    private void setCurrentRoom(int roomNumber) {
        for (AdvRoom room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                currentRoom = room;
                break;
            }
        }
        currentRoom.setVisited(true);
        System.out.println(currentRoom.getName());
    }

    private void setUpCommands() {
        commands.put("QUIT", AdvCommand.QUIT);
        commands.put("LOOK", AdvCommand.LOOK);
        commands.put("INVENTORY", AdvCommand.INVENTORY);
        commands.put("TAKE", AdvCommand.TAKE);
        commands.put("DROP", AdvCommand.DROP);
        commands.put("HELP", AdvCommand.HELP);
        commands.put("NORTH", AdvCommand.NORTH);
        commands.put("SOUTH", AdvCommand.SOUTH);
        commands.put("EAST", AdvCommand.EAST);
        commands.put("WEST", AdvCommand.WEST);
    }

    private void setUpObjects(String gameName) {
        try {
            Scanner scan = new Scanner(new File(DATA_PATH + gameName + "Objects.txt"));
            while (scan.hasNextLine()) {
                String name = scan.nextLine();
                if (name.equals("")) {
                    continue;
                }
                String description = scan.nextLine();
                int initialLocation = Integer.parseInt(scan.nextLine());
                AdvObject obj = new AdvObject(name, description, initialLocation);
                objects.put(name, obj);
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    private void setUpSynonyms(String gameName) {
        try {
            Scanner scan = new Scanner(new File(DATA_PATH + gameName + "Synonyms.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] words = line.split("\\s+");
                if (commands.containsKey(words[0])) {
                    commands.put(words[0], commands.get(words[1]));
                }
                if (objects.containsKey(words[0])) {
                    objects.put(words[0], objects.get(words[1]));
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }
    }

    /* Method: executeMotionCommand(direction) */
    /**
     * Executes a motion command. This method is called from the
     * AdvMotionCommand class to move to a new room.
     *
     * @param direction
     *                  The string indicating the direction of motion
     */
    public void executeMotionCommand(String direction) {
        for (AdvMotionTableEntry entry : currentRoom.getMotionTable()) {
            if (entry.getDirection().equals(direction)) {
                if (entry.getKeyName() != null) {
                    if (!hasItem(entry.getKeyName())) {
                        System.out.println("You need " + entry.getKeyName() + " to go there.");
                        return;
                    }
                } else {
                    setCurrentRoom(entry.getDestinationRoom());
                }
            }
        }
    }

    private boolean hasItem(String keyName) {
        for (AdvObject obj : inventory) {
            if (obj.getName().equals(keyName)) {
                return true;
            }
        }
        return false;
    }

    /* Method: executeQuitCommand() */
    /**
     * Implements the QUIT command. This command should ask the user to confirm
     * the quit request and, if so, should exit from the play method. If not,
     * the program should continue as usual.
     */
    public void executeQuitCommand() {
        System.out.println("Do you want to quit the game?");
        if (scan.next().trim().equals("YES")) {
            System.exit(0);
        }
    }

    /* Method: executeHelpCommand() */
    /**
     * Implements the HELP command. Your code must include some help text for
     * the user.
     */
    public void executeHelpCommand() {
        System.out.println("Gameplay Guide:");
        System.out.println("This is a text adventure game.");
        System.out.println("You can move around the game and do various things by typing commands.");
        System.out.println("  DIRECTION:   You can move in the four cardinal directions.");
        System.out.println("  TAKE <item>: You can pick up an item.");
        System.out.println("  DROP <item>: You can drop an item.");
        System.out.println("  INVENTORY:   You can see what you are carrying.");
        System.out.println("  HELP:        You can get this help text.");
    }

    /* Method: executeLookCommand() */
    /**
     * Implements the LOOK command. This method should give the full description
     * of the room and its contents.
     */
    public void executeLookCommand() {
        System.out.println(String.join("\n", currentRoom.getDescription()));

        for (int i = 0; i < currentRoom.getObjectCount(); i++) {
            System.out.println("  " + currentRoom.getObject(i).getDescription());
        }
    }

    /* Method: executeInventoryCommand() */
    /**
     * Implements the INVENTORY command. This method should display a list of
     * what the user is carrying.
     */
    public void executeInventoryCommand() {
        for (AdvObject obj : inventory) {
            System.out.println(obj.getDescription());
        }
    }

    /* Method: executeTakeCommand(obj) */
    /**
     * Implements the TAKE command. This method should check that the object is
     * in the room and deliver a suitable message if not.
     *
     * @param obj
     *            The AdvObject you want to take
     */
    public void executeTakeCommand(AdvObject obj) {
        inventory.add(obj);
        currentRoom.removeObject(obj);
    }

    /* Method: executeDropCommand(obj) */
    /**
     * Implements the DROP command. This method should check that the user is
     * carrying the object and deliver a suitable message if not.
     *
     * @param obj
     *            The AdvObject you want to drop
     */
    public void executeDropCommand(AdvObject obj) {
        inventory.remove(obj);
        currentRoom.addObject(obj);
    }
}
