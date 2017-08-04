package baseGraphics;


import com.ultimate.core.CurrentGame;
import com.ultimate.core.gameObjects.Map;

import javax.swing.*;
import java.awt.*;

public class ActionScreen extends JPanel implements IAnimatable, IClickable{

    public static final int MIN_WIDTH = 300, MIN_HEIGHT = 300;
    CurrentGame currentGame;

    public ActionScreen(CurrentGame currentGame) {
        this.currentGame = currentGame;
    }

    @Override
    public void click(int x, int y) {

    }

    @Override
    public void animate() {

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

                int cellSize = 50, borderSize = 5;

                graphics.fillRect(i * (cellSize + borderSize),
                                  j * (cellSize + borderSize),
                                  cellSize, cellSize);
            }
        }
        //

        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        graphics.drawString(getClass().getName(), 4 ,14);
    }
}
