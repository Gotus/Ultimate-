package com.ultimate.core.gameObjects;

enum WorldSize {

    SMALL,
    AVERAGE,
    LARGE
}

public class World {

    private String name;
    Map map;

    public World() {

        this(WorldSize.SMALL);
    }

    public void setName(String name) {

        this.name = new String(name);
    }

    public String getName() {

        return this.name;
    }

    public World(int width, int height) {

        map = new Map(width, height);
    }

    public World(WorldSize worldWorldSize) {

        switch (worldWorldSize) {

            case SMALL:
                map = new Map(10, 10);
                break;
            case AVERAGE:
                map = new Map(30, 30);
                break;
            case LARGE:
                map = new Map(100, 100);
                break;
            default:
                map = new Map(10, 10);
        }
    }

    public Map getMap()
    {

        return map;
    }
}
