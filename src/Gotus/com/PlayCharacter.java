package Gotus.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gotus on 19.07.2017.
 */

enum Stats {

    STRENGTH,
    AGILITY,
    INTELLIGENCE
}

enum Skills {

    POWERSTRIKE,
    POWERDRAW,
    POWERTHROW
}

enum Cities {

    MELMOND,
    PRAVOKA
}

public class PlayCharacter {

    private Race race;
    private String name;
    private int skillPoints;
    private int copySKValue;
    private int statPoints;
    private int copySTValue;
    private HashMap<Skills, Integer> skills;
    private HashMap<Stats, Integer> stats;
    private Cities currentCity;
    int currentLocation;
    private int x;
    private int y;
    private int attack;
    private int hp;
    private Enemy enemy;

    PlayCharacter() {

        race = null;
        name = null;
        currentCity = null;
        skillPoints = 10;
        copySKValue = skillPoints;
        statPoints = 10;
        copySTValue = statPoints;
        stats = new HashMap<Stats, Integer>();
        skills = new HashMap<Skills, Integer>();
        x = 0;
        y = 0;
        currentLocation = 0;
        hp = 50;
        enemy = null;
        attack = 3;
    }

    public int increaseStat(Stats stat, int value) {

        if (!(stats.containsKey(stat) && (value <= statPoints) && (value > 0))) {

            throw new IllegalArgumentException();
        }
        int oldValue = stats.get(stat);
        statPoints -= value;
        stats.put(stat, oldValue + value);
        return stats.get(stat);
    }

    public int increaseSkill(Skills skill, int value) {

        if ((skills.containsKey(skill) && (value <= skillPoints) && (value > 0))) {

            throw new IllegalArgumentException();
        }
        int oldValue = skills.get(skill);
        skillPoints -= value;
        skills.put(skill, oldValue + value);
        return skills.get(skill);
    }

    public void resetSkills(){

        if (copySKValue == 0) {

            return;
        }

        skillPoints = copySKValue;
        for (Map.Entry<Skills, Integer> entry: skills.entrySet()) {

            skills.put(entry.getKey(), 1);
        }
    }

    public void resetStats() {

        if (copySTValue == 0) {

            return;
        }

        statPoints = copySTValue;
        for (Map.Entry<Stats, Integer> entry: stats.entrySet()) {

            stats.put(entry.getKey(), 1);
        }
    }

    public void addStat(Stats stat) {

        stats.put(stat, 1);
    }


    public void addSkill(Skills skill) {

        skills.put(skill, 1);
    }

    public void acceptSkills() {

        copySKValue = 0;
    }

    public void acceptStats() {

        copySTValue = 0;
    }

    public int addSkillPoints(int value) {

        skillPoints = value;
        copySKValue = value;
        return value;
    }

    public int addStatPoints(int value) {

        statPoints = value;
        copySTValue = value;
        return value;
    }

    public Race setRace(Race race) {

        for (Race r: Race.values()) {

            if (race.equals(r)) {

                this.race = r;
                return r;
            }
        }

        return null;
    }

    public String setName(String newName) {

        name = newName;
        return name;
    }

    public int getSkillPoints() {

        return skillPoints;
    }

    public int getStatPoints() {

        return statPoints;
    }

    public int getStatValue(Stats name) {

        if (!stats.containsKey(name)) {

            throw new IllegalArgumentException();
        }
        return  stats.get(name);
    }

    public int getSkillValue(Skills name) {

        if (skills.containsKey(name)) {

            throw new IllegalArgumentException();
        }

        return  skills.get(name);
    }

    public Race getRace() {

        return this.race;
    }

    public void setCity() {

        switch (this.race) {

            case ELF:
                this.currentCity = Cities.MELMOND;
                break;
            case HUMAN:
                this.currentCity = Cities.PRAVOKA;
                break;
        }
    }

    public Cities getCurrentCity() {

        return this.currentCity;
    }

    public void setX(int value){

        this.x = value;
    }

    public void setY(int value) {

        this.y = value;
    }

    public int getX() {

        return this.x;
    }

    public int getY() {

        return this.y;
    }

    public int getCurrentLocation () {

        return this.currentLocation;
    }

    public void setCurrentLocation(int value) {

        this.currentLocation = value;
    }

    public void setHp(int value) {

        this.hp = value;
    }

    public int getHp() {

        return this.hp;
    }

    public void attackEnemy(Enemy enemy) {

        int damage = this.attack;
        int newHp = enemy.getHp() - damage;
        enemy.setHp(newHp);
    }

    public Enemy getEnemy() {

        return  this.enemy;
    }

    public void setEnemy(Enemy enemy) {

        this.enemy = enemy;
    }

}
