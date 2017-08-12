package com.ultimate.core.gameObjects;


public class PlayCharacter {

    public enum Race {

        ELF,
        HUMAN,
        DWARF
    }

    private Race race;
    private String name;

    private int x;
    private int y;

    private int hp;
    public int damage;

    public PlayCharacter() {

        race = null;
        name = null;
        x = 0;
        y = 0;
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

    public void setX(int value){

        x = value;
    }

    public void setY(int value) {

        y = value;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
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
    public void setCurrentLocation(int x, int y) {


    }
}
