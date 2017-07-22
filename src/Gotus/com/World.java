package Gotus.com;

/**
 * Created by Gotus on 22.07.2017.
 */
public class World {

    private String name;
    private int length;
    private int height;
    private int[] worldCells;

    public World() {

        name = null;
        length = 0;
        height = 0;
        worldCells = null;
    }

    public void setLength(int value) {

        this.length = value;
    }

    public void setHeight(int value) {

        this.height = value;
    }

    public void setName(String name) {

        this.name = new String(name);
    }

    public String getName() {

        return this.name;
    }

    public int getLength() {

        return this.length;
    }

    public int getHeight() {

        return this.height;
    }

    public void createWorldArray() {

        worldCells = new int[length * height];
        for (int i = 0; i < worldCells.length; i++) {

            worldCells[i] = i;
            System.out.println(worldCells[i]);
        }
    }

    public int[] getWorldCells()
    {

        return this.worldCells;
    }
}
