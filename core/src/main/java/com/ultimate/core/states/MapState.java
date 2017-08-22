package com.ultimate.core.states;


import com.ultimate.core.gameObjects.Location;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;
import javafx.util.Pair;

public class MapState implements IState{

    World location;
    PlayCharacter character;

    public MapState(World location, PlayCharacter character) {

        this.location = location;
        this.character = character;
    }

    public GameState getState() {

        return GameState.MAP_STATE;
    }

    public Pair<String, GameState> handleCommand(String command) {

        return new Pair<>("TODO", GameState.MAP_STATE);//TODO write a body
    }

}
