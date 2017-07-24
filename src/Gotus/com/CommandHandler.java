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

    CommandHandler()
    {
        allCommands.put("create character", new CharCreateCommand());
        allCommands.put("quit", new QuitCommand());
    }


    public void handleCommand(String command, PlayCharacter character, World world) {

        switch (command) {

            case "create character":
                allCommands.get(command).call(character, world);
                break;
            case "quit":
                allCommands.get(command).call(character, world);
                break;
            case "move north":
                if ((character.getY() > 0) && (character != null)){

                    character.setY(character.getY() - 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY() - 1) * world.getLength()]);
                    System.out.println("Current x: " + character.getX());
                    System.out.println("Current y: " + character.getY());
                    System.out.println(character.getCurrentLocation());
                }
                break;
            case "move south":
                if ((character.getY() < world.getHeight()) && (character != null)) {

                    character.setY(character.getY() + 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY() - 1) * world.getLength()]);
                    System.out.println("Current x: " + character.getX());
                    System.out.println("Current y: " + character.getY());
                    System.out.println(character.getCurrentLocation());
                }
                break;
            case "move west":
                if ((character.getX() > 0) && (character != null)) {

                    character.setX(character.getX() - 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY() - 1) * world.getLength()]);
                    System.out.println("Current x: " + character.getX());
                    System.out.println("Current y: " + character.getY());
                    System.out.println(character.getCurrentLocation());
                }
                break;
            case "move east":
                if ((character.getX() < world.getLength() - 1) && (character != null)) {

                    character.setX(character.getX() + 1);
                    character.setCurrentLocation(world.getWorldCells()[character.getX() + (character.getY() - 1) * world.getLength()]);
                    System.out.println("Current x: " + character.getX());
                    System.out.println("Current y: " + character.getY());
                    System.out.println(character.getCurrentLocation());
                }
                break;
        }
    }
}
