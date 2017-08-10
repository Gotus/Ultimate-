package com.ultimate.core.gameObjects;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public enum MapCell {
    PLAIN,
    FOREST,
    DESERT,
    ICE,
    MOUNTAIN,
    WATER;

    private static HashSet<MapCell> passable = new HashSet<>(
            Arrays.asList(PLAIN, FOREST, DESERT, ICE));

    private static Random random = new Random();

    public boolean isPassable() {
        return passable.contains(this);
    }

    public static MapCell getRandomPassable() {
        return (MapCell) passable.toArray()[random.nextInt(passable.size())];
    }
}
