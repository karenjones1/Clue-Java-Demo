package AV_Components;

import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;
import java.awt.Font;
import java.io.*;

/** CustomFont chosen for in-game Console.  */
public class CustomFont{

    public static Font getFont(){

        Font font = null;

        try{
            font = Font.createFont(Font.TRUETYPE_FONT, new File("Font/snell/Snell Roundhand Script.ttf"));
            font = font.deriveFont(Font.BOLD, 20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

        return font;
    }
}