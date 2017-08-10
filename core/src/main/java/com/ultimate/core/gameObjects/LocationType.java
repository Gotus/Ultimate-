package com.ultimate.core.gameObjects;


import javafx.util.Pair;

import java.util.HashMap;

public enum LocationType {
    WORLD,
    TOWN,
    CAVERN;

    static private HashMap<Pair<LocationType, LocationSize>, Integer> sizes = new HashMap<>();

    static {
        sizes.put(new Pair<>(WORLD, LocationSize.SMALL), 10);
        sizes.put(new Pair<>(WORLD, LocationSize.AVERAGE), 30);
        sizes.put(new Pair<>(WORLD, LocationSize.LARGE), 100);

        sizes.put(new Pair<>(TOWN, LocationSize.SMALL), 10);
        sizes.put(new Pair<>(TOWN, LocationSize.AVERAGE), 10);
        sizes.put(new Pair<>(TOWN, LocationSize.LARGE), 10);

        sizes.put(new Pair<>(CAVERN, LocationSize.SMALL), 10);
        sizes.put(new Pair<>(CAVERN, LocationSize.AVERAGE), 10);
        sizes.put(new Pair<>(CAVERN, LocationSize.LARGE), 10);
    }

    public int getSizeInCells(LocationSize locationSize) {
        return sizes.get(new Pair<>(this, locationSize));
    }
}
