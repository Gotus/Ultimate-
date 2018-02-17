package com.ultimate.core.gameObjects;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class PlayCharacter implements Serializable {

    private static final long serialVersionUID = 4246087279456497129L;

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

    public String getName() {

        return name;
    }

    public int getDamage() {

        return damage;
    }

    public String toJSON() {

        ObjectMapper mapper = new ObjectMapper();
        try {

            String jsonPlayerString = mapper.writeValueAsString(this);
            return jsonPlayerString;

        } catch (JsonProcessingException e) {

            String exception = new String("Can't convert player object to JSON!");
            return exception;
        }

    }
}
