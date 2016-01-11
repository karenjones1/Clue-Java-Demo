import oracle.jrockit.jfr.JFR;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class InstructionUI extends JFrame {

    private JLabel label;
    private JScrollPane jScrollPane;

    /** Constructor.  */
    public InstructionUI() {

        /** Insert label into a scroll pane */
        String content = "<html>\n" +
                "<div style=\"margin: 5px; border: 5px double white;\">"+
                "\t<h1>Instructions</h1>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Object</h3>\n" +
                "\t<p>\n" +
                "\t\tThe object of the game is to determine the name of the murderer, the weapon used, and in which room the<br> murder happened at.\n" +
                "\t</p>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Setup</h3>\n" +
                "\t<p>\n" +
                "\t\tTo start the game, hit the “Start” button on the main menu. You will be directed to choose a character<br> and a new window will open with board game. You are ready to play!\n" +
                "\t</p>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h1>Gameplay</h1>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Movement</h3>\n" +
                "\t<p>\n" +
                "\t\tTo move around the board you need to click on the room that you want to go to and you’ll roll<br> a dice to determine how many steps you can take. You will not be allowed to change your destination once<br> you are in the hallway. \n" +
                "\t</p>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Rolling</h3>\n" +
                "\t<p>\n" +
                "\t\tEvery turn you will roll a dice to determine how many steps you are allowed to take.\n" +
                "\t</p>\n" +
                "\t<ul>\n" +
                "\t\t<li>If you rolled a high enough number, you will be allowed into the room. </li>\n" +
                "\t\t<li>If not, you will have to wait in the hallway outside the room until you roll enough to gain entrance to that room.</li>\n" +
                "\t\t<li>If you are in a hallway, your dice will roll automatically when your turn starts and you will either move<br> to your destination or remain in the hallway.</li>\n" +
                "\t</ul>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Secret Passages</h3>\n" +
                "\t<p>\n" +
                "\t\tThe rooms located the corners of the board have secret passages.\n" +
                "\t</p>\n" +
                "\t<ul>\n" +
                "\t\t<li>You can use the secret passage from the Study to the Kitchen, or vice versa.</li>\n" +
                "\t\t<li>You can use the secret passage from the Conservatory to the Lounge, or vice versa.</li>\n" +
                "\t</ul>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Making an Assumption</h3>\n" +
                "\t<p>\n" +
                "\t\tAs soon as you enter a room, you will be allowed to make an assumption based on the room you are located in. \n" +
                "\t</p>\n" +
                "\t<ul>\n" +
                "\t\t<li>Player cannot make an assumption on the first turn, unless they get to a new room during that turn.</li>\n" +
                "\t\t<li>Player can only make an assumption when they are in a room, and the assumption must include that room. </li>\n" +
                "\t</ul>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>Making an Accusation</h3>\n" +
                "\t<p>\n" +
                "\t\tAs soon as you enter a room, you will be allowed to make an accusation. Warning, making an<br> accusation will end the game. \n" +
                "\t</p>\n" +
                "\t<ul>\n" +
                "\t\t<li>Accusations can happen at any time before or after the player has moved and after<br> they’ve made an assumption.</li>\n" +
                "\t\t<li>If your accusation is correct, you win the game!</li>\n" +
                "\t\t<li>However, if your accusation is incorrect, the game will end and you have lost the game and<br> the murderer is still at large!</li>\n" +
                "\t</ul>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>How to Disprove</h3>\n" +
                "\t<p>\n" +
                "\t\tAfter an assumption is made, the players will attempt to disprove the assumption.\n" +
                "\t</p>\n" +
                "\t<ul>\n" +
                "\t\t<li>If a player can disprove you, they will show you the card, or choose among their cards,<br> that proves your assumption wrong.</li>\n" +
                "\t\t<li>If you can disprove another player, then you can choose one of the cards in your hand<br> that proves another player’s assumption false.</li>\n" +
                "\t</ul>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "\t<h3>The Notebook</h3>\n" +
                "\t<p>\n" +
                "\t\tOn the board you will be able to select a “Notebook” button that opens your personal Notebook. You should<br> keep track of all the cards that you’ve proved right or wrong in this window.\n" +
                "\t</p>\n" +
                "\t<br>\n" +
                "\t<br>\n" +
                "</div>" +
                "</html>";


        label = new JLabel(content);

        label.setForeground(Color.WHITE);
        jScrollPane = new JScrollPane(label);

        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.getViewport().setBackground(Color.BLACK);

        add(jScrollPane, BorderLayout.CENTER);
        setSize(800, 800);
        setTitle("Instructions");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}