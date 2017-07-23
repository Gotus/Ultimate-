package Gotus.com;

import javax.swing.*;
import java.nio.file.Watchable;
import java.util.Scanner;



/**
 * Created by Gotus on 20.07.2017.
 */
public class CommandHandler{

    public static PlayCharacter createCharacter(PlayCharacter newCharacter) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Welcome to the Ultimate- world!");
        System.out.println("Select your character name.");
        newCharacter.setName(consoleInput.nextLine());

        System.out.println("Now you can select your race from this list:");
        for (Race r: Race.values()) {

            System.out.println(r.toString());
        }

        boolean success = false;
        while (!success) {

            String raceName = consoleInput.nextLine();
            for (Race r: Race.values()) {

                if (raceName.equalsIgnoreCase(r.toString())) {

                    newCharacter.setRace(r);
                    success = true;
                }
            }

            if (!success) {

                System.out.println("Race named " + raceName + " does not exist. Choose another one.");
            }
        }

        System.out.println("You successfully selected your race as " + newCharacter.getRace());

        newCharacter.setCity();
        System.out.println("Now you are in " + newCharacter.getCurrentCity());
        //Here must be my code, but here digital nothing

        return newCharacter;
    }

    public static void handleCommand(String command, PlayCharacter character, World world) {

        switch (command) {

            case "create character":
                createCharacter(character);
                break;
            case "quit":
                world.setActive(false);
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
