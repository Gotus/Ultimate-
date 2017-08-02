import javax.swing.*;
import com.ultimate.core.CurrentGame;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private CurrentGame currentGame;

    private MainForm(){
        setContentPane(mainPanel);
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ultimate");
        setLocationRelativeTo(null);
        //setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainForm();
    }
}
