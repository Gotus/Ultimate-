package com.ultimate.core.gameObjects;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Random;

public class Location {

    private String name;

    private class Map {

        int width;
        int height;
        MapCell[][] cells;

        private class MapNode {

            int x, y;
            LocationType locationType;
            Pair<Location, MapNode> linkedNode;

            MapNode(int x, int y, LocationType locationType) {
                this.x = x;
                this.y = y;
                this.locationType = locationType;
            }
        }

        MapNode[] mapNodes;

        private class MapEdge {

            MapNode from, to;
            LocationType locationType;

            MapEdge(MapNode from, MapNode to) {
                this.from = from;
                this.to = to;
                locationType = (new Random().nextBoolean()) ? from.locationType : to.locationType;
            }
        }

        MapEdge[] mapEdges;

        private class JumpToAnotherLocation {

            MapNode from;
            Pair<Location, MapNode> to;

            JumpToAnotherLocation(MapNode from, Pair<Location, MapNode> to) {
                this.from = from;
                this.to = to;
            }
        }

        JumpToAnotherLocation[] jumpsToAnotherLocations;

        public Map(int width, int height, LocationType locationType){
            this.width = width;
            this.height = height;
            generate(locationType);
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

        private void generate(LocationType locationType) {
            //TODO PAIN
        }
    }

    Map map;

    static private HashMap<Pair<LocationType, LocationSize>, Integer> sizes = new HashMap<>();

    static {
        sizes.put(new Pair<>(LocationType.WORLD, LocationSize.SMALL), 10);
        sizes.put(new Pair<>(LocationType.WORLD, LocationSize.AVERAGE), 30);
        sizes.put(new Pair<>(LocationType.WORLD, LocationSize.LARGE), 100);

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

    public void setName(String name) {

        this.name = new String(name);
    }

    public String getName() {

        return this.name;
    }

    public Location(int width, int height, LocationType locationType) {

        map = new Map(width, height, locationType);
    }

    public Location(LocationSize locationSize, LocationType locationType) {

        int size = getSizeInCells(locationType, locationSize);
        map = new Map(size, size, locationType);
    }

    public Map getMap() {

        return map;
    }
}
