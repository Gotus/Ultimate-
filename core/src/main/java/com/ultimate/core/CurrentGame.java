package com.ultimate.core;


import com.ultimate.core.states.*;

public class CurrentGame {

    private IState currentState;

    private GameData gameData;

    public CurrentGame() {
        gameData = new GameData();
        currentState = new WorldMapState(gameData.getWorld().getMap(), gameData.getPlayCharacter());
    }

    public String handleCommand(String command){
        //TODO write a body
        String[] parsedCommand = command.split(" ");
        currentState.handleCommand(parsedCommand);

        return "";
    }

    GameState getCurrentState() {
        return currentState.getState();
    }

    public  GameData getGameData() {
        return gameData;
    }
}
