package org.web1.utils.time;

public class Stopwatch {
    private long startTime;
    public void start() {
        this.startTime = System.nanoTime();
    }
    public long stop() {
        return System.nanoTime() - this.startTime;
    }
}
