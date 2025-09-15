package org.web1.timer;

public class Timer {
    long startTime;
    public void start() {
        this.startTime = System.nanoTime();
    }
    public long stop() {
        return System.nanoTime() - this.startTime;
    }
}
