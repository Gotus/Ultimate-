package com.ultimate.core;


import com.ultimate.core.gameObjects.*;

public class GameData {
    PlayCharacter playCharacter;
    Location location;

    public GameData(LocationSize locationSize, LocationType locationType) {
        location = new Location(locationSize, locationType);
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
