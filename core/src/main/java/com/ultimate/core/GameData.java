package com.ultimate.core;


import com.ultimate.core.gameObjects.*;

public class GameData {

    PlayCharacter playCharacter;
    World world;

    public GameData(PlayCharacter character, World world) {

        this.playCharacter = character;
        this.world = world;
    }

    public World getWorld() {
        return world;
    }

    public PlayCharacter getPlayCharacter(){
        return playCharacter;
    }
}
