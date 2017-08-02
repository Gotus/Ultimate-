package com.ultimate.core.commands;

import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;

import java.util.Scanner;


public class CharCreateCommand extends Command {

    public CharCreateCommand(){

        this.commandName = "create";
        this.description = "This command allows you to create character. Follow intructions after input this command.";
    }

    @Override
    public void call(PlayCharacter newCharacter, World world, String... context)
    {
        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Welcome to the Ultimate- world!");
        System.out.println("Select your character name.");
        newCharacter.setName(consoleInput.nextLine());

        System.out.println("Now you can select your race from this list:");
        for (PlayCharacter.Race r: PlayCharacter.Race.values()) {

            System.out.println(r.toString());
        }

        boolean success = false;
        while (!success) {

            String raceName = consoleInput.nextLine();
            for (PlayCharacter.Race r: PlayCharacter.Race.values()) {

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

        //newCharacter.setCity();
        //System.out.println("Now you are in " + newCharacter.getCurrentCity());

    }
}
