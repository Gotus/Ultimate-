package Gotus.com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gotus on 28.07.2017.
 */
public class Battle {

    private List<Enemy> enemies = new ArrayList<>();

    public void addEnemy(Enemy newEnemy) {

        this.enemies.add(newEnemy);
    }

    public void checkEnemy() {

        for (int i = 0; i < enemies.size(); i++) {

            if (enemies.get(i).getHp() <= 0) {

                enemies.remove(i);
            }
        }
    }

    public List<Enemy> getEnemies() {

        return this.enemies;
    }

    public Enemy getEnemy(int index) {


        if (index < enemies.size()) {

            return enemies.get(index);
        }

        return null;
    }

    public void printEnemies() {

        for (int i = 0; i < enemies.size(); i++) {

            System.out.println(i + 1 + " " + enemies.get(i).getName());
        }
    }
}
