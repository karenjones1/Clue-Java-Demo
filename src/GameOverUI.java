import javax.swing.*;
import AV_Components.*;

/** Class is a placeholder for Game-Ending screen. */
public class GameOverUI extends JFrame{

    /** Constructor.  */
    public GameOverUI(String display){
        JPanel panel = new JPanel();
        JLabel message = new JLabel("", new ImageIcon(display), JLabel.CENTER);

        if(display.equals("Images/Display/Main Menu/win_screen.png"))
            new AudioPlayer("Win.wav").play();
        else
            new AudioPlayer("Lose.wav").play();

        panel.add(message);
        add(panel);

        setSize(800,800);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
