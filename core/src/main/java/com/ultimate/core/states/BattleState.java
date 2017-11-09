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

        enemies.get(id).receiveDamage(character.getDamage());

        if (enemies.get(id).getHp() <= 0) {

            enemies.remove(id);
        }

        return enemies.isEmpty();
    }

    public GameState getState() {

        return GameState.BATTLE_STATE;
    }

    public Pair<String, GameState> handleCommand(String command) {

        return new Pair<>("TODO", GameState.BATTLE_STATE);//TODO write a body
    }
}
