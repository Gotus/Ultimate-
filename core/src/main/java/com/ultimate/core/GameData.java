package com.ultimate.core;


import com.ultimate.core.gameObjects.*;

public class GameData {

    PlayCharacter playCharacter;
    Location location;

    public GameData(PlayCharacter character, Location location) {

        this.playCharacter = character;
        this.location = location;

    }

    public Location getLocation() {
        return location;
    }

    public PlayCharacter getPlayCharacter(){
        return playCharacter;
    }

    public void setPlayCharacter(PlayCharacter newCharacter) {

        playCharacter = newCharacter;
    }
}
