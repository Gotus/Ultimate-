import javax.swing.*;

import baseGraphics.ActionScreen;
import baseGraphics.MainScreen;
import baseGraphics.Stub;
import baseGraphics.SubsidiaryScreen;
import com.ultimate.core.CurrentGame;

import java.awt.*;

import static baseGraphics.MainScreen.BORDER_SIZE;

public class MainForm extends JFrame {
    private final static int startWidth = 800, startHeight = 600;
    private CurrentGame currentGame;
    private MainScreen mainScreen;

    private Timer timer = new Timer(50, e -> {
        mainScreen.animate();
        mainScreen.repaint();
    });

    private MainForm() {

        Stub.generateMap(10,10);

        mainScreen = new MainScreen(currentGame);
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
        timer.start();
    }

    public static void main(String[] args) {
        new MainForm();
    }
}
