package com.ultimate.core.gameObjects;


public enum MapCell {
    PLAIN,
    FOREST,
    DESERT,
    ICE,
    MOUNTAIN,
    WATER;

    private boolean isPassable;

    static {
        PLAIN.isPassable = true;
        FOREST.isPassable = true;
        DESERT.isPassable = true;
        ICE.isPassable = true;
        MOUNTAIN.isPassable = false;
        WATER.isPassable =false;
    }

    public boolean isPassable() {
        return isPassable;
    }

    public static MapCell getRandomPassable() {
        return PLAIN;//TODO obliviously fix
    }
}
