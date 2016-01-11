package Game_Constants;

import javax.swing.*;

/** eNum GamePiece represents all usable game pieces in clue.  */
public enum GamePiece {

    //Game Pieces.
    GREEN(Rooms.BILLIARD, Card.GREEN, "Green Piece.png"),
    PLUM(Rooms.STUDY, Card.PLUM, "Plum Piece.png"),
    MUSTARD(Rooms.LOUNGE, Card.MUSTARD, "Mustard Piece.png"),
    SCARLET(Rooms.BALLROOM, Card.SCARLET, "Scarlet Piece.png"),
    PEACOCK(Rooms.CONSERVATORY, Card.PEACOCK, "Peacock Piece.png"),
    WHITE(Rooms.KITCHEN, Card.WHITE, "White Piece.png");

    private Rooms rooms;        //Starting locations.
    private Card card;          //Card equivalent.
    private ImageIcon image;    //Character Image.

    /* Constructor */
    GamePiece(Rooms rooms, Card card, String directory)
    {
        this.rooms = rooms;
        this.card = card;
        image = new ImageIcon("Images/Display/" + directory);
    }

    /* Get methods */
    public ImageIcon getImage() {return image;}
    public Card getCard() {return card; }
    public Rooms getRooms() {return rooms;}

}
