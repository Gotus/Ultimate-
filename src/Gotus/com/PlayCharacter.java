package Gotus.com;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gotus on 19.07.2017.
 */
public class PlayCharacter {

    private Race race;
    private String name;
    private int skillPoints;
    private int copySKValue;
    private int statPoints;
    private int copySTValue;
    private HashMap<String, Integer> skills;
    private HashMap<String, Integer> stats;

    PlayCharacter() {

        race = null;
        name = null;
        skillPoints = 10;
        copySKValue = skillPoints;
        statPoints = 10;
        copySTValue = statPoints;
        stats = new HashMap<String, Integer>();
        skills = new HashMap<String, Integer>();

        stats.put("STR", 1);
        stats.put("AGI", 1);
        stats.put("STA", 1);
        stats.put("CHA", 1);
        stats.put("INT", 1);

        skills.put("PS", 1);
        skills.put("AC", 1);
        skills.put("PD", 1);
        skills.put("PT", 1);
        skills.put("SH", 1);

    }

    int increaseStat(String statName, int value) {

        if (stats.containsKey(statName) && (value <= statPoints) && (value > 0)) {

            int oldValue = stats.get(statName);
            statPoints -= value;
            stats.put(statName, oldValue + value);
            return stats.get(statName);
        }
        return -1;
    }

    int increaseSkill(String skillName, int value) {

        if (skills.containsKey(skillName) && (value <= skillPoints) && (value > 0)) {

            int oldValue = skills.get(skillName);
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


    void addSkill(String statName) {

        skills.put(statName, 1);
    }

    void acceptSkills() {

        copySKValue = 0;
    }

    void acceptStats() {

        copySTValue = 0;
    }

    int addSkillPoints(int value) {

        skillPoints = value;
        copySKValue = value;
        return value;
    }

    int addStatPoints(int value) {

        statPoints = value;
        copySTValue = value;
        return value;
    }

    Race setRace(Race race) {

        for (Race r: Race.values()) {

            if (race.equals(r)) {

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

    int getSkillPoints() {

        return skillPoints;
    }

    int getStatPoints() {

        return statPoints;
    }

    int getStatValue(String name) {

        if (stats.containsKey(name)) {

            return  stats.get(name);
        }

        return -1;
    }

    int getSkillValue(String name) {

        if (skills.containsKey(name)) {

            return  skills.get(name);
        }

        return -1;
    }
}
