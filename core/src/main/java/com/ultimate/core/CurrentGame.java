package com.ultimate.core;


import com.ultimate.core.states.*;
import org.mortbay.util.ajax.JSON;

public class CurrentGame {

    private IState currentState;

    GameData gameData;

    JSON handleCommand(JSON commandJSON){
        //TODO write a body
        return new JSON();
    }

    GameState getCurrentState() {
        return currentState.getState();
    }
}
