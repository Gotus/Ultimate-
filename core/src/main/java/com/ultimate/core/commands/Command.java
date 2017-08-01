package com.ultimate.core.commands;

import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;

public abstract class Command {

    protected String commandName;
    protected String description;

    public String getCommandName()
    {
        return commandName;
    }

    public String getDescription()
    {
        return description;
    }

    public abstract void call(PlayCharacter newCharacter, World world, String ...context);
}
