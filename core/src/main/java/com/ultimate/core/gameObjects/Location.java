package com.ultimate.core.gameObjects;

import javafx.util.Pair;

import java.io.*;
import java.util.HashMap;

public class Location implements Serializable {

    private static final long serialVersionUID = 749631111141297776L;

    private String name;

    private Map map;

    static private HashMap<Pair<LocationType, LocationSize>, Integer> sizes = new HashMap<>();

    static {
        sizes.put(new Pair<>(LocationType.WORLD, LocationSize.SMALL), 150);
        sizes.put(new Pair<>(LocationType.WORLD, LocationSize.AVERAGE), 250);
        sizes.put(new Pair<>(LocationType.WORLD, LocationSize.LARGE), 400);

        sizes.put(new Pair<>(LocationType.TOWN, LocationSize.SMALL), 10);
        sizes.put(new Pair<>(LocationType.TOWN, LocationSize.AVERAGE), 30);
        sizes.put(new Pair<>(LocationType.TOWN, LocationSize.LARGE), 100);

        sizes.put(new Pair<>(LocationType.CAVERN, LocationSize.SMALL), 10);
        sizes.put(new Pair<>(LocationType.CAVERN, LocationSize.AVERAGE), 30);
        sizes.put(new Pair<>(LocationType.CAVERN, LocationSize.LARGE), 100);
    }

    private static int getSizeInCells(LocationType locationType, LocationSize locationSize) {

        return sizes.get(new Pair<>(locationType, locationSize));
    }

    public String getName() {

        return this.name;
    }

    public Location() {}

    public Location(int width, int height, LocationType locationType, int seed) {

        switch (locationType) {
            case WORLD:
                map = IslandMapsGenerator.generateMap(width, height, seed);
                break;
            //TODO other location types
        }

        name = locationType.toString();
    }

    public Location(LocationSize locationSize, LocationType locationType, int seed) {

        this(getSizeInCells(locationType, locationSize),
                getSizeInCells(locationType, locationSize),
                locationType, seed);
    }

    public Map getMap() {

        return map;
    }
}
