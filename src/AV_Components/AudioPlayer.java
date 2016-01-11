package AV_Components;

import javax.sound.sampled.*;
import java.applet.*;
import java.net.*;
import java.io.*;

public class AudioPlayer{

    private AudioClip audio;
    private String fileName;
    private static Clip audioClip;

    public AudioPlayer(String fileName) {
        this.fileName = fileName;
    }

    public void play() {
        try {
            audio = Applet.newAudioClip(new URL("file:Audio/" + fileName));
            audio.play();
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        }
    }

    /** This code was retrieved from an online source. See reference page of report for full details.
     *  */
    public static void loopMain(boolean toggle){

        if(toggle) {
            try {
                File mainAudio = new File("Audio/Main.wav");
                AudioInputStream repeater = AudioSystem.getAudioInputStream(mainAudio);

                AudioFormat format = repeater.getFormat();
                DataLine.Info info = new DataLine.Info(Clip.class, format);

                audioClip = (Clip) AudioSystem.getLine(info);
                audioClip.open(repeater);
                audioClip.loop(Clip.LOOP_CONTINUOUSLY);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else
            try{
                audioClip.stop();
            }
            catch(NullPointerException e){
                System.out.println("Loop Not Started.");
            }
    }

    public void stop(){
        audio.stop();
    }

}
