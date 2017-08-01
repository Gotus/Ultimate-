package com.ultimate.core.gameObjects;

import java.util.ArrayList;
import java.util.List;

public class Battle {

    private List<Enemy> enemies = new ArrayList<Enemy>();

    public void addEnemy(Enemy newEnemy) {

        enemies.add(newEnemy);
    }

    public void checkEnemy() {

        for (Enemy enemy : enemies) {

            if (enemy.getHp() <= 0) {

                enemies.remove(enemy);
            }
        }
    }

    public List<Enemy> getEnemies() {

        return enemies;
    }

    public Enemy getEnemy(int index) {


        if ((index >= 0) && (index < enemies.size())) {

            return enemies.get(index);
        }
        else {
            return null;
        }
    }

    public void printEnemies() {

        int i = 1;
        for (Enemy enemy : enemies) {

            System.out.println(i++ + " " + enemy.getName());
        }
    }
}
