package com.ultimate.core;


import com.ultimate.core.gameObjects.*;

public class GameData {
    PlayCharacter playCharacter;
    World world;

    public GameData() {
        world = new World();
    }

    public World getWorld() {
        return world;
    }

    public PlayCharacter getPlayCharacter(){
        return playCharacter;
    }

    public void setPlayCharacter(PlayCharacter newCharacter) {

        playCharacter = newCharacter;
    }
}
