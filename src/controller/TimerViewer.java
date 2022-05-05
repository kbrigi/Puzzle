package controller;

import model.Timer;

import javax.swing.*;
import java.awt.*;

/**
 * sets the view of the timer
 */
public class TimerViewer extends JPanel {
    private Timer timer;

    public TimerViewer(Timer tm){
        this.timer =tm;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.CENTER_BASELINE,25));
        g.setColor(Color.black);
        if(timer.getCurrmin() < 10 && timer.getCurrsec() > 10)
            g.drawString("0"+String.valueOf(timer.getCurrmin()) + " : " + (timer.getCurrsec()), 50,50);
        else if(timer.getCurrmin() < 10 && timer.getCurrsec() < 10)
            g.drawString(String.valueOf("0"+ timer.getCurrmin()) + " : " + "0" + (timer.getCurrsec()), 50,50);
        else if(timer.getCurrmin() > 10 && timer.getCurrsec() < 10)
            g.drawString(String.valueOf(timer.getCurrmin()) + " : " + "0" + (timer.getCurrsec()), 50,50);
            else
                g.drawString(String.valueOf(timer.getCurrmin()) + " : " + (timer.getCurrsec()), 50,50);
    }
}

