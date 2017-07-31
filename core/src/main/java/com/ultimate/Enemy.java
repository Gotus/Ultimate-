package com.ultimate;

/**
 * Created by Gotus on 26.07.2017.
 */
public class Enemy {

    int number;
    String name;
    int hp;
    int attack;

    Enemy(String name, int hp, int attack, int number)
    {

        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.number = number;
    }

    public void setAttack(int value) {

        this.attack = value;
    }

    public int getAttack(){

        return this.attack;
    }

    public int getHp() {

        return this.hp;
    }

    public void setHp(int value) {

        this.hp = value;
    }

    public void attack(PlayCharacter character)
    {
        int damage = this.attack;
        int newHp = character.getHp() - damage;
        character.setHp(newHp);
    }

    public String getName() {

        return this.name;
    }

    public int getNumber() {

        return this.number;
    }

    public void setNumber(int number) {

        this.number = number;
    }
}
