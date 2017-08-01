package com.ultimate; /**
 * Created by Gotus on 31.07.2017.
 */



import com.ultimate.core.commands.CharCreateCommand;
import com.ultimate.core.commands.Command;
import com.ultimate.core.commands.MoveCommand;
import com.ultimate.core.commands.QuitCommand;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;

import java.util.Scanner;

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

        /*
        myWorld.createLocationArray();
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
        //test change
        CommandHandler commandHandler = new CommandHandler(commands);
        while (myWorld.getActive()) {

            commandHandler.handleCommand(consoleInput.nextLine(), character, myWorld);
        }
        */
    }
}
