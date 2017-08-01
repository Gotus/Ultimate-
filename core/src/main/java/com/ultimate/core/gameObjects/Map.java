package com.ultimate.core.gameObjects;

/**
 * Created by Gotus on 31.07.2017.
 */
public class Map {//TODO make abstract
    int width;
    int height;
    int[][] cells;//TODO int is not good

    public Map(int width, int height){
        this.width = width;
        this.height = height;
        generateCells();
    }

    public int getWidth() {

        return this.width;
    }

    public int getHeight() {

        return this.height;
    }

    private void generateCells() {

        cells = new int[width][height];
    }
}
