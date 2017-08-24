package com.ultimate.core;


import com.ultimate.core.gameObjects.PlayCharacter;
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
        Pair<String, GameState> commandResult = currentState.handleCommand(command);
        GameState newState;
        newState = commandResult.getValue();
        PlayCharacter player = gameData.getPlayCharacter();
        switch (this.currentState.getState()) {

            case BATTLE_STATE:
                switch (newState) {

                    case MAP_STATE:
                        this.currentState = new MapState(gameData.getWorld(), player);
                        break;
                    case MENU_STATE:
                        break;

                }
                break;

            case MAP_STATE:
                switch (newState) {

                    case BATTLE_STATE:
                        //generate enemies
                        this.currentState = new BattleState(null, gameData.getPlayCharacter());
                        break;
                    case MENU_STATE:
                        break;

                }
                break;

            case MENU_STATE:
                switch (newState) {

                    case MAP_STATE:
                        //generate or load world
                        break;

                }
                break;
        }



        return commandResult.getKey();
    }

    GameState getCurrentState() {

        return currentState.getState();
    }

    public  GameData getGameData() {

        return gameData;
    }
}
