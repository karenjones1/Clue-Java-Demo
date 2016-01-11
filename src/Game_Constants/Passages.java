package Game_Constants;

import java.awt.*;

/** eNum Passages represents all intermediary positions on the board.  */
public enum Passages {

    //Hall Areas.
    HALL_A(167,127), HALL_B(234,168), HALL_C(166,295), HALL_D(234,360),
    HALL_E(144,402), HALL_F(368, 189), HALL_G(368, 359);

    private Point position;     //Location of Hall tile.

    /** Constructor  */
    Passages(int xPos, int yPos){
        position = new Point(xPos, yPos);
    }

    /** Get Methods  */
    public Point getPosition() {return position; }
}
