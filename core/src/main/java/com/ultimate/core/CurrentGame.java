package com.ultimate.core;


import com.ultimate.core.gameObjects.Location;
import com.ultimate.core.gameObjects.LocationSize;
import com.ultimate.core.gameObjects.LocationType;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.states.*;
import javafx.util.Pair;

public class CurrentGame {

    private IState currentState;

    private GameData gameData;

    public CurrentGame() {

        gameData = new GameData(new PlayCharacter("I am", PlayCharacter.Race.HUMAN), new Location(LocationSize.AVERAGE, LocationType.WORLD, 42));
        currentState = new LocationState(gameData.getLocation(), gameData.getPlayCharacter());

    }

    public String handleCommand(String command){
        //TODO write a body
        String[] parsedCommand = command.split(" ");
        Pair<String, GameState> commandResult = currentState.handleCommand(parsedCommand);
        GameState newState;
        newState = commandResult.getValue();
        switch (this.currentState.getState()) {

            case BATTLE_STATE:
                switch (newState) {

                    case WORLD_MAP_STATE:
                        this.currentState = new LocationState(gameData.getLocation(), gameData.getPlayCharacter());
                        break;
                    case MENU_STATE:
                        break;

                }
                break;

            case WORLD_MAP_STATE:
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

                    case WORLD_MAP_STATE:
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
