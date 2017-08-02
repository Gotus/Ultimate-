package com.ultimate.core;


import com.ultimate.core.states.*;

public class CurrentGame {

    private IState currentState;

    GameData gameData;

    String handleCommand(String commandJSON){
        //TODO write a body
        return "";
    }

    GameState getCurrentState() {
        return currentState.getState();
    }
}
