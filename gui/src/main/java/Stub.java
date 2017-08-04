import com.ultimate.core.gameObjects.Map;

public final class Stub {

    private static Map map;

    private Stub() {}

    public static void generateMap(int width, int height) {
        map = new Map(width, height);
    }

    public static int[][] getMapCells() {
        return map.getCells();
    }
}
