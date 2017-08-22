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
    LAKE,
    OCEAN;

    private static HashSet<TerrainType> commonWorldMapTypes = new HashSet<>(
            Arrays.asList(PLAIN, FOREST, DESERT, ICE));

    private static Random random = new Random();

    public static TerrainType getRandom(LocationType locationType) {

        switch (locationType) {
            case WORLD:
                return (TerrainType) commonWorldMapTypes.toArray()[random.nextInt(commonWorldMapTypes.size())];
            case TOWN:
                return PLAIN;//TODO change when the commonTownMapTypes will be created
            case CAVERN:
                return PLAIN;//TODO change when the commonCavernMapTypes will be created
            default:
                return PLAIN;
        }
    }
}
