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
    }
}
