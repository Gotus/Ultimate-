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

        newCharacter.setName(consoleInput.nextLine());

        boolean success = false;
        while (!success) {

            String raceName = consoleInput.nextLine();
            for (PlayCharacter.Race r: PlayCharacter.Race.values()) {

                if (raceName.equalsIgnoreCase(r.toString())) {

                    newCharacter.setRace(r);
                    success = true;
                }
            }
        }


        //newCharacter.setCity();


    }
}
