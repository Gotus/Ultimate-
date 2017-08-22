package com.ultimate.core.states;


import javafx.util.Pair;

public class MenuState implements IState {

    public Pair<String, GameState> handleCommand(String command) {

        return new Pair<>("TODO", GameState.BATTLE_STATE);//TODO write a body
    }

    public GameState getState() {

        return GameState.MENU_STATE;
    }
}
