package com.ultimate.core.gameObjects;


public class Enemy {

    int id;
    String name;
    int hp;
    int damage;

    public Enemy(String name, int hp, int damage, int id) {

        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.id = id;
    }

    public void setDamage(int value) {

        damage = value;
    }

    public int getDamage(){

        return damage;
    }

    public int getHp() {

        return hp;
    }

    public void setHp(int value) {

        hp = value;
    }

    public void attack(PlayCharacter character)//TODO move to battle
    {

        int newHp = character.getHp() - damage;
        character.setHp(newHp);
    }

    public String getName() {

        return name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
}
