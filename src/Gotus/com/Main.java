package Gotus.com;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.security.PKCS12Attribute;
import java.util.Scanner;

public class Main {

    public enum Race {

        DRAGOON,
        HUMAN,
        CRYSTAL,
        GOLEM,
        ELF,
        ROBOT,
        MACHINE
    }

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Select character name");
        String playerName = new String(consoleInput.next());
        StringBuilder buf = new StringBuilder();
        String playerRace;

        boolean success = false;
        while (!success) {

            System.out.println("Select character race.\nYou can select race from this list.\nInput name of selected race to console.");
            for (Race r: Race.values()) {

                System.out.println(r.ordinal() + 1 + " " + r);
            }

            StringBuilder selectedRace = new StringBuilder(consoleInput.next());

            for (Race r: Race.values()) {

                if (selectedRace.toString().toUpperCase().equals(r.toString())) {

                    buf.append(r.toString());
                    success = true;
                }
            }
        }

        playerRace = new String(buf.toString());
        success = false;

        System.out.println("You successfully selected you race, which is " + playerRace);
        switch (playerRace.toString()) {

            case "ELF":
                buf = new StringBuilder("MUA FOREST");
                break;
            case "DRAGOON":
                buf = new StringBuilder("DEIST");
                break;
            case "HUMAN":
                buf = new StringBuilder("FYNN");
                break;
            case "CRYSTALL":
                buf = new StringBuilder("CRYSTALLION");
                break;
            case "GOLEM":
                buf = new StringBuilder("LIVING ROCK");
                break;
            case "ROBOT":
                buf = new StringBuilder("METAL BASE");
                break;
            case "MACHINE":
                buf = new StringBuilder("U-78 MOD.14");
                break;
        }

        String playerGlobalLocation = new String(buf.toString());

        System.out.println("You are in " + playerGlobalLocation + " territory");

        System.out.println("------------------------------------------------------------------");
        System.out.println("Now you are in skill menu. You can set you base stats and skills.");
        System.out.println("You can spend not all skillpoints/statpoints. When you set your character as you want, input ACCEPT");
        int statpoints = 10;
        int strength = 3;
        int agility = 3;
        int stamina = 3;
        int charisma = 3;
        int intellegence = 3;
        StringBuilder command = new StringBuilder();
        while (!command.toString().equals("ACCEPT")) {

            command = new StringBuilder(consoleInput.nextLine().toUpperCase());
            if ((statpoints == 0) && (!command.toString().equals("ACCEPT"))) {

                System.out.println("You have not statpoints");
                continue;
            }

            switch (command.toString())
            {
                case "STR UP":
                    statpoints -= 1;
                    strength += 1;
                    System.out.println("Your STRENGTH: " + strength);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "STR DOWN":
                    statpoints -= 1;
                    strength -= 1;
                    System.out.println("Your STRENGTH: " + strength);
                    System.out.println("Your STATPOINTS: " + statpoints);

                    break;
                case "AGI UP":
                    statpoints -= 1;
                    agility += 1;
                    System.out.println("Your AGILITY: " + agility);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "AGI DOWN":
                    statpoints -= 1;
                    agility -= 1;
                    System.out.println("Your AGILITY: " + agility);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "STA UP":
                    statpoints -= 1;
                    stamina += 1;
                    System.out.println("Your STAMINA: " + stamina);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "STA DOWN":
                    statpoints -= 1;
                    stamina -= 1;
                    System.out.println("Your STAMINA: " + stamina);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "CHA UP":
                    statpoints -= 1;
                    charisma += 1;
                    System.out.println("Your CHARISMA: " + charisma);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "CHA DOWN":
                    statpoints -= 1;
                    charisma -= 1;
                    System.out.println("Your CHARISMA: " + charisma);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "INT UP":
                    statpoints -= 1;
                    intellegence += 1;
                    System.out.println("Your INTELLIGENCE: " + intellegence);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;
                case "INT DOWN":
                    statpoints -= 1;
                    intellegence -= 1;
                    System.out.println("Your INTELLIGENCE: " + intellegence);
                    System.out.println("Your STATPOINTS: " + statpoints);
                    break;

                case "RESET STATS":
                    System.out.println("Are you sure?");
                    if (consoleInput.next().toUpperCase().equals("YES")) {

                        statpoints = 10;
                        strength = 3;
                        agility = 3;
                        stamina = 3;
                        charisma = 3;
                        intellegence = 3;
                        System.out.println("All your stats reduced to 3. You have " + statpoints + " STATPOINTS");
                    }
                    break;
            }
        }
    }
}
