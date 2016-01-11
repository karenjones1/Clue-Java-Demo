package Game_Constants;

import javax.swing.*;

/** eNum Dice represents each side of a 6-sided die.  */
public enum Dice {

    //Sides of a 6-sided dice.
    ONE(1, "one.jpg"), TWO(2, "two.jpg"), THREE(3, "three.jpg"),
    FOUR(4, "four.jpg"), FIVE(5, "five.jpg"), SIX(6, "six.jpg");

    private int side;           //Numerical value of dice side
    private ImageIcon image;    //Image of dice side.

    /** Constructor  */
     Dice(int side, String directory){
        this.side = side;
        image = new ImageIcon("Images/Dice/" + directory);
    }

    /** Get Methods  */
    public ImageIcon getImage() {return image;}
    public int getSide() {return side;}
}
