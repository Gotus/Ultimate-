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

    public Enemy getEnemy(String name, int number) {

        for (Enemy e: this.enemies) {

            if ((e.getName().equalsIgnoreCase(name)) && (e.getNumber() == number)) {

                return e;
            }
        }

        return null;
    }
}
