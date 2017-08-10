package com.ultimate.core.gameObjects;

import java.util.Random;

public class Location {

    private String name;

    private class Map {
        int width;
        int height;
        MapCell[][] cells;

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

        public MapCell[][] getCells() {
            return cells;
        }

        private void generateCells() {
            Random random = new Random();
            cells = new MapCell[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    cells[i][j] = MapCell.getRandomPassable();
                }
            }
        }
    }

    Map map;

    public Location() {

        this(LocationSize.SMALL);
    }

    public void setName(String name) {

        this.name = new String(name);
    }

    public String getName() {

        return this.name;
    }

    public Location(int width, int height) {

        map = new Map(width, height);
    }

    public Location(LocationSize worldLocationSize) {

        switch (worldLocationSize) {

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
