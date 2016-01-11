/** Created by RTracey on March 23rd, 2015  */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

import AV_Components.AudioPlayer;
import Game_Constants.*;

/** Clue NoteBook Window.  */
public class NoteBook extends JFrame implements ChangeListener, ActionListener{

    //Window Components.
    private JTabbedPane notebookTab;
    private JPanel suspectsTab, weaponsTab, locationsTab;

    //Timers.
    private Timer grow, shrink;

    //Card Back images.
    private final ImageIcon cardBack = new ImageIcon("Images/Cards/Cardback/Cardback.jpg");

    private AudioPlayer button, page;

    /** Constructor.  */
    public NoteBook(){

        //Create tabbed pane.
        notebookTab = new JTabbedPane();

        //Create Grid Panels for cards.
        suspectsTab = new JPanel(new GridLayout(2, 3, 5, 5));
        weaponsTab = new JPanel(new GridLayout(2, 3, 5, 5));
        locationsTab = new JPanel(new GridLayout(3, 3, 5, 5));

        //Populate panels.
        for(Card card : Card.values()){
            JToggleButton button = new JToggleButton();
            button.setIcon(card.getImage());
            button.setSelectedIcon(cardBack);
            if(card.getType() == 1)
                weaponsTab.add(button);
            else if(card.getType() == 2)
                locationsTab.add(button);
            else
                suspectsTab.add(button);

            button.addActionListener(this);
        }

        button = new AudioPlayer("Button.wav");
        page = new AudioPlayer("Page.wav");

        //Add panels to tabbed pane.
        notebookTab.addTab("Suspects", suspectsTab);
        notebookTab.addTab("Weapons", weaponsTab);
        notebookTab.addTab("Locations", locationsTab);

        notebookTab.addChangeListener(this);

        //Add tabbed pane to JFrame.
        add(notebookTab);

        //Set JFrame conditionals.
        setSize(380,460);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
        setLocation(800, 0);
        setVisible(false);

        //Timers for resizing animation.
        grow = new Timer(10, this);
        shrink = new Timer(10, this);

    }

    /** Triggers for resizing animations.  */
    public void stateChanged(ChangeEvent e){
        page.play();

        if(notebookTab.getSelectedIndex() == 2) {
            shrink.stop();
            grow.start();
        }
        else {
            grow.stop();
            shrink.start();
        }
    }

    /** Listeners for resizing animations.  */
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == grow){
            if(getHeight() < 640)
                setSize(380, getHeight()+20);
            else
                grow.stop();
        }
        else if(e.getSource() == shrink){
            if(getHeight() > 460)
                setSize(380, getHeight()-20);
            else
                shrink.stop();
        }
        else
            button.play();
    }
}
