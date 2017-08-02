package com.ultimate.core.states;

import com.ultimate.core.gameObjects.Map;
import com.ultimate.core.gameObjects.PlayCharacter;
import javafx.util.Pair;


public class WorldMapState implements IState{

    Map map;
    PlayCharacter character;

    WorldMapState(Map map, PlayCharacter character) {

        this.map = map;
        this.character = character;
    }

    public void move(int dx, int dy) {

        character.setCurrentLocation(character.getX() + dx, character.getY() + dy);
    }

    public GameState getState() {

        return GameState.WORLD_MAP_STATE;
    }

    public void exit() {

        System.exit(0);
    }

    public Pair<String, GameState> handleCommand(String commandJSON) {

        return null;
    }

}
