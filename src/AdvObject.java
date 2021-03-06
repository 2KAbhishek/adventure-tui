/*
 * File: AdvObject.java
 * --------------------
 * This file defines a class that models an object in the
 * Adventure game.
 */

import java.util.Scanner;

/* Class: AdvObject */
/**
 * This class defines an object in the Adventure game. An object is
 * characterized by the following properties:
 *
 * <ul>
 * <li>Its name, which is the noun used to refer to the object
 * <li>Its description, which is a string giving a short description
 * <li>The room number in which the object initially lives
 * </li>
 *
 */

public class AdvObject {
    /* Private instance variables */
    private String name;
    private String description;
    private int initialLocation;

    public AdvObject(String name, String description, int initialLocation) {
        this.name = name;
        this.description = description;
        this.initialLocation = initialLocation;
    }

    /* Method: getName() */
    /**
     * Returns the object name, which is the word used to refer to it.
     *
     * @usage String name = obj.getName();
     * @return The name of the object
     */
    public String getName() {
        return this.name;
    }

    /* Method: getDescription() */
    /**
     * Returns the one-line description of the object. This description
     * should start with an article, as in "a set of keys" or "an emerald
     * the size of a plover's egg."
     *
     * @usage String name = obj.getDescription();
     * @return The description of the object
     */
    public String getDescription() {
        return this.description;
    }

    /* Method: getInitialLocation() */
    /**
     * Returns the initial location of the object.
     *
     * @usage int roomNumber = obj.getInitialLocation();
     * @return The room number in which the object initially resides
     */
    public int getInitialLocation() {
        return this.initialLocation;
    }

    /* Method: readFromFile(scan) */
    /**
     * Reads the data for this object from the Scanner scan, which must have
     * been opened by the caller. This method returns the object if the object
     * initialization is successful; if there are no more objects to read,
     * readFromFile returns null
     *
     * @usage AdvObject object = AdvObject.readFromFile(scan);
     * @param scan
     *             A Scanner open on the objects data file
     * @return the object if an object is successfully read; null at end of file
     */
    public static AdvObject readFromFile(Scanner scan) {
        if (!scan.hasNext()) {
            return null;
        }
        String name = scan.next();
        String description = scan.nextLine().trim();
        int initialLocation = scan.nextInt();
        return new AdvObject(name, description, initialLocation);
    }
}
