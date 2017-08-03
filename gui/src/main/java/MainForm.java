import javax.swing.*;

import baseGraphics.ActionScreen;
import baseGraphics.MainScreen;
import baseGraphics.SubsidiaryScreen;
import com.ultimate.core.CurrentGame;

import java.awt.*;

import static baseGraphics.MainScreen.BORDER_SIZE;

public class MainForm extends JFrame {
    private final static int startWidth = 800, startHeight = 600;
    private CurrentGame currentGame;
    private MainScreen mainScreen;

    private MainForm() {

        mainScreen = new MainScreen();
        mainScreen.setMinimumSize(new Dimension(ActionScreen.MIN_WIDTH + SubsidiaryScreen.WIDTH + 3 * BORDER_SIZE,
                ActionScreen.MIN_HEIGHT + 2 * BORDER_SIZE));
        setContentPane(mainScreen);

        pack();
        setMinimumSize(getSize());
        setSize(new Dimension(startWidth, startHeight));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ultimate");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainForm();
    }
}