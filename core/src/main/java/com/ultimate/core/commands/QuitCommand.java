package com.ultimate.core.commands;

import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;


public class QuitCommand  extends Command {

    public QuitCommand() {

        this.commandName = "quit";
        this.description = "Input this command to exit the game";
    }

    @Override
    public void call(PlayCharacter character, World world, String... context) {

        System.exit(0);
    }
}
