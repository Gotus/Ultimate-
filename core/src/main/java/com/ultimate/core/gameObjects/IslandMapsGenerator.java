package com.ultimate.core.gameObjects;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class IslandMapsGenerator {

    private final static int minimumNodeDistance = 6;
    private final static int maximumNodeDistance = 15;
    private final static int maximumEdgeLength = 22;
    private final static int centerTerrainDistance = 2;
    private final static double oceanBorder = 0.8;
    private final static double oceanFreedom = 0.6;

    private IslandMapsGenerator() {}

    public static Map generateMap(int width, int height, int seed) {

        Random random = new Random(seed);
        Map map = new Map(width, height);

        generateNodes(map, random);
        generateEdges(map);
        setTerrainTypeToNodes(map, random);
        setTerrainTypeToCells(map);
        combineLakesNodes(map);
        combineLakesWithOcean(map);
        removingExcess(map);
        combineOceanNodes(map);
        cleaningBorders(map);
        setTerrainTypeToEdges(map);
        setNamesToNodes(map);
        setStartNode(map);

        return map;
    }

    private static void generateNodes(Map map, Random random) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        int width = map.getWidth(), height = map.getHeight();

        HashSet<Pair<Integer, Integer>> freeCells = new HashSet<>();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                freeCells.add(new Pair<>(i, j));
            }
        }

        Pair<Integer, Integer> coordinates;

        while (!freeCells.isEmpty()) {

            coordinates = (Pair<Integer, Integer>) freeCells.toArray()[random.nextInt(freeCells.size())];

            int radius = random.nextInt(maximumNodeDistance - minimumNodeDistance + 1) + minimumNodeDistance;
            int borderIMin = Math.max(0, coordinates.getKey() - radius);
            int borderIMax = Math.min(width, coordinates.getKey() + radius);

            for (int i = borderIMin; i < borderIMax; i++) {

                int delta = (int) Math.round(Math.sqrt(radius * radius - Math.abs(coordinates.getKey() - i)));
                int borderJMin = Math.max(0, coordinates.getValue() - delta);
                int borderJMax = Math.min(height, coordinates.getValue() + delta);

                for (int j = borderJMin; j < borderJMax; j++) {
                    freeCells.remove(new Pair<>(i, j));
                }
            }

            mapNodes.add(new Map.MapNode(coordinates.getKey(), coordinates.getValue()));
        }

        for (Map.MapNode node : mapNodes) {
            if (Math.pow((double)node.x / (double)width - 0.5, 2)
                    + Math.pow((double)node.y / (double)height - 0.5, 2)
                    > oceanBorder / 4) {
                node.terrainType = TerrainType.OCEAN;
            }
        }
    }

    private static void generateEdges(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        ArrayList<Map.MapEdge> mapEdges = map.mapEdges;

        for (int i = 0; i < mapNodes.size(); i++) {
            for (int j = i + 1; j < mapNodes.size(); j++) {

                Map.MapNode mapNode1 = mapNodes.get(i);
                Map.MapNode mapNode2 = mapNodes.get(j);

                if (Math.pow(mapNode1.x - mapNode2.x, 2) + Math.pow(mapNode1.y - mapNode2.y, 2)
                        <= Math.pow(maximumEdgeLength, 2)) {

                    if (mapNode1.x < mapNode2.x) {
                        mapEdges.add(new Map.MapEdge(mapNode1, mapNode2));
                    } else {
                        mapEdges.add(new Map.MapEdge(mapNode2, mapNode1));
                    }

                    mapNode1.neighborhoodNodes.add(mapNode2);
                    mapNode2.neighborhoodNodes.add(mapNode1);
                }
            }
        }
    }

    private static void setTerrainTypeToNodes(Map map, Random random) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;

        //1 phase - creating centers of "biomes"
        ArrayList<Map.MapNode> remainingNodes = new ArrayList<>();
        for (Map.MapNode node : mapNodes) {
            if (node.terrainType != TerrainType.OCEAN) {
                remainingNodes.add(node);
            }
        }
        ArrayList<Map.MapNode> nodesInGeneratingRange = new ArrayList<>();
        ArrayList<Map.MapNode> readyToSettingTerrainTypeNodes = new ArrayList<>();

        int terrainTypeIndex = 0;

        while (!remainingNodes.isEmpty()) {

            Map.MapNode currentNode = remainingNodes.get(0);
            remainingNodes.remove(0);

            //TODO clear this code
            currentNode.terrainType = TerrainType.values()[terrainTypeIndex];
            terrainTypeIndex++;
            terrainTypeIndex %= TerrainType.values().length - 1;

            nodesInGeneratingRange.clear();

            for (Map.MapNode node : currentNode.neighborhoodNodes) {

                if (!readyToSettingTerrainTypeNodes.contains(node)) {
                    readyToSettingTerrainTypeNodes.add(node);
                }

                nodesInGeneratingRange.add(node);
                remainingNodes.remove(node);
            }

            ArrayList<Map.MapNode> nodesInNextGeneratingRange = new ArrayList<>();

            for (int range = 1; range < centerTerrainDistance; range++) {

                for (Map.MapNode node : nodesInGeneratingRange) {
                    for (Map.MapNode nextNode : node.neighborhoodNodes) {

                        if (!nodesInNextGeneratingRange.contains(nextNode)
                                && (remainingNodes.contains(nextNode))) {

                            nodesInNextGeneratingRange.add(nextNode);
                            remainingNodes.remove(nextNode);
                        }
                    }
                }

                nodesInGeneratingRange = new ArrayList<>(nodesInNextGeneratingRange);
                nodesInNextGeneratingRange.clear();
            }
        }

        //2 phase
        while (!readyToSettingTerrainTypeNodes.isEmpty()) {

            Map.MapNode currentNode = readyToSettingTerrainTypeNodes.get(
                    random.nextInt(readyToSettingTerrainTypeNodes.size()));

            for (Map.MapNode node : currentNode.neighborhoodNodes) {

                if (node.terrainType == null) {

                    if (!readyToSettingTerrainTypeNodes.contains(node)) {
                        readyToSettingTerrainTypeNodes.add(node);
                    }
                } else {

                    if ((currentNode.terrainType != TerrainType.OCEAN)
                            && ((node.terrainType != TerrainType.OCEAN)
                            || (random.nextDouble() < oceanFreedom))) {
                        currentNode.terrainType = node.terrainType;
                    }
                }
            }

            readyToSettingTerrainTypeNodes.remove(currentNode);
        }
    }

    private static void setTerrainTypeToCells(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        TerrainType[][] cells = map.getCells();
        int width = map.getWidth(), height = map.getHeight();

        for (Map.MapNode node : mapNodes) {

            TerrainType terrainType = node.terrainType;
            for (int i = node.x - minimumNodeDistance / 3; i <= node.x + minimumNodeDistance / 3; i++) {
                for (int j = node.y - minimumNodeDistance / 3; j <= node.y + minimumNodeDistance / 3; j++) {
                    if ((i >= 0) && (j >= 0) && (i < width) && (j < height))
                        if (cells[i][j] == null) {
                            cells[i][j] = terrainType;
                        }
                }
            }
        }

        setTerrainTypeToCellsByEdges(map);

        ArrayList<Pair<Integer, Integer>> nonCheckedCells = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if (cells[i][j] != null) {
                    nonCheckedCells.add(new Pair<>(i, j));
                }
            }
        }

        while (!nonCheckedCells.isEmpty()) {

            int x = nonCheckedCells.get(0).getKey(), y = nonCheckedCells.get(0).getValue();
            nonCheckedCells.remove(0);

            if ((x > 0) && (cells[x - 1][y] == null)) {

                cells[x - 1][y] = cells[x][y];
                nonCheckedCells.add(new Pair<>(x - 1, y));
            }
            if ((y > 0) && (cells[x][y - 1] == null)) {

                cells[x][y - 1] = cells[x][y];
                nonCheckedCells.add(new Pair<>(x, y - 1));
            }
            if ((x < width - 1) && (cells[x + 1][y] == null)) {

                cells[x + 1][y] = cells[x][y];
                nonCheckedCells.add(new Pair<>(x + 1, y));
            }
            if ((y < height - 1) && (cells[x][y + 1] == null)) {

                cells[x][y + 1] = cells[x][y];
                nonCheckedCells.add(new Pair<>(x, y + 1));
            }
        }
    }

    private static void setTerrainTypeToCellsByEdges(Map map) {

        ArrayList<Map.MapEdge> mapEdges = map.mapEdges;
        TerrainType[][] cells = map.getCells();

        for (Map.MapEdge edge : mapEdges) {
            if ((edge.from.terrainType == edge.to.terrainType)
                    && (edge.from.terrainType != TerrainType.OCEAN)) {
                TerrainType terrainType = edge.from.terrainType;

                int x1 = edge.from.x, x2 = edge.to.x, y1 = edge.from.y, y2 = edge.to.y;

                if (x1 == x2) {

                    for (int y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                        cells[x1][y] = terrainType;
                    }
                } else {

                    int deltaX = x2 - x1;
                    int deltaY = y2 - y1;

                    if (deltaX > Math.abs(deltaY)) {

                        for (int x = x1; x < x2; x++) {
                            int y = y1 + deltaY * (x - x1) / deltaX;
                            cells[x][y] = terrainType;
                        }
                    } else {

                        if (y2 > y1) {

                            for (int y = y1; y <= y2; y++) {
                                int x = x1 + deltaX * (y - y1) / deltaY;
                                cells[x][y] = terrainType;
                            }
                        } else {

                            for (int y = y2; y <= y1; y++) {
                                int x = x2 + deltaX * (y - y2) / deltaY;
                                cells[x][y] = terrainType;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void removingExcess(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        ArrayList<Map.MapEdge> mapEdges = map.mapEdges;

        ArrayList<Map.MapEdge> edgesToDelete = new ArrayList<>();
        for (Map.MapEdge edge : mapEdges) {
            if ((edge.from.terrainType == TerrainType.MOUNTAIN)
                    && (edge.to.terrainType == TerrainType.MOUNTAIN) ||
                    (edge.from.terrainType == TerrainType.OCEAN)
                            && (edge.to.terrainType == TerrainType.OCEAN)) {
                edgesToDelete.add(edge);
                edge.from.neighborhoodNodes.remove(edge.to);
                edge.to.neighborhoodNodes.remove(edge.from);
            }
        }
        mapEdges.removeAll(edgesToDelete);

        ArrayList<Map.MapNode> nodesToDelete = new ArrayList<>();
        for (Map.MapNode node : mapNodes) {
            if ((node.neighborhoodNodes.isEmpty())
                    && ((node.terrainType == TerrainType.MOUNTAIN) || (node.terrainType == TerrainType.OCEAN))) {
                nodesToDelete.add(node);
            }
        }
        mapNodes.removeAll(nodesToDelete);
    }

    private static void combineLakesNodes(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        ArrayList<Map.MapEdge> mapEdges = map.mapEdges;

        ArrayList<Map.MapNode> lakeNodes = new ArrayList<>();
        for (Map.MapNode node : mapNodes) {
            if (node.terrainType == TerrainType.LAKE) {
                lakeNodes.add(node);
            }
        }

        ArrayList<Map.MapNode> currentLakeNodes = new ArrayList<>();
        ArrayList<Map.MapNode> coastalNodes = new ArrayList<>();
        while (!lakeNodes.isEmpty()) {

            currentLakeNodes.clear();
            currentLakeNodes.add(lakeNodes.get(0));
            lakeNodes.remove(0);

            coastalNodes.clear();

            ArrayList<Map.MapNode> currentIterationNodes = new ArrayList<>();
            ArrayList<Map.MapNode> nextIterationNodes = new ArrayList<>();
            currentIterationNodes.add(currentLakeNodes.get(0));

            while (!currentIterationNodes.isEmpty()) {

                for (Map.MapNode lakeNode : currentIterationNodes) {
                    for (Map.MapNode neighborhoodNode : lakeNode.neighborhoodNodes) {

                        if (neighborhoodNode.terrainType == TerrainType.LAKE) {

                            if (!currentLakeNodes.contains(neighborhoodNode)) {
                                currentLakeNodes.add(neighborhoodNode);
                                nextIterationNodes.add(neighborhoodNode);
                                lakeNodes.remove(neighborhoodNode);
                            }
                        } else {

                            if (!coastalNodes.contains(neighborhoodNode)) {
                                coastalNodes.add(neighborhoodNode);
                            }
                        }

                        neighborhoodNode.neighborhoodNodes.remove(lakeNode);
                    }
                    lakeNode.neighborhoodNodes.clear();
                }

                currentIterationNodes.clear();
                currentIterationNodes.addAll(nextIterationNodes);
                nextIterationNodes.clear();
            }

            ArrayList<Map.MapEdge> mapEdgesToRemove = new ArrayList<>();
            for (Map.MapEdge edge : mapEdges) {
                for (Map.MapNode node : currentLakeNodes) {

                    if ((edge.to == node) || (edge.from == node)) {
                        mapEdgesToRemove.add(edge);
                    }
                }
            }
            mapEdges.removeAll(mapEdgesToRemove);

            int x = 0, y = 0;
            for (Map.MapNode node : currentLakeNodes) {
                x += node.x;
                y += node.y;
            }
            x /= currentLakeNodes.size();
            y /= currentLakeNodes.size();

            Map.MapNode mainLakeNode = new Map.MapNode(x, y);
            mainLakeNode.terrainType = TerrainType.LAKE;

            mapNodes.removeAll(currentLakeNodes);
            mapNodes.add(mainLakeNode);

            for (Map.MapNode node : coastalNodes) {
                node.neighborhoodNodes.add(mainLakeNode);
                mainLakeNode.neighborhoodNodes.add(node);
                mapEdges.add(new Map.MapEdge(node, mainLakeNode));
            }
        }
    }

    private static void combineLakesWithOcean(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;

        for (Map.MapNode lakeNode : mapNodes) {
            if (lakeNode.terrainType == TerrainType.LAKE) {

                boolean lakeIsOcean = false;
                for (Map.MapNode node : lakeNode.neighborhoodNodes) {
                    if (node.terrainType == TerrainType.OCEAN) {

                        lakeIsOcean = true;
                        break;
                    }
                }

                if (lakeIsOcean) {
                    lakeNode.terrainType = TerrainType.OCEAN;
                }
            }
        }
    }

    private static void combineOceanNodes(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        ArrayList<Map.MapEdge> mapEdges = map.mapEdges;

        ArrayList<Map.MapNode> oceanNodes = new ArrayList<>();
        ArrayList<Map.MapNode> coastalNodes = new ArrayList<>();

        for (Map.MapNode oceanNode : mapNodes) {
            if (oceanNode.terrainType == TerrainType.OCEAN) {

                oceanNodes.add(oceanNode);
                for (Map.MapNode node : oceanNode.neighborhoodNodes) {

                    if (!coastalNodes.contains(node)) {
                        coastalNodes.add(node);
                    }
                    node.neighborhoodNodes.remove(oceanNode);
                }
            }
        }

        mapNodes.removeAll(oceanNodes);

        ArrayList<Map.MapEdge> edgesToDelete = new ArrayList<>();
        for (Map.MapEdge edge : mapEdges) {

            if ((edge.from.terrainType == TerrainType.OCEAN)
                    || (edge.to.terrainType == TerrainType.OCEAN)) {
                edgesToDelete.add(edge);
            }
        }
        mapEdges.removeAll(edgesToDelete);

        Map.MapNode mainOceanNode = new Map.MapNode(0,0);
        mainOceanNode.terrainType = TerrainType.OCEAN;
        mainOceanNode.neighborhoodNodes = new ArrayList<>(coastalNodes);
        mapNodes.add(mainOceanNode);

        for (Map.MapNode node : coastalNodes) {
            node.neighborhoodNodes.add(mainOceanNode);
            mapEdges.add(new Map.MapEdge(node, mainOceanNode));
        }
    }

    private static void cleaningBorders(Map map) {

        TerrainType[][] cells = map.getCells();
        int width = map.getWidth(), height = map.getHeight();

        for (int i = 0; i < width; i++) {
            cells[i][0] = TerrainType.OCEAN;
            cells[i][height - 1] = TerrainType.OCEAN;
        }

        for (int j = 0; j < height; j++) {
            cells[0][j] = TerrainType.OCEAN;
            cells[width - 1][j] = TerrainType.OCEAN;
        }
    }

    private static void setTerrainTypeToEdges(Map map) {

        ArrayList<Map.MapEdge> mapEdges = map.mapEdges;

        for (Map.MapEdge edge : mapEdges) {

            if ((edge.from.terrainType == TerrainType.OCEAN)
                    || (edge.to.terrainType == TerrainType.OCEAN)) {
                edge.terrainType = TerrainType.OCEAN;
            } else {

                if ((edge.from.terrainType == TerrainType.LAKE)
                        || (edge.to.terrainType == TerrainType.LAKE)) {
                    edge.terrainType = TerrainType.LAKE;
                } else {

                    edge.terrainType = edge.from.terrainType;//TODO add random or something better
                }
            }
        }
    }

    private static void setNamesToNodes(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;

        for (Map.MapNode node : mapNodes) {
            node.name = node.terrainType.toString() + " " + node.x + " " + node.y;
        }
    }

    private static void setStartNode(Map map) {

        ArrayList<Map.MapNode> mapNodes = map.mapNodes;
        int width = map.getWidth(), height = map.getHeight();

        double distance = Math.pow(height + width, 2);
        for (Map.MapNode node : mapNodes) {

            double newDistance = Math.pow(node.x - width / 2, 2) + Math.pow(node.y - height / 2, 2);
            if ((node.terrainType != TerrainType.LAKE)
                    && (node.terrainType != TerrainType.OCEAN)
                    && (node.terrainType != TerrainType.MOUNTAIN)
                    && (distance > newDistance)) {

                map.startNode = node;
                distance = newDistance;
            }
        }
    }
}
