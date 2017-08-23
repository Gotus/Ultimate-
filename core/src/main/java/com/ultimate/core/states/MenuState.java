package com.ultimate.core.states;


import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ultimate.core.gameObjects.PlayCharacter;
import javafx.util.Pair;

public class MenuState implements IState {

    public Pair<String, GameState> handleCommand(String command) {

        return new Pair<>("TODO", GameState.BATTLE_STATE);//TODO write a body
    }

    public Boolean createNewCharacter(PlayCharacter.Race race, String name) {

        PlayCharacter newCharacter = new PlayCharacter(name, race);
        return true;
    }

    public GameState getState() {

        return GameState.MENU_STATE;
    }
}
