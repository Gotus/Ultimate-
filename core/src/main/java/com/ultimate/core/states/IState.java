package com.ultimate.core.states;


import javafx.util.Pair;

public interface IState {

    Pair<String, GameState> handleCommand(String... command);

    GameState getState();
}
