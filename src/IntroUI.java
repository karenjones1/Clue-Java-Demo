import AV_Components.AudioPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;

/** IntroUI Window displays Title image and 'Play' / 'Instructions' options.  */
public class IntroUI extends JFrame implements ActionListener, MouseListener{

    //Frame Components.
    private Area start_box, instruction_box;
    private Timer showTitleCourse, showMain;
    private JLabel label;
    private AudioPlayer button, scream;
    private InstructionUI instructionWindow;
    private CharacterSelectionUI characterWindow;

    /** Constructor.  */
    public IntroUI(){

        //Construct Components.
        JPanel panel = new JPanel(new BorderLayout());
        label = new JLabel("", new ImageIcon("Images/Display/Main Menu/BlackOut.png"), JLabel.CENTER);
        panel.add(label, BorderLayout.CENTER);

        //Add Listener to Mouse.
        label.addMouseListener(this);

        //Set Bounding Boxes for clickable positions.
        start_box = new Area(new Rectangle(254,694, 96, 32));
        instruction_box = new Area(new Rectangle(460, 694, 96, 32));

        //Construct Frame.
        add(panel);
        setTitle("Clue Game");
        setSize(810, 810);
        setLocation(300, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);

        AudioPlayer.loopMain(true);
        button = new AudioPlayer("Button.wav");

        showTitleCourse = new Timer(4000, this);
        showMain = new Timer(3000, this);
        showTitleCourse.setRepeats(false);
        showMain.setRepeats(false);
        showTitleCourse.start();
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == showTitleCourse){
            label.setIcon(new ImageIcon("Images/Display/Main Menu/TitleCourse.png"));
            scream = new AudioPlayer("Scream.wav");
            scream.play();
            showMain.start();
        }
        if (e.getSource() == showMain)
            label.setIcon(new ImageIcon("Images/Display/Main Menu/Title.png"));

    }
    /** Mouse Listener detects clicks within bounded areas.  */
    public void mouseClicked(MouseEvent e){

        //If mouse click was within 'Start' area.
        if(start_box.contains(e.getPoint())) {
            button.play();
            characterWindow = new CharacterSelectionUI();
            dispose();

        }

        //If mouse click was within 'Instructions' area.
        if(instruction_box.contains(e.getPoint())) {
            button.play();
            instructionWindow = new InstructionUI();
        }
    }

    /** Required for abstract implementation, but not used. */
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}

}
