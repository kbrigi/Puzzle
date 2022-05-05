package model;

/**
 * timer with with currenttime, endtime and difference between steps
 */
public class Timer {
    private int endmin, endsec, currmin, currsec;
    private int diff;

    public Timer(int startmin, int startsec, int endmin, int endsec, int diff) {
        this.endmin = endmin;
        this.endsec = endsec;
        this.currmin = startmin;
        this.currsec = startsec;
        this.diff = diff;
    }

    public int getEndmin() {
        return endmin;
    }

    public int getEndsec() {
        return endsec;
    }

    public int getCurrmin() {
        return currmin;
    }

    public int getCurrsec() {
        return currsec;
    }

    public int getDiff() {
        return diff;
    }

    public void setCurrmin(int curr) {
        this.currmin = curr;
    }

    public void setCurrsec(int curr) {
        this.currsec = curr;
    }

}

