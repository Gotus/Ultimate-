package com.ultimate.core.gameObjects;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public enum TerrainType {
    PLAIN,
    FOREST,
    DESERT,
    ICE,
    MOUNTAIN,
    WATER;

    private static HashSet<TerrainType> passable = new HashSet<>(
            Arrays.asList(PLAIN, FOREST, DESERT, ICE));

    private static Random random = new Random();

    public boolean isPassable() {
        return passable.contains(this);
    }

    public static TerrainType getRandomPassable() {
        return (TerrainType) passable.toArray()[random.nextInt(passable.size())];
    }
}
