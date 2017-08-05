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

    public void exit() {

        System.exit(0);
    }

    public Pair<String, GameState> handleCommand(String command) {

        //String
        return null;
    }
}
