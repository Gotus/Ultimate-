package com.ultimate.core;


import com.ultimate.core.states.*;

public class CurrentGame {

    private IState currentState;

    private GameData gameData;

    public CurrentGame() {
        gameData = new GameData();
        currentState = new WorldMapState(gameData.getWorld().getMap(), gameData.getPlayCharacter());
    }

    public String handleCommand(String commandJSON){
        //TODO write a body
        return "";
    }

    public GameState getCurrentState() {
        return currentState.getState();
    }

    public GameData getGameData() {
        return gameData;
    }
}
