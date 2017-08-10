package com.ultimate.core.gameObjects;

import java.util.Random;

enum WorldSize {

    SMALL,
    AVERAGE,
    LARGE
}

public class World {

    private String name;

    private class Map {//TODO make abstract
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

        public int[][] getCells() {
            return cells;
        }

        private void generateCells() {
            Random random = new Random();
            cells = new int[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    cells[i][j] = Math.abs(random.nextInt() % 2);
                }
            }
        }
    }

    Map map;

    public World() {

        this(WorldSize.SMALL);
    }

    public void setName(String name) {

        this.name = new String(name);
    }

    public String getName() {

        return this.name;
    }

    public World(int width, int height) {

        map = new Map(width, height);
    }

    public World(WorldSize worldWorldSize) {

        switch (worldWorldSize) {

            case SMALL:
                map = new Map(10, 10);
                break;
            case AVERAGE:
                map = new Map(30, 30);
                break;
            case LARGE:
                map = new Map(100, 100);
                break;
            default:
                map = new Map(10, 10);
        }
    }

    public Map getMap()
    {

        return map;
    }
}
