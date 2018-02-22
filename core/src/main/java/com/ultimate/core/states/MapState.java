package com.ultimate.core.states;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.ultimate.core.gameObjects.Location;
import com.ultimate.core.gameObjects.Map;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class MapState implements IState{

    public enum Direction {

        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    World currentWorld;
    PlayCharacter character;

    public MapState(World location, PlayCharacter character) {

        this.currentWorld = location;
        this.character = character;
    }

    public GameState getState() {

        return GameState.MAP_STATE;
    }

    public Pair<String, GameState> handleCommand(String JSONcommandString) {

        ObjectMapper mapper = new ObjectMapper();

        String command = "";
        String commandResult;
        try {

            command = mapper.readValue(JSONcommandString, String.class);

        } catch (IOException exception) {

            commandResult = new String("Command was not successfully parsed.");
            return new Pair<>(commandResult, GameState.MAP_STATE);
        }
        String[] commandAndAttributes = command.split(" ");

        switch (commandAndAttributes[0]) {

            case "moveToNode":

                if (commandAndAttributes.length != 2) {

                    commandResult = new String("Wrong number of arguments!");
                    return new Pair<>(commandResult, GameState.MAP_STATE);
                }

                if ( moveToNode(commandAndAttributes[1]) ) {

                    command = new String("Successfully moved to " + commandAndAttributes[1]);

                } else {

                    command = new String("Node not found!");
                }

                return new Pair<>(command, GameState.MAP_STATE);
        }

        return new Pair<>("TODO", GameState.MAP_STATE);//TODO write a body
    }

    //Move character from current node of current location to other node of current location
    Boolean moveToNode(String nodeName) {

        ArrayList<Map.MapNode> allNodes = currentWorld.getCharactersPositions().get(character).getLocation().getMap().getMapNodes();
        Location currentLocation = currentWorld.getCharactersPositions().get(character).getLocation();
        World.CharacterPosition currentPosition  = currentWorld.getCharactersPositions().get(character);

        for (int i = 0; i < allNodes.size(); i++) {

            if (allNodes.get(i).getName().equalsIgnoreCase(nodeName)) {
                //if pain == life then
                currentWorld.getCharactersPositions().put(character, new World.CharacterPosition(currentLocation,
                        allNodes.get(i), allNodes.get(i).getX(),allNodes.get(i).getY()));
                return true;
            }
        }
        return false;
    }

    Boolean moveInDirection(Direction direction) {

        World.CharacterPosition currentPosition  = currentWorld.getCharactersPositions().get(character);
        Map.MapNode currentNode = currentPosition.getMapNode();
        int currentX = currentNode.getX();
        int currentY = currentNode.getY();
        Map currentMap = currentWorld.getCurrentMap();

        switch (direction) {

            case EAST:
                if (currentX < currentMap.getWidth()) {

                    currentWorld.getCharactersPositions().put(character,
                            new World.CharacterPosition(currentPosition.getLocation(), currentNode, currentX + 1, currentY));
                }
                break;

            case NORTH:
                if (currentY > 0) {

                    currentWorld.getCharactersPositions().put(character,
                            new World.CharacterPosition(currentPosition.getLocation(), currentNode, currentX, currentY - 1));
                }
                break;

            case SOUTH:
                if (currentY < currentMap.getHeight()) {

                    currentWorld.getCharactersPositions().put(character,
                            new World.CharacterPosition(currentPosition.getLocation(), currentNode, currentX, currentY + 1));
                }
                break;

            case WEST:
                if (currentX > 0) {

                    currentWorld.getCharactersPositions().put(character,
                            new World.CharacterPosition(currentPosition.getLocation(), currentNode, currentX - 1, currentY));
                }
                break;
        }

        return false;
    }
}
