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

public class Adventure extends AdventureStub {

	// Use this scanner for any console input
	private static Scanner scan = new Scanner(System.in);

	/**
	 * This method is used only to test the program
	 */
	public static void setScanner(Scanner theScanner) {
		scan = theScanner;
		// Delete the following line when done
		AdventureStub.setScanner(theScanner);
	}

	/**
	 * Runs the adventure program
	 */
	public static void main(String[] args) {
		AdventureStub.main(args); // Replace with your code
	}

	/* Method: executeMotionCommand(direction) */
	/**
	 * Executes a motion command. This method is called from the
	 * AdvMotionCommand class to move to a new room.
	 * 
	 * @param direction
	 *            The string indicating the direction of motion
	 */
	public void executeMotionCommand(String direction) {
		super.executeMotionCommand(direction); // Replace with your code
	}

	/* Method: executeQuitCommand() */
	/**
	 * Implements the QUIT command. This command should ask the user to confirm
	 * the quit request and, if so, should exit from the play method. If not,
	 * the program should continue as usual.
	 */
	public void executeQuitCommand() {
		super.executeQuitCommand(); // Replace with your code
	}

	/* Method: executeHelpCommand() */
	/**
	 * Implements the HELP command. Your code must include some help text for
	 * the user.
	 */
	public void executeHelpCommand() {
		super.executeHelpCommand(); // Replace with your code
	}

	/* Method: executeLookCommand() */
	/**
	 * Implements the LOOK command. This method should give the full description
	 * of the room and its contents.
	 */
	public void executeLookCommand() {
		super.executeLookCommand(); // Replace with your code
	}

	/* Method: executeInventoryCommand() */
	/**
	 * Implements the INVENTORY command. This method should display a list of
	 * what the user is carrying.
	 */
	public void executeInventoryCommand() {
		super.executeInventoryCommand(); // Replace with your code
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
		super.executeTakeCommand(obj); // Replace with your code
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
		super.executeDropCommand(obj); // Replace with your code
	}

	/* Private instance variables */
	// Add your own instance variables here
}
