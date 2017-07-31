package com.ultimate;

/**
 * Created by Gotus on 30.07.2017.
 */
public class Town extends Location {

    public Town() {

        name = null;
        length = 10;
        height = 10;
        cells = null;
    }

    public void createLocationArray(int length, int height) {

        cells = new int[length * height];
        for (int i = 0; i < length; i++) {

            cells[i] = i;
        }
    }

    public void createLocationArray() {

        cells = new int[length * height];
        for (int i = 0; i < cells.length; i++) {

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
}
