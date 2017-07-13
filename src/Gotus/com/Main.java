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

    public enum Country {

        SALONIA,
        SAISON,
        POFT,
        BOFSK,
        ALTEA,
        SALMANDO
    }

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        System.out.println("Select character name");
        String playerName = new String(consoleInput.next());

        boolean success = false;
        while (!success) {

            System.out.println("Select character race.\nYou can select race from this list.\nInput name of selected race to console.");
            for (Race r: Race.values()) {

                System.out.println(r.ordinal() + 1 + " " + r);
            }

            StringBuilder selectedRace = new StringBuilder(consoleInput.next());

            for (Race r: Race.values()) {

                if (selectedRace.toString().toUpperCase().equals(r.toString())) {

                    System.out.println("You successfully selected you race, which is " + r);
                    success = true;
                }
            }
        }

        success = false;

        while (!success){

            System.out.println("When you grew up, you decided to travel the world. You first destination is...");
            for (Country c: Country.values()) {

                System.out.println(c.ordinal() + 1 + " " + c);
            }

            StringBuilder selectedCountry = new StringBuilder(consoleInput.next());

            for (Country c: Country.values()) {

                if (selectedCountry.toString().toUpperCase().equals(c.toString())) {

                    System.out.println("Now you are in " + c);
                    success = true;
                }
            }
        }
    }
}
