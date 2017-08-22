package com.ultimate.core.states;

import com.ultimate.core.gameObjects.Enemy;
import com.ultimate.core.gameObjects.PlayCharacter;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;


public class BattleState implements IState {

    List<Enemy> enemies;
    PlayCharacter character;


    public BattleState(ArrayList<Enemy> enemies, PlayCharacter character) {

        this.enemies = enemies;
        this.character = character;
    }

    public boolean attack(int id) {

        character.attackEnemy(enemies.get(id));

        return enemies.isEmpty();
    }

    public GameState getState() {

        return GameState.BATTLE_STATE;
    }

    public Pair<String, GameState> handleCommand(String... command) {

        if (command.length == 0) {

            return new Pair<>("Command not inputed", GameState.MAP_STATE);
        }

        if (command[0].equalsIgnoreCase("attack")) {

            if (command.length < 2) {

                return new Pair<>("Enemy id is not inputed", GameState.BATTLE_STATE);
            }

            command[1] = command[1].replaceAll("[^\\d]", "");

            if (command[1].equalsIgnoreCase("")) {

                return new Pair<>("The second argument must be number", GameState.MAP_STATE);
            }

            if (attack(Integer.valueOf(command[1]))) {

                return new Pair<>("Victory!", GameState.MAP_STATE);
            }

            return new Pair<>(character.getName() + " " + enemies.get(Integer.valueOf(command[1])).getName() + " " + character.getDamage(), GameState.BATTLE_STATE);
        }

        if (command[0].equalsIgnoreCase("quit")) {

            System.exit(0);
        }
        return null;
    }
}
