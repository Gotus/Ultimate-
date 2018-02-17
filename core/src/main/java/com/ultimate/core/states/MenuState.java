package com.ultimate.core.states;


import com.ultimate.core.GameData;
import com.ultimate.core.gameObjects.LocationSize;
import com.ultimate.core.gameObjects.PlayCharacter;
import com.ultimate.core.gameObjects.World;
import javafx.util.Pair;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.FileHandler;

public class MenuState implements IState {

    public Pair<String, GameState> handleCommand(String command) {

        String[] commandAndAttributes = command.split(" ");
        String commandResult;
        switch (commandAndAttributes[0]) {

            case "createNewCharacter":
                if (commandAndAttributes.length != 3) {

                    commandResult = new String("Wrong number of arguments!");
                    return new Pair<>(commandResult, GameState.MENU_STATE);
                }

                if (commandAndAttributes[1].equalsIgnoreCase("elf") ||
                        commandAndAttributes[1].equalsIgnoreCase("dwarf") ||
                        commandAndAttributes[1].equalsIgnoreCase("human")) {

                    boolean successCreation = false;

                    if (commandAndAttributes[1].equalsIgnoreCase("elf")) {

                        successCreation = createNewCharacter(PlayCharacter.Race.ELF, commandAndAttributes[2]);

                    } else if (commandAndAttributes[1].equalsIgnoreCase("dwarf")) {

                        successCreation = createNewCharacter(PlayCharacter.Race.DWARF, commandAndAttributes[2]);

                    } else if (commandAndAttributes[1].equalsIgnoreCase("human")) {

                        successCreation = createNewCharacter(PlayCharacter.Race.HUMAN, commandAndAttributes[2]);
                    }

                    if (successCreation) {

                        commandResult = new String("Character was successfully created. Race: " + commandAndAttributes[1] +
                                " Name: " + commandAndAttributes[2]);


                    } else {

                        commandResult = new String("Character was not successfully created.");

                    }

                    return new Pair<>(commandResult, GameState.MENU_STATE);

                } else {

                    commandResult = new String("Wrong race was selected!");
                    return new Pair<>(commandResult, GameState.MENU_STATE);
                }

            case "startGame":

                if (commandAndAttributes.length != 3) {

                    commandResult = new String("Wrong number of arguments!");
                    return new Pair<>(commandResult, GameState.MENU_STATE);
                }

                try {

                    GameData newGameData = startGame(commandAndAttributes[1], commandAndAttributes[2]);
                    return new Pair<>(newGameData.toString(), GameState.MAP_STATE);
                }
                catch (IOException e) {

                    return new Pair<>("IOException MenuState startGane", GameState.MENU_STATE);
                }
                catch (ClassNotFoundException e) {

                    return new Pair<>("ClassNotFoundException MenuState startGane", GameState.MENU_STATE);
                }

            case "createNewWorld":

                if (commandAndAttributes.length != 3) {

                    commandResult = new String("Wrong number of arguments!");
                    return new Pair<>(commandResult, GameState.MENU_STATE);
                }

                if (commandAndAttributes[1].equalsIgnoreCase("small") ||
                        commandAndAttributes[1].equalsIgnoreCase("average") ||
                        commandAndAttributes[1].equalsIgnoreCase("large")) {

                    if (commandAndAttributes[1].equalsIgnoreCase("small")) {

                        createNewWorld(LocationSize.SMALL, commandAndAttributes[2]);

                    } else if (commandAndAttributes[1].equalsIgnoreCase("average")) {

                        createNewWorld(LocationSize.AVERAGE, commandAndAttributes[2]);

                    } else if (commandAndAttributes[1].equalsIgnoreCase("large")) {

                        createNewWorld(LocationSize.LARGE, commandAndAttributes[2]);
                    }

                    commandResult = new String("World was successfully created. Size: " + commandAndAttributes[1] +
                            " Name: " + commandAndAttributes[2]);
                    return new Pair<>(commandResult, GameState.MENU_STATE);

                } else {

                    commandResult = new String("Wrong world size was selected!");
                    return new Pair<>(commandResult, GameState.MENU_STATE);
                }

        }
        return new Pair<>("Command not found!", GameState.MENU_STATE);//TODO write a body
    }

    public Boolean createNewCharacter(PlayCharacter.Race race, String name) {


        String dirPath = "/saves";
        Path path = Paths.get(dirPath);

        if (Files.exists(path)) {

            //folder exists
            File file = new File(dirPath);
            for (String currentPath : file.list()) {

                if (currentPath.contains("/" + name + ".character")) {

                    return false;
                }

            }

            PlayCharacter newCharacter = new PlayCharacter(name, race);
            try {

                com.ultimate.core.gameObjects.FileHandler.writeObjectToFile(newCharacter, dirPath + "/" + name + ".character");

            } catch (IOException ex) {

                ex.printStackTrace();
            }

        } else {

            PlayCharacter newCharacter = new PlayCharacter(name, race);
            File file = new File(dirPath + "/" + name + ".character");
            file.mkdirs();    //creates /saves folder
            try {

                file.createNewFile(); //creates file with character information
                com.ultimate.core.gameObjects.FileHandler.writeObjectToFile(newCharacter, dirPath + "/" + name + ".character");

            } catch (IOException exception) {

                exception.printStackTrace();
            }

        }

        return true;
    }

    public Boolean createNewWorld(LocationSize size, String name) {


        String dirPath = "/saves";
        Path path = Paths.get(dirPath);

        if (Files.exists(path)) {

            //folder exists
            File file = new File(dirPath);
            for (String currentPath : file.list()) {

                if (currentPath.contains("/" + name + ".world")) {

                    return false;
                }

            }

            World newWorld = new World(size, 116);
            try {

                com.ultimate.core.gameObjects.FileHandler.writeObjectToFile(newWorld, dirPath + "/" + name + ".character");

            } catch (IOException ex) {

                ex.printStackTrace();
            }

        } else {

            World newWorld = new World(size, 116);
            File file = new File(dirPath + "/" + name + ".world");
            file.mkdirs();    //creates /saves folder
            try {

                file.createNewFile(); //creates file with character information
                com.ultimate.core.gameObjects.FileHandler.writeObjectToFile(newWorld, dirPath + "/" + name + ".world");

            } catch (IOException exception) {

                exception.printStackTrace();
            }

        }

        return true;
    }

    public GameData startGame(String charName, String worldName) throws IOException, ClassNotFoundException {

        PlayCharacter character;
        World world;

        character = (PlayCharacter) com.ultimate.core.gameObjects.FileHandler.readObjectFromFile("/saves/" + charName + ".character");
        world = (World)com.ultimate.core.gameObjects.FileHandler.readObjectFromFile("/saves/" + worldName + ".world");
        return new GameData(character, world);

    }

    public void exitWithSaving(Boolean closeAfterSaving, PlayCharacter character, World world)
            throws IOException, ClassNotFoundException
    {

        if (closeAfterSaving) {

            com.ultimate.core.gameObjects.FileHandler.writeObjectToFile(world, "/saves/" + world.getName() + ".world");
            com.ultimate.core.gameObjects.FileHandler.writeObjectToFile(character, "/saves/" + character.getName() + ".character");
        }

        System.exit(0);
    }

    public GameState getState() {

        return GameState.MENU_STATE;
    }
}
