package com.ultimate.core;

import com.ultimate.core.commands.Command;

import java.util.HashMap;


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


    public void handleCommand(String command, CurrentGame currentGame) {

        String[] commandParts = command.split(" ");
        if (allCommands.containsKey(commandParts[0])) {

            allCommands.get(commandParts[0]).call(currentGame, commandParts);
        }
    }
}
