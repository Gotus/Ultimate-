package baseGraphics;


import com.ultimate.core.CurrentGame;
import com.ultimate.core.gameObjects.Map;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActionScreen extends JPanel implements IAnimatable, IClickable{

    public static final int MIN_WIDTH = 300, MIN_HEIGHT = 300;
    CurrentGame currentGame;

    private class GraphicsData {
        final int cellSize = 64, borderSize = 5;
        final BufferedImage sell0Image = ImageIO.read(getClass().getResourceAsStream("/cell0.png"));
        final BufferedImage sell1Image = ImageIO.read(getClass().getResourceAsStream("/cell1.png"));
        final BufferedImage sellErrorImage = ImageIO.read(getClass().getResourceAsStream("/cellE.png"));

        private GraphicsData() throws IOException {
        }
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

    public ActionScreen(CurrentGame currentGame) throws IOException {
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
                BufferedImage cellImage;
                switch (cells[i][j]) {
                    case 0:
                        cellImage = graphicsData.sell0Image;
                        //graphics.setColor(Color.blue);
                        break;
                    case 1:
                        cellImage = graphicsData.sell1Image;
                        //graphics.setColor(Color.green);
                        break;
                    default:
                        cellImage = graphicsData.sellErrorImage;
                        //graphics.setColor(Color.red);
                }

                int x1 = i * (graphicsData.cellSize + graphicsData.borderSize) + animationData.mapDx;
                int y1 = j * (graphicsData.cellSize + graphicsData.borderSize) + animationData.mapDy;
                graphics.drawImage(cellImage, x1, y1,
                        graphicsData.cellSize, graphicsData.cellSize,
                        null);

                //graphics.fillRect(x1, y1, graphicsData.cellSize, graphicsData.cellSize);
            }
        }
        //

        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        graphics.drawString(getClass().getName(), 4 ,14);
    }
}
