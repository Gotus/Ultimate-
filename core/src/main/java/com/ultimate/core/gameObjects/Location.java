package com.ultimate.core.gameObjects;

import java.util.Random;

public class Location {

    private String name;

    private class Map {
        int width;
        int height;
        MapCell[][] cells;

        public Map(int width, int height, LocationType locationType){
            this.width = width;
            this.height = height;
            generateCells(locationType);
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

        private void generateCells(LocationType locationType) {
            //TODO PAIN
        }
    }

    Map map;

    public void setName(String name) {

        this.name = new String(name);
    }

    public String getName() {

        return this.name;
    }

    public Location(int width, int height, LocationType locationType) {

        map = new Map(width, height, locationType);
    }

    public Location(LocationSize worldLocationSize, LocationType locationType) {

        switch (worldLocationSize) {

            case SMALL:
                map = new Map(10, 10, locationType);
                break;
            case AVERAGE:
                map = new Map(30, 30, locationType);
                break;
            case LARGE:
                map = new Map(100, 100, locationType);
                break;
            default:
                map = new Map(10, 10, locationType);
        }
    }

    public Map getMap()
    {

        return map;
    }
}
