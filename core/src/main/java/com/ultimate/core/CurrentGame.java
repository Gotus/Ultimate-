package com.ultimate.core;


import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.states.*;
import javafx.util.Pair;

import java.awt.*;
import java.io.IOException;

public class CurrentGame {

    private IState currentState;

    private GameData gameData;

    public CurrentGame() {

        //currentState = new MapState(gameData.getWorld(), gameData.getPlayCharacter());
        //nothing changed
        //nothing changed
        //nothing changed
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
                        //from battle to map
                        this.currentState = new MapState(gameData.getWorld(), player);
                        break;
                    case MENU_STATE:
                        //from battle to menu
                        MenuState nextState = new MenuState();
                        try {

                            nextState.exitWithSaving(true, player, gameData.getWorld());
                        } catch (IOException exception) {

                            exception.printStackTrace();
                        } catch (ClassNotFoundException exception) {

                            exception.printStackTrace();
                        }
                        break;

                }
                break;

            case MAP_STATE:
                switch (newState) {

                    case BATTLE_STATE:
                        //from map to battle
                        this.currentState = new BattleState(null, gameData.getPlayCharacter());
                        break;
                    case MENU_STATE:
                        //from map to menu
                        MenuState nextState = new MenuState();
                        try {

                            nextState.exitWithSaving(true, player, gameData.getWorld());
                        } catch (IOException exception) {

                            exception.printStackTrace();
                        } catch (ClassNotFoundException exception) {

                            exception.printStackTrace();
                        }
                        break;
                }
                break;

            case MENU_STATE:
                switch (newState) {

                    case MAP_STATE:
                        //from menu to map
                        //generate or load world
                        MenuState nextState = new MenuState();
                        try {

                            gameData = nextState.startGame(gameData.getPlayCharacter().getName(), gameData.getWorld().getName());
                        } catch (IOException exception) {

                            exception.printStackTrace();
                        } catch (ClassNotFoundException exception) {

                            exception.printStackTrace();
                        }
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
