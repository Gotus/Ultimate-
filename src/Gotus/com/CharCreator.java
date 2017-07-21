package Gotus.com;

import java.util.Scanner;



/**
 * Created by Gotus on 20.07.2017.
 */
public class CharCreator {

    public static PlayCharacter createCharacter(PlayCharacter newCharacter) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Welcome to the Ultimate- world!");
        System.out.println("Select your character name.");
        newCharacter.setName(consoleInput.nextLine());

        System.out.println("Now you can select your race from this list:");
        for (Race r: Race.values()) {

            System.out.println(r.toString());
        }

        boolean success = false;
        while (!success) {

            String raceName = consoleInput.nextLine();
            for (Race r: Race.values()) {

                if (raceName.equalsIgnoreCase(r.toString())) {

                    newCharacter.setRace(r);
                    success = true;
                }
            }

            if (!success) {

                System.out.println("Race named " + raceName + " does not exist. Choose another one.");
            }
        }

        System.out.println("You successfully selected your race as " + newCharacter.getRace());

        //Here must be my code, but here digital nothing

        return newCharacter;
    }
}
