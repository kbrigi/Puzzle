package controller;

import model.Timer;

/**
 *  runs while time reaches endtime and reduces the value of current time each second
 */
public class TimerController implements Runnable {
    private Timer timer;
    private TimerViewer timerViewer;
    public TimerController(Timer tm, TimerViewer tw) {
        this.timer = tm;
        this.timerViewer = tw;

    }

    @Override
    public void run() {
        while(timer.getCurrsec() > timer.getEndsec() || timer.getCurrmin() > timer.getEndmin()){
            timerViewer.repaint();
            if(timer.getCurrsec() - 1 < 0){
                timer.setCurrmin(timer.getCurrmin() - 1);
                timer.setCurrsec(59);
            }
            else {
                timer.setCurrsec(timer.getCurrsec() - 1);
            }
            try{
                Thread.sleep(timer.getDiff());
            }
            catch (InterruptedException e) {
                System.out.println("Hiba lepett fel a szal vegrehajtasanal");
            }
        }
    }

}
