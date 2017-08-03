package com.ultimate.core.gameObjects;


import java.util.Random;

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
        Random random = new Random();
        cells = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = random.nextInt() % 2;
            }
        }
    }
}
