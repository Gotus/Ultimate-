package com.ultimate.core.gameObjects;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class World implements Serializable {

    private static final long serialVersionUID = 6857988707171828214L;

    ArrayList<Location> locations = new ArrayList<>();

    int seed;

    Map.MapNode startNode;

    private class CharacterPosition  implements Serializable {

        private static final long serialVersionUID = 6319985168568837514L;

        Location location;
        Map.MapNode mapNode;
        int x, y;
    }

    HashMap<Character, CharacterPosition> charactersPositions = new HashMap<>();

    public HashMap<Character, CharacterPosition> getCharactersPositions() {

        return this.charactersPositions;
    }

    public World(LocationSize locationSize, int seed) {

        this.seed = seed;
        Random random = new Random(seed);

        Location startLocation = new Location(locationSize, LocationType.WORLD, random.nextInt());
        locations.add(startLocation);
        startNode = startLocation.getMap().startNode;
    }
}
