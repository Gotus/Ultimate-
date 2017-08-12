package com.ultimate.core;


import com.ultimate.core.gameObjects.Location;
import com.ultimate.core.gameObjects.LocationSize;
import com.ultimate.core.gameObjects.LocationType;
import com.ultimate.core.states.*;
import javafx.util.Pair;

public class CurrentGame {

    private IState currentState;

    private GameData gameData;

    public CurrentGame() {
        gameData = new GameData(LocationSize.SMALL, LocationType.WORLD);
        currentState = new LocationState(gameData.getLocation(), gameData.getPlayCharacter());
    }

    public String handleCommand(String command){
        //TODO write a body
        String[] parsedCommand = command.split(" ");
        Pair<String, GameState> commandResult = new Pair<String, GameState>(currentState.handleCommand(parsedCommand).getKey(),
                currentState.handleCommand(parsedCommand).getValue());

        return commandResult.getKey();
    }

    GameState getCurrentState() {
        return currentState.getState();
    }

    public  GameData getGameData() {
        return gameData;
    }
}
