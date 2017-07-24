package Gotus.com;

/**
 * Created by Gotus on 24.07.2017.
 */
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

    abstract void call(PlayCharacter newCharacter, World world);
}
