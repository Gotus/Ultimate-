package com.ultimate.core;

import java.util.HashMap;


/**
 * Created by Gotus on 20.07.2017.
 */
public class CommandHandler{

    private HashMap<String, Command> allCommands = new HashMap<String, Command>();

    public CommandHandler(Command[] commands)
    {
        for (Command c: commands) {

            allCommands.put(c.getCommandName(), c);
        }
    }

    public void addCommand(Command newCommand) {

        allCommands.put(newCommand.getCommandName(), newCommand);
    }


    public void handleCommand(String command, PlayCharacter character, World world) {

        String[] commandParts = command.split(" ");
        if (allCommands.containsKey(commandParts[0])) {

            allCommands.get(commandParts[0]).call(character, world, commandParts);
        }
    }
}
