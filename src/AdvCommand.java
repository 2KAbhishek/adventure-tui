/*
 * File: AdvCommand.java
 * ---------------------
 * This file defines the general superclass of all commands in the
 * Adventure game along with a set of individual commands that
 * implement the built-in functions.
 */

/* Abstract class: AdvCommand */
/**
 * This class is the general superclass for all commands in the Adventure game.
 * Every command has an execute method, which is called by the game when that
 * command is invoked. This method will be defined individually in each of the
 * subclasses.
 */

public abstract class AdvCommand {

	/** The predefined entry for the QUIT command */
	public static final AdvCommand QUIT = new QuitCommand();

	/** The predefined entry for the LOOK command */
	public static final AdvCommand LOOK = new LookCommand();

	/** The predefined entry for the INVENTORY command */
	public static final AdvCommand INVENTORY = new InventoryCommand();

	/** The predefined entry for the TAKE command */
	public static final AdvCommand TAKE = new TakeCommand();

	/** The predefined entry for the DROP command */
	public static final AdvCommand DROP = new DropCommand();

	/* Abstract method: execute(game, obj) */
	/**
	 * Executes this command in the context of the specified adventure game. The
	 * execute method also takes a parameter obj, which specifies the object
	 * being used in the command. This value is typically null, but will be the
	 * appropriate object in the case of the TAKE and DROP commands.
	 * 
	 * @usage command.execute(game, obj);
	 * @param adv
	 *            The instance of the Adventure class that represents the game
	 * @param obj
	 *            The direct object (if any)
	 */
	public abstract void execute(Adventure game, AdvObject obj);

}

/* Package class: QuitCommand */
/**
 * This class implements the QUIT command.
 */

class QuitCommand extends AdvCommand {
	public void execute(Adventure game, AdvObject obj) {
		game.executeQuitCommand();
	}
}

/* Package class: LookCommand */
/**
 * This class implements the LOOK command.
 */

class LookCommand extends AdvCommand {
	public void execute(Adventure game, AdvObject obj) {
		game.executeLookCommand();
	}
}

/* Package class: InventoryCommand */
/**
 * This class implements the INVENTORY command.
 */

class InventoryCommand extends AdvCommand {
	public void execute(Adventure game, AdvObject obj) {
		game.executeInventoryCommand();
	}
}

/* Package class: TakeCommand */
/**
 * This class implements the TAKE command.
 */

class TakeCommand extends AdvCommand {
	public void execute(Adventure game, AdvObject obj) {
		game.executeTakeCommand(obj);
	}
}

/* Package class: DropCommand */
/**
 * This class implements the DROP command.
 */

class DropCommand extends AdvCommand {
	public void execute(Adventure game, AdvObject obj) {
		game.executeDropCommand(obj);
	}
}

/* Package class: HelpCommand */
/**
 * This class implements the HELP command.
 */

class HelpCommand extends AdvCommand {
	public void execute(Adventure game, AdvObject obj) {
		// Add your code here
	}
}