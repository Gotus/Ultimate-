package com.ultimate;

/**
 * Created by Gotus on 22.07.2017.
 */

enum Size{

    SMALL,
    AVERAGE,
    LARGE
}

public class World extends Location{

    private boolean active;

    public World() {

        name = null;
        length = 10;
        height = 10;
        active = true;
        cells = null;
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

    public void createLocationArray() {

        cells = new int[length * height];
        for (int i = 0; i < cells.length; i++) {

            cells[i] = i;
        }
    }


    public void createLocationArray(int length, int height) {

        cells = new int[length * height];
        for (int i = 0; i < length; i++) {

            cells[i] = i;
        }
    }

    public void createLocationArray(Size worldSize) {

        switch (worldSize) {

            case SMALL:
                this.length = 10;
                this.height = 10;
                break;
            case AVERAGE:
                this.length = 30;
                this.height = 30;
                break;
            case LARGE:
                this.length = 100;
                this.height = 100;
                break;
        }
        createLocationArray();
    }

    public int[] getWorldCells()
    {

        return this.cells;
    }

    public void setActive(boolean value) {

        this.active = value;
    }

    public boolean getActive() {

        return this.active;
    }
}
