package Gotus.com;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

enum Race {

    HUMAN,
    ELF
}

public class Main {

    public static void main(String[] args) {

        PlayCharacter character = new PlayCharacter();
        World myWorld = new World();
        Scanner consoleInput = new Scanner(System.in);
        final int numOfCommands = 3;
        Command[] commands = new Command[numOfCommands];
        commands[0] = new CharCreateCommand();
        commands[1] = new QuitCommand();
        commands[2] = new MoveCommand();

        myWorld.createWorldArray();
        //System.out.println(character.setName("Gotus"));
        //System.out.println(character.setRace(Race.ELF));
        //character.addSkill(Skills.POWERSTRIKE);
        //System.out.println(character.increaseSkill(Skills.POWERSTRIKE, 4));
        //System.out.println(character.getSkillPoints());
        //character.acceptSkills();
        //character.resetSkills();
        //System.out.println(character.getSkillValue(Skills.POWERDRAW));
        //CharCreator.createCharacter(character);
        //myWorld.createWorldArray(Size.AVERAGE);
        //myWorld.createWorldArray();
        CommandHandler commandHandler = new CommandHandler(commands);
        while (myWorld.getActive()) {

            commandHandler.handleCommand(consoleInput.nextLine(), character, myWorld);
        }
    }
}
//test change