package com.ultimate.core;


import com.ultimate.core.states.*;
import javafx.util.Pair;

public class CurrentGame {

    private IState currentState;

    private GameData gameData;

    public CurrentGame() {

        //currentState = new MapState(gameData.getWorld(), gameData.getPlayCharacter());
    }

    public String handleCommand(String command){
        
        //TODO write a body
        Pair<String, GameState> commandResult = new Pair<>(currentState.handleCommand(command).getKey(),
                currentState.handleCommand(command).getValue());

        return commandResult.getKey();
    }

    GameState getCurrentState() {

        return currentState.getState();
    }

    public  GameData getGameData() {

        return gameData;
    }
}
