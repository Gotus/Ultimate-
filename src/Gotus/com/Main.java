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
        int intelligence = 3;
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
                    break;
                case "AGI UP":
                    statpoints -= 1;
                    agility += 1;
                    break;
                case "STA UP":
                    statpoints -= 1;
                    stamina += 1;
                    break;
                case "CHA UP":
                    statpoints -= 1;
                    charisma += 1;
                    break;
                case "INT UP":
                    statpoints -= 1;
                    intelligence += 1;
                    break;

                case "RESET STATS":
                    System.out.println("Are you sure?");
                    if (consoleInput.next().toUpperCase().equals("YES")) {

                        statpoints = 10;
                        strength = 3;
                        agility = 3;
                        stamina = 3;
                        charisma = 3;
                        intelligence = 3;
                        System.out.println("All your stats reduced to 3. You have " + statpoints + " STATPOINTS");
                    }
                    break;
            }
        }

        command = new StringBuilder();
        int skillpoints = 50;
        int powerStrike = 0;
        int armorCrush = 0;
        int powerDraw = 0;
        int powerThrow = 0;
        int shield = 0;
        int twinWeapon = 0;
        int twinShield = 0;
        int knuckles = 0;
        int backstab = 0;
        int stealth = 0;
        int dodge = 0;
        int rapidStrike = 0;
        int confidentStand = 0;
        int ironFlesh = 0;
        int attackSpells = 0;
        int buffSpells = 0;
        int debuffSpells = 0;
        int guesstination = 0;
        int craftKnowledge = 0;
        int firstAid = 0;
        int engineer = 0;
        int persuasion = 0;
        int trade = 0;
        int cracking = 0;
        int riding = 0;
        while (!command.toString().equals("ACCEPT")) {

            command = new StringBuilder(consoleInput.nextLine().toUpperCase());
            if ((skillpoints == 0) && (!command.toString().equals("ACCEPT"))) {

                System.out.println("You have not skillpoints");
                continue;
            }

            switch (command.toString())
            {
                case "PS UP":
                    skillpoints -= 1;
                    powerStrike += 1;
                    System.out.println("Your POWER STRIKE: " + powerStrike);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "AC UP":
                    skillpoints -= 1;
                    armorCrush += 1;
                    System.out.println("Your ARMOR CRUSH: " + armorCrush);
                    System.out.println("Your STATPOINTS: " + skillpoints);
                    break;
                case "PD UP":
                    skillpoints -= 1;
                    powerDraw += 1;
                    System.out.println("Your POWER DRAW: " + powerDraw);
                    System.out.println("Your STATPOINTS: " + skillpoints);
                    break;
                case "PT UP":
                    skillpoints -= 1;
                    powerThrow += 1;
                    System.out.println("Your SPOWER THROW: " + powerThrow);
                    System.out.println("Your STATPOINTS: " + skillpoints);
                    break;
                case "SH UP":
                    skillpoints -= 1;
                    shield += 1;
                    System.out.println("Your SHIELD: " + shield);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "TW UP":
                    skillpoints -= 1;
                    twinWeapon += 1;
                    System.out.println("Your TWIN WEAPON: " + twinWeapon);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "TS UP":
                    skillpoints -= 1;
                    twinShield += 1;
                    System.out.println("Your TWIN SHIELD: " + twinShield);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "KN UP":
                    skillpoints -= 1;
                    knuckles += 1;
                    System.out.println("Your KNUCKLES: " + knuckles);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "BS UP":
                    skillpoints -= 1;
                    backstab += 1;
                    System.out.println("Your BACKSTAB: " + backstab);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "ST UP":
                    skillpoints -= 1;
                    stealth += 1;
                    System.out.println("Your STEALTH: " + stealth);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "DO UP":
                    skillpoints -= 1;
                    dodge += 1;
                    System.out.println("Your DODGE: " + dodge);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "RS UP":
                    skillpoints -= 1;
                    rapidStrike += 1;
                    System.out.println("Your RAPIDSTRIKE: " + rapidStrike);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "CS UP":
                    skillpoints -= 1;
                    confidentStand += 1;
                    System.out.println("Your CONFIDENT STAND: " + confidentStand);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "IF UP":
                    skillpoints -= 1;
                    ironFlesh += 1;
                    System.out.println("Your IRON FLESH: " + ironFlesh);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "ASP UP":
                    skillpoints -= 1;
                    attackSpells += 1;
                    System.out.println("Your ATTACK SPELLS: " + attackSpells);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "BSP UP":
                    skillpoints -= 1;
                    buffSpells += 1;
                    System.out.println("Your BUFF SPELLS: " + buffSpells);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "DBS UP":
                    skillpoints -= 1;
                    debuffSpells += 1;
                    System.out.println("Your DEBUFF SPELLS: " + debuffSpells);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "GT UP":
                    skillpoints -= 1;
                    guesstination += 1;
                    System.out.println("Your GUESSTINATION: " + guesstination);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "CK UP":
                    skillpoints -= 1;
                    craftKnowledge += 1;
                    System.out.println("Your CRAFT KNOLEDGE: " + craftKnowledge);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "FA UP":
                    skillpoints -= 1;
                    firstAid += 1;
                    System.out.println("Your FIRST AID: " + firstAid);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "EN UP":
                    skillpoints -= 1;
                    engineer += 1;
                    System.out.println("Your ENGINEER: " + engineer);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "PE UP":
                    skillpoints -= 1;
                    persuasion += 1;
                    System.out.println("Your PERSUASION: " + persuasion);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "TR UP":
                    skillpoints -= 1;
                    trade += 1;
                    System.out.println("Your TRADE: " + trade);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "CR UP":
                    skillpoints -= 1;
                    cracking += 1;
                    System.out.println("Your CRACKING: " + cracking);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;
                case "RI UP":
                    skillpoints -= 1;
                    riding += 1;
                    System.out.println("Your RIDING: " + riding);
                    System.out.println("Your SKILLPOINTS: " + skillpoints);
                    break;

                case "RESET SKILLS":
                    System.out.println("Are you sure?");
                    if (consoleInput.next().toUpperCase().equals("YES")) {

                        skillpoints = 50;
                        powerStrike = 0;
                        armorCrush = 0;
                        powerDraw = 0;
                        powerThrow = 0;
                        shield = 0;
                        twinWeapon = 0;
                        twinShield = 0;
                        knuckles = 0;
                        backstab = 0;
                        stealth = 0;
                        dodge = 0;
                        rapidStrike = 0;
                        confidentStand = 0;
                        ironFlesh = 0;
                        attackSpells = 0;
                        buffSpells = 0;
                        debuffSpells = 0;
                        guesstination = 0;
                        craftKnowledge = 0;
                        firstAid = 0;
                        engineer = 0;
                        persuasion = 0;
                        trade = 0;
                        cracking = 0;
                        riding = 0;
                        System.out.println("All your stats reduced to 0. You have " + skillpoints + " SKILLPOINTS");
                    }
                    break;
            }
        }

    }
}
