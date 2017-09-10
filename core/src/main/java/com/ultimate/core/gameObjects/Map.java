package com.ultimate.core.gameObjects;

import javafx.util.Pair;

import java.io.Serializable;
import java.util.ArrayList;

public class Map implements Serializable {

    private static final long serialVersionUID = 174397579216168554L;

    private int width;
    private int height;
    private TerrainType[][] cells;

    public static class MapNode implements Serializable {

        private static final long serialVersionUID = -7053938611138474094L;

        int x, y;
        String name;
        TerrainType terrainType;
        ArrayList<MapNode> neighborhoodNodes = new ArrayList<>();

        MapNode(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String getName() {

            return name;
        }

        public int getX() {

            return this.x;
        }

        public int getY() {

            return this.y;
        }
    }

    ArrayList<MapNode> mapNodes = new ArrayList<>();
    MapNode startNode = null;

    public ArrayList<MapNode> getMapNodes() {

        return mapNodes;
    }

    static class MapEdge implements Serializable {

        private static final long serialVersionUID = -8951628507035661335L;

        MapNode from, to;
        TerrainType terrainType;

        MapEdge(MapNode from, MapNode to) {
            this.from = from;
            this.to = to;
        }
    }

    ArrayList<MapEdge> mapEdges = new ArrayList<>();

    private static class JumpToAnotherLocation implements Serializable {

        private static final long serialVersionUID = 2401761047552939361L;

        MapNode from;
        Pair<Location, MapNode> to;

        JumpToAnotherLocation(MapNode from, Pair<Location, MapNode> to) {

            this.from = from;
            this.to = to;
        }
    }

    ArrayList<JumpToAnotherLocation> jumpsToAnotherLocations = new ArrayList<>();

    Map(int width, int height){

        this.width = width;
        this.height = height;
        cells = new TerrainType[width][height];
    }

    public int getWidth() {

        return this.width;
    }

    public int getHeight() {

        return this.height;
    }

    public TerrainType[][] getCells() {
        return cells;
    }

    public MapNode getStartNode() {

        return startNode;
    }
}
