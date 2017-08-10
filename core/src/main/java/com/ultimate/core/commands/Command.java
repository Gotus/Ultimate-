package com.ultimate.core.commands;

import com.ultimate.core.CurrentGame;

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

    public abstract void call(CurrentGame currentGame, String ...context);
}
