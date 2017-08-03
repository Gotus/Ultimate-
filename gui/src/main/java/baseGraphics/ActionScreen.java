package baseGraphics;


import com.ultimate.core.CurrentGame;

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
        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        graphics.drawString(getClass().getName(), 4 ,14);
    }
}
