package com.ultimate.core.states;


import com.ultimate.core.gameObjects.Location;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;
import javafx.util.Pair;

import java.util.ArrayList;

public class MapState implements IState{

    World currentWorld;
    PlayCharacter character;

    public MapState(World location, PlayCharacter character) {

        this.currentWorld = location;
        this.character = character;
    }

    public GameState getState() {

        return GameState.MAP_STATE;
    }

    public Pair<String, GameState> handleCommand(String command) {

        return new Pair<>("TODO", GameState.MAP_STATE);//TODO write a body
    }

    Boolean moveToNode(String nodeName) {

        ArrayList<Location> allLoctions = currentWorld.getLocations();
        for (int i = 0; i < allLoctions.size(); i++) {

            if (nodeName.equalsIgnoreCase(allLoctions.get(i).getName())) {
                //if pain == life then
                currentWorld.getCharactersPositions().put(character, new World.CharacterPosition(allLoctions.get(i), allLoctions.get(i).getMap().getStartNode()));
                return true;
            }
        }
        return false;
    }
}
