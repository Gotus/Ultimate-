package com.ultimate.core.commands;

import com.ultimate.core.CurrentGame;
import com.ultimate.core.gameObjects.PlayCharacter;

import java.util.Scanner;


public class CharCreateCommand extends Command {

    public CharCreateCommand(){

        this.commandName = "create";
        this.description = "This command allows you to create character. Follow intructions after input this command.";
    }

    @Override
    public void call(CurrentGame currentGame, String... context)
    {
        Scanner consoleInput = new Scanner(System.in);
        PlayCharacter character = currentGame.getGameData().getPlayCharacter();

        character.setName(consoleInput.nextLine());

        boolean success = false;
        while (!success) {

            String raceName = consoleInput.nextLine();
            for (PlayCharacter.Race r : PlayCharacter.Race.values()) {

                if (raceName.equalsIgnoreCase(r.toString())) {

                    character.setRace(r);
                    success = true;
                }
            }
        }

    }
}
