package com.ultimate.core.states;

import com.ultimate.core.gameObjects.Map;
import com.ultimate.core.gameObjects.PlayCharacter;
import javafx.util.Pair;


public class WorldMapState implements IState{

    Map map;
    PlayCharacter character;

    public WorldMapState(Map map, PlayCharacter character) {

        this.map = map;
        this.character = character;
    }

    public boolean move(int dx, int dy) {

        character.setCurrentLocation(character.getX() + dx, character.getY() + dy);
        return (Math.random() < 0.3);
    }

    public GameState getState() {

        return GameState.WORLD_MAP_STATE;
    }

    public void exit() {

        System.exit(0);
    }

    public Pair<String, GameState> handleCommand(String... command) {

        if (command.length == 0) {

            return new Pair<>("Command not inputed", GameState.WORLD_MAP_STATE);
        }

        if (command[0].equalsIgnoreCase("move")) {

            if (command.length < 3) {

                return new Pair<>("Not enough arguments", GameState.WORLD_MAP_STATE);
            }

            command[1] = command[1].replaceAll("[^\\d]", "");
            command[2] = command[2].replaceAll("[^\\d]", "");

            if ((command[1].equalsIgnoreCase("")) || (command[2].equalsIgnoreCase(""))) {

                return new Pair<>("The second and the third arguments must be numbers", GameState.WORLD_MAP_STATE);
            }

            move(Integer.valueOf(command[1]), Integer.valueOf(command[2]));

            if (Math.random() < 0.3) {

                return new Pair<>("Battle begins!", GameState.BATTLE_STATE);
            }

            return new Pair<>("Battle begins!", GameState.WORLD_MAP_STATE);
        }

        return null;
    }

}
