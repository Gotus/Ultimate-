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

class PlayCharacter {

    Race race;
    String name;
    int skillPoints;
    int copySKValue;
    int statPoints;
    int copySTValue;
    HashMap<String, Integer> skills;
    HashMap<String, Integer> stats;

    PlayCharacter() {

        race = null;
        name = null;
        skillPoints = 10;
        copySKValue = skillPoints;
        statPoints = 10;
        copySTValue = statPoints;
        stats = new HashMap<String, Integer>();
        skills = new HashMap<String, Integer>();

        /*stats.put("STR", 1);
        stats.put("AGI", 1);
        stats.put("STA", 1);
        stats.put("CHA", 1);
        stats.put("INT", 1);

        skills.put("PS", 1);
        skills.put("AC", 1);
        skills.put("PD", 1);
        skills.put("PT", 1);
        skills.put("SH", 1);
        */
    }

    Integer increaseStat(String statName, Integer value) {

        if (stats.containsKey(statName) && (value <= statPoints) && (value > 0)) {

            Integer oldValue = stats.get(statName);
            statPoints -= value;
            stats.put(statName, oldValue + value);
            return stats.get(statName);
        }
        return -1;
    }

    Integer increaseSkill(String skillName, Integer value) {

        if (skills.containsKey(skillName) && (value <= skillPoints) && (value > 0)) {

            Integer oldValue = skills.get(skillName);
            skillPoints -= value;
            skills.put(skillName, oldValue + value);
            return skills.get(skillName);
        }
        return -1;
    }

    void resetSkills(){

        if (copySKValue == 0) {

            /*for (Map.Entry<String, Integer> entry: skills.entrySet()) {

                System.out.println(entry.getKey() + " " + entry.getValue());
            }*/
            return;
        }

        skillPoints = copySKValue;
        for (Map.Entry<String, Integer> entry: skills.entrySet()) {

            skills.put(entry.getKey(), 1);
            //System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    void resetStats() {

        if (copySTValue == 0) {

            /*for (Map.Entry<String, Integer> entry: stats.entrySet()) {

                System.out.println(entry.getKey() + " " + entry.getValue());
            }*/
            return;
        }

        statPoints = copySTValue;
        for (Map.Entry<String, Integer> entry: stats.entrySet()) {

            stats.put(entry.getKey(), 1);
        }
    }

    void addStat(String statName) {

        stats.put(statName, 1);
    }

    void acceptSkills() {

        copySKValue = 0;
    }

    void acceptStats() {

        copySTValue = 0;
    }

    Race setRace(String raceName) {

        for (Race r: Race.values()) {

            if (raceName.equalsIgnoreCase(r.toString())) {

                this.race = r;
                return r;
            }
        }

        return null;
    }

    String setName(String newName) {

        name = newName;
        return name;
    }
}

public class Main {

    public static void main(String[] args) {

        PlayCharacter character = new PlayCharacter();
        //System.out.println(character.setName("Gotus"));
        //System.out.println(character.setRace("elf"));
        //System.out.println(character.increaseSkill("PD", 4));
        //character.acceptSkills();
        //character.resetSkills();

        Scanner consoleInput = new Scanner(System.in);
    }
}