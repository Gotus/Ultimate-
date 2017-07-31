package com.ultimate; /**
 * Created by Gotus on 31.07.2017.
 */



import com.ultimate.core.*;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        try {
            Class.forName("com.ultimate.core.Location");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PlayCharacter character = new PlayCharacter();
        World myWorld = new World();
        Scanner consoleInput = new Scanner(System.in);
        final int numOfCommands = 3;
        Command[] commands = new Command[numOfCommands];
        commands[0] = new CharCreateCommand();
        commands[1] = new QuitCommand();
        commands[2] = new MoveCommand();

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
    }
}
