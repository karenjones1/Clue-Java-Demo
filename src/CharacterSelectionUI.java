import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import AV_Components.AudioPlayer;
import Game_Constants.*;
import java.util.*;

public class CharacterSelectionUI extends JFrame implements ActionListener{

    private ArrayList<GamePiece> characters;
    private ArrayList<JButton> characterButtons;
    private ArrayList<GamePiece> selection;
    private int playerSelectNum;
    private MainUI mainWindow;

    public CharacterSelectionUI(){

        JPanel displayBox = new JPanel(new GridLayout(2,3,5,5));

        characters = new ArrayList<GamePiece>(6);
        characterButtons = new ArrayList<JButton>(6);
        selection = new ArrayList<GamePiece>(3);
        playerSelectNum = 0;

        for(GamePiece gamePiece : GamePiece.values()){
                JButton option = new JButton();
                option.setIcon(gamePiece.getCard().getImage());
                option.addActionListener(this);
                characterButtons.add(option);
                characters.add(gamePiece);
                displayBox.add(option);
        }

        add(displayBox);

        setSize(380, 400);
        setTitle("Select Your Character");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocation(520, 200);
        setVisible(true);
        setAlwaysOnTop(true);
    }

    public void actionPerformed(ActionEvent e){
        playerSelectNum++;

        for(int i=0; i<characterButtons.size(); i++){
            if(e.getSource() == characterButtons.get(i)){
                new AudioPlayer(characters.get(i).getCard().getName() + ".wav").play();
                characterButtons.get(i).setEnabled(false);
                selection.add(characters.get(i));
                setTitle("Select Opponent #" + playerSelectNum);
            }
        }

        if(playerSelectNum == 3){
            mainWindow = new MainUI(selection);
            dispose();
        }
    }
}
