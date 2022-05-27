/* Class: AdvMotionTableEntry */
/**
 * This class is used to store a single entry in the motion table.
 */

public class AdvMotionTableEntry {

/* Constructor: AdvMotionTableEntry(dir, room, key) */
/**
 * Creates a new motion table entry.
 *
 * @param dir The string specifying the direction of motion
 * @param room The number of the destination room
 * @param key The name of the object used as a key, or null if none
 */
	public AdvMotionTableEntry(String dir, int room, String key) {
		direction = dir.toUpperCase();
		destinationRoom = room;
		keyName = (key == null) ? null : key.toUpperCase();
	}

/* Method: getDirection() */
/**
 * Returns the direction name from a motion table entry.
 *
 * @return The string specifying the direction of motion
 */
	public String getDirection() {
		return direction;
	}

/* Method: getDestinationRoom() */
/**
 * Returns the room number to which a particular direction leads.
 *
 * @return The number of the destination room
 */
	public int getDestinationRoom() {
		return destinationRoom;
	}

/* Method: getKeyName() */
/**
 * Returns the name of the object required for travel along a locked
 * passage, or null if the passage is always available.
 *
 * @return The name of the object used as a key, or null if none
 */
	public String getKeyName() {
		return keyName;
	}

/* Private instance variables */
	private String direction;
	private int destinationRoom;
	private String keyName;
}
