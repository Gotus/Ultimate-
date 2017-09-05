package com.ultimate.core.gameObjects;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class World implements Serializable {

    private static final long serialVersionUID = 6857988707171828214L;
    private String name;
    private ArrayList<Location> locations = new ArrayList<>();

    int seed;

    Map.MapNode startNode;

    public static class CharacterPosition  implements Serializable {

        private static final long serialVersionUID = 6319985168568837514L;

        Location location;
        Map.MapNode mapNode;
        int x, y;


        public CharacterPosition(Location location, Map.MapNode mapNode) {

            this.location = location;
            this.mapNode = mapNode;
        }

    }

    HashMap<PlayCharacter, CharacterPosition> charactersPositions = new HashMap<>();

    public HashMap<PlayCharacter, CharacterPosition> getCharactersPositions() {

        return this.charactersPositions;
    }

    public World(LocationSize locationSize, int seed) {

        this.seed = seed;
        Random random = new Random(seed);

        Location startLocation = new Location(locationSize, LocationType.WORLD, random.nextInt());
        locations.add(startLocation);
        startNode = startLocation.getMap().startNode;
    }

    public String getName() {

        return name;
    }

    public ArrayList<Location> getLocations() {

        return this.locations;
    }
}
