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

    PlayCharacter getPlayCharacter(){
        return playCharacter;
    }
}
