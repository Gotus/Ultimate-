package com.ultimate.core.states;


import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ultimate.core.CurrentGame;
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

        return new Pair<>("TODO", GameState.BATTLE_STATE);//TODO write a body
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

    public GameData startGame(String charName, String worlName) throws IOException, ClassNotFoundException {

        PlayCharacter character;
        World world;

        character = (PlayCharacter) com.ultimate.core.gameObjects.FileHandler.readObjectFromFile("/saves/" + charName + ".character");
        world = (World)com.ultimate.core.gameObjects.FileHandler.readObjectFromFile("/saves/" + worlName + ".world");
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
