package Game_Constants;

import java.awt.*;
import java.awt.geom.Area;

/** eNum Rooms represents all selectable locations on the board.  */
public enum Rooms {

    //Rooms
    STUDY(new Area(new Rectangle(40,50,160,90)), 55, 75, "Study"),
    LIBRARY(new Area(new Rectangle(40,180,160,100)), 55, 215, "Library"),
    BILLIARD(new Area(new Rectangle(40,300,140,105)), 55, 340, "Billiard Room"),
    CONSERVATORY(new Area(new Rectangle(40,455,140,110)), 55, 490, "Conservatory"),
    HALL(new Area(new Rectangle(250,60,130,135)), 255, 125, "Hall"),
    BALLROOM(new Area(new Rectangle(230,415,175,125)), 255, 470, "Ballroom"),
    LOUNGE(new Area(new Rectangle(430,50,155,125)), 460, 105, "Lounge"),
    DININGROOM(new Area(new Rectangle(405,240,185,145)), 460, 300, "Dining Room"),
    KITCHEN(new Area(new Rectangle(450,435,140,140)), 460, 490, "Kitchen");

    private Area boundaryBox;   //Mapped boundary for room.
    private int xPos;           //X-Position of Game Piece origin in room.
    private int yPos;           //Y-Position of Game Piece origin in room.
    private Point position;     //Position of Game Piece given as point.
    private String name;        //String name of room, primarily for file IO.

    /** Constructor.  */
    Rooms(Area boundaryBox, int xPos, int yPos, String name){
        this.boundaryBox = boundaryBox;
        this.xPos = xPos;
        this.yPos = yPos;
        position = new Point(xPos, yPos);
        this.name = name;
    }

    /** Get Methods  */
    public Area getBoundaryBox() {return boundaryBox;}
    public int getXPos() {return xPos; }
    public int getYPos() {return yPos; }
    public Point getPosition() { return position; }
    public String getName() {return name;}

}
