package baseGraphics;


import com.ultimate.core.CurrentGame;
import com.ultimate.core.gameObjects.Map;

import javax.swing.*;
import java.awt.*;

public class ActionScreen extends JPanel implements IAnimatable, IClickable{

    public static final int MIN_WIDTH = 300, MIN_HEIGHT = 300;
    CurrentGame currentGame;

    private class GraphicsData {
        final int cellSize = 50, borderSize = 5;
    }
    GraphicsData graphicsData = new GraphicsData();

    private class AnimationData {
        int mapMoveIteration = 0;
        int mapDx = 0, mapDy = 0;
        final int mapMoveStep = 6;

        public void mapMove() {
            mapMoveIteration++;
            mapMoveIteration %= 40;
            if (mapMoveIteration < 10) {
                mapDx += mapMoveStep;
            } else if (mapMoveIteration < 20) {
                mapDy += mapMoveStep;
            } else if (mapMoveIteration < 30) {
                mapDx -= mapMoveStep;
            } else if (mapMoveIteration < 40) {
                mapDy -= mapMoveStep;
            }
        }

    }
    AnimationData animationData = new AnimationData();

    public ActionScreen(CurrentGame currentGame) {
        this.currentGame = currentGame;
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void animate() {
        animationData.mapMove();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)  g;

        //BAD SECTION
        Map map = baseGraphics.Stub.getMap();
        int cells[][] = map.getCells();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {

                switch (cells[i][j]) {
                    case 0:
                        graphics.setColor(Color.blue);
                        break;
                    case 1:
                        graphics.setColor(Color.green);
                        break;
                    default:
                        graphics.setColor(Color.red);
                }

                graphics.fillRect(
                        i * (graphicsData.cellSize + graphicsData.borderSize) + animationData.mapDx,
                        j * (graphicsData.cellSize + graphicsData.borderSize) + animationData.mapDy,
                        graphicsData.cellSize, graphicsData.cellSize);
            }
        }
        //

        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        graphics.drawString(getClass().getName(), 4 ,14);
    }
}
