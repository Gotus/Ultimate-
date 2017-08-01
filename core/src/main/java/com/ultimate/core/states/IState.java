package com.ultimate.core.states;


import javafx.util.Pair;
import org.mortbay.util.ajax.JSON;

public interface IState {

    Pair<String, GameState> handleCommand(String commandJSON);

    GameState getState();

    void exit();
}
