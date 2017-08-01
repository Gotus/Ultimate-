package com.ultimate.core.states;


import javafx.util.Pair;
import org.mortbay.util.ajax.JSON;

public interface IState {

    Pair<JSON, GameState> handleCommand(JSON commandJSON);

    GameState getState();

    void exit();
}
