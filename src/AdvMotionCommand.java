/* Class: AdvMotionCommand */
/**
 * This class is the subclass of AdvCommand that corresponds to
 * motion verbs.  Each instance of this class stores the motion
 * direction it uses as part of its state.
 */

public class AdvMotionCommand extends AdvCommand {

/* Constructor: AdvMotionCommand(dir) */
/**
 * Creates a new AdvMotionCommand for the specified direction.
 *
 * @usage command = new AdvMotionCommand(dir);
 * @param dir The string corresponding to the direction of motion
 */
	public AdvMotionCommand(String dir) {
		direction = dir;
	}

/* Method: execute(adv, obj) */
/**
 * Executes this command in the context of the adventure game passed
 * as the adv parameter.  This method must be defined by all AdvCommand
 * objects.  Here it simply calls executeMotionCommand with the
 * stored direction.
 */
	public void execute(Adventure game, AdvObject obj) {
		game.executeMotionCommand(direction);
	}

/* Private instance variables */

	private String direction;
}
