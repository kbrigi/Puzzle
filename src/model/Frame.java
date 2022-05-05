package model;

import controller.MusicController;
import controller.PuzzlePanel;
import controller.TimerController;
import controller.TimerViewer;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Frame {
    private JFrame frame;
    private Thread thread;
    private PuzzlePanel puzzlePanel;

    public Frame() throws IOException, LineUnavailableException {
        //creates a frame
        frame = new JFrame();
        frame.setSize(1000, 800);
        frame.setTitle("Puzzle");
        frame.setLocationRelativeTo(null);

        addTimer();

        // creates a puzzlepanel and adds it to the frame
        puzzlePanel = new PuzzlePanel();
        frame.getContentPane().add(puzzlePanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        //starts to play music
        MusicController musicController = new MusicController("src/resources/music/Art-Of-Silence.wav");

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
                                    @Override
                                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                                        musicController.setClip();
                                        System.exit(0);
                                    }
                                }
        );

        timesUp();

    }

    //starts a timer thread
    public void addTimer(){
        Timer timermodel = new Timer(1, 20, 0, 0, 1000);
        TimerViewer timerViewer = new TimerViewer(timermodel);
        TimerController timerController = new TimerController(timermodel, timerViewer);
        thread = new Thread(timerController);

        thread.start();

        //adds the timer to a panel and the panel to the frame
        JPanel timer = new JPanel();
        timer.setPreferredSize(new Dimension(200, 70));
        frame.add(timerViewer);
        frame.getContentPane().add(timer, BorderLayout.NORTH);
    }

    //checks if thread terminated and stops the game with a message
    public void timesUp(){
        while(true){

            if(thread.getState()==Thread.State.TERMINATED){
                puzzlePanel.end("Game over");
                break;
            }
        }
    }

}
