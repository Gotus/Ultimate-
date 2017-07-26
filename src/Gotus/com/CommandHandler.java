package Gotus.com;

import javax.swing.*;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



/**
 * Created by Gotus on 20.07.2017.
 */
public class CommandHandler{

    private HashMap<String, Command> allCommands = new HashMap<String, Command>();

    CommandHandler(Command[] commands)
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
        switch (commandParts[0]) {

            case "create":
                allCommands.get(commandParts[0]).call(character, world);
                break;
            case "quit":
                allCommands.get(commandParts[0]).call(character, world);
                break;
            case "move":
                allCommands.get(commandParts[0]).call(character, world, commandParts);
                break;

        }
    }
}
