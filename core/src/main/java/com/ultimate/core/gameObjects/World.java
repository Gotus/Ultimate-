package com.ultimate.core.gameObjects;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class World {

    ArrayList<Location> locations = new ArrayList<>();

    int seed;

    Map.MapNode startNode;

    private class CharacterPosition {

        Location location;
        Map.MapNode mapNode;
        int x, y;
    }

    HashMap<Character, CharacterPosition> charactersPositions = new HashMap<>();

    public World(LocationSize locationSize, int seed) {

        this.seed = seed;
        Random random = new Random(seed);

        Location startLocation = new Location(locationSize, LocationType.WORLD, random.nextInt());
        locations.add(startLocation);
        startNode = startLocation.getMap().startNode;
    }
}
