package controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

//MusicController starts to play clip with the path musicLocation
public class MusicController {
    private static String musicLocation;
    private static Clip clip;

    public MusicController( String musicLocation) throws LineUnavailableException {
        this.musicLocation = musicLocation;
        this.clip = AudioSystem.getClip();
        play();
    }

    //stops clip/music
    public void setClip() {
        clip.stop();
        clip.close();
    }

    //initializes clip and starts to play music if the given path exists
    public static void play(){
        try {
            File musicPath = new File(musicLocation);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip.open(audioInput);
                clip.start();
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
