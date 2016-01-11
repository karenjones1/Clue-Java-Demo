package Game_Constants;

import javax.swing.*;

/** eNum Card represents all cards present in the game.  */
public enum Card {

    //Weapons
    KNIFE("Knife", 1), ROPE("Rope", 1), CANDLESTICK("Candlestick", 1),
    REVOLVER("Revolver", 1), PIPE("Lead Pipe", 1), WRENCH("Wrench", 1),

    //Locations
    KITCHEN("Kitchen", 2), BALLROOM("Ballroom", 2), CONSERVATORY("Conservatory", 2),
    BILLIARD("Billiard Room", 2), LIBRARY("Library", 2), STUDY("Study", 2),
    HALL("Hall", 2), LOUNGE("Lounge", 2), DININGROOM("Dining Room", 2),

    //Suspects
    SCARLET("Miss Scarlet", 3), GREEN("Mr Green", 3), PLUM("Prof Plum", 3),
    PEACOCK("Mrs Peacock", 3), MUSTARD("Col Mustard", 3), WHITE("Mrs White", 3);


    private String name;        //Card's name.
    private ImageIcon image;    //Image on Card.
    private int type;           //Whether card is 1)Weapon, 2)Location, 3)Suspect.

    /** Constructor  */
    Card(String name, int type){

        //Set variables.
        this.name = name;
        this.type = type;

        //Directory of image is based on card type.
        switch (type){
            case 1:     //Weapon
                image = new ImageIcon("Images/Cards/Weapon/" + name + ".jpg");
                break;

            case 2:     //Location
                image = new ImageIcon("Images/Cards/Locations/" + name + ".jpg");
                break;

            case 3:     //Suspect
                image = new ImageIcon("Images/Cards/Suspects/" + name + ".jpg");
                break;
        }
    }

    /** Get Methods for Card values  */
    public String getName(){return name; }
    public ImageIcon getImage(){ return image; }
    public int getType(){ return type; }

}
