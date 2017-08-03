package baseGraphics;


import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainScreen extends JPanel implements IAnimatable, IClickable{

    public static final int BORDER_SIZE = 50;

    public ActionScreen actionScreen;
    public SubsidiaryScreen subsidiaryScreen;

    public MainScreen() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(new CompoundBorder(getBorder(),
                new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE)));

        actionScreen = new ActionScreen();
        actionScreen.setMinimumSize(new Dimension(ActionScreen.MIN_WIDTH, ActionScreen.MIN_HEIGHT));
        actionScreen.setPreferredSize(new Dimension(ActionScreen.MIN_WIDTH, ActionScreen.MIN_HEIGHT));

        subsidiaryScreen = new SubsidiaryScreen();
        subsidiaryScreen.setMinimumSize(new Dimension(SubsidiaryScreen.WIDTH, SubsidiaryScreen.MIN_HEIGHT));
        subsidiaryScreen.setPreferredSize(new Dimension(SubsidiaryScreen.WIDTH, SubsidiaryScreen.MIN_HEIGHT));
        subsidiaryScreen.setMaximumSize(new Dimension(SubsidiaryScreen.WIDTH, Integer.MAX_VALUE));

        add(actionScreen);
        add(Box.createRigidArea(new Dimension(BORDER_SIZE,0)));
        add(subsidiaryScreen);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)  g;
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, getWidth(), getHeight());
        graphics.setColor(Color.white);
        graphics.drawString(getClass().getName(), 4 ,14);
    }

    @Override
    public void Animate() {
        actionScreen.Animate();
        subsidiaryScreen.Animate();
    }

    @Override
    public void Click(int x, int y) {
        actionScreen.Click(x - actionScreen.getX(), y - actionScreen.getY());
        subsidiaryScreen.Click(x - subsidiaryScreen.getX(), y - subsidiaryScreen.getY());
    }
}
