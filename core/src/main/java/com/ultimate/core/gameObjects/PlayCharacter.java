package com.ultimate.core.gameObjects;


public class PlayCharacter {

    public enum Race {

        ELF,
        HUMAN,
        DWARF
    }

    private Race race;
    private String name;

    private int hp;
    public int damage;

    public PlayCharacter(String name, Race race) {

        this.name = name;
        this.race = race;
        hp = 50;
        damage = 3;
    }

    public void setRace(Race race) {

        this.race = race;
    }

    public void setName(String newName) {

        name = newName;
    }

    public Race getRace() {

        return race;
    }

    public void setHp(int value) {

        hp = value;
    }

    public int getHp() {

        return hp;
    }

    public void attackEnemy(Enemy enemy) {//TODO move to battle

        enemy.receiveDamage(damage);
    }

    public String getName() {

        return name;
    }

    public int getDamage() {

        return damage;
    }
}
