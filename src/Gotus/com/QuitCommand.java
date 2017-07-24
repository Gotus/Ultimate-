package Gotus.com;

/**
 * Created by Gotus on 24.07.2017.
 */
public class QuitCommand  extends Command {

    QuitCommand() {

        this.commandName = "quit";
        this.description = "Input this command to exit the game";
    }

    @Override
    public void call(PlayCharacter character, World world, String... context) {

        world.setActive(false);
    }
}
