package baseGraphics;


import com.ultimate.core.CurrentGame;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MainScreen extends JPanel implements IAnimatable, IClickable{

    public static final int BORDER_SIZE = 50;
    CurrentGame currentGame;

    Font mainFont;

    public ActionScreen actionScreen;
    public SubsidiaryScreen subsidiaryScreen;

    private int animationState = 0;

    public MainScreen(CurrentGame currentGame) throws IOException, FontFormatException {
        this.currentGame = currentGame;
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(new CompoundBorder(getBorder(),
                new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE)));

        actionScreen = new ActionScreen(currentGame);
        actionScreen.setMinimumSize(new Dimension(ActionScreen.MIN_WIDTH, ActionScreen.MIN_HEIGHT));
        actionScreen.setPreferredSize(new Dimension(ActionScreen.MIN_WIDTH, ActionScreen.MIN_HEIGHT));

        subsidiaryScreen = new SubsidiaryScreen(currentGame);
        subsidiaryScreen.setMinimumSize(new Dimension(SubsidiaryScreen.WIDTH, SubsidiaryScreen.MIN_HEIGHT));
        subsidiaryScreen.setPreferredSize(new Dimension(SubsidiaryScreen.WIDTH, SubsidiaryScreen.MIN_HEIGHT));
        subsidiaryScreen.setMaximumSize(new Dimension(SubsidiaryScreen.WIDTH, Integer.MAX_VALUE));

        add(actionScreen);
        add(Box.createRigidArea(new Dimension(BORDER_SIZE,0)));
        add(subsidiaryScreen);

        InputStream is = getClass().getResourceAsStream("/Alagard.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        mainFont = font.deriveFont(20f);
        
        setDoubleBuffered(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)  g;

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, getWidth(), getHeight());

        graphics.setColor(Color.white);
        graphics.setFont(mainFont);
        float fontHeight = mainFont.getLineMetrics("I", graphics.getFontRenderContext()).getHeight();
        graphics.drawString(getClass().getName(), 4 , fontHeight);

        graphics.drawString((animationState < 10 ? "0" : "") + Integer.toString(animationState), 4 , 2 * fontHeight);
        graphics.drawString(animationState < 20 ? "tick" : "tack", 4 ,3 * fontHeight);
    }

    @Override
    public void animate() {
        animationState++;
        animationState %= 40;
        actionScreen.animate();
        subsidiaryScreen.animate();
    }

    @Override
    public void click(int x, int y) {
        actionScreen.click(x - actionScreen.getX(), y - actionScreen.getY());
        subsidiaryScreen.click(x - subsidiaryScreen.getX(), y - subsidiaryScreen.getY());
    }
}
