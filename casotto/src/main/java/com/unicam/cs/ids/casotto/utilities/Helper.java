package com.unicam.cs.ids.casotto.utilities;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.Timer;
import java.util.TimerTask;

public class Helper {
    Timer timer;

    public Helper(int minutes) {
        timer = new Timer();
        timer.schedule(new StopTask(), minutes);
    }

    public static void main(String[] args) {
        new Helper(1);
        System.out.println("StopWatch Started.");
    }

    class StopTask extends TimerTask {
        public void run() {
            System.out.println("Time Up!");
            timer.cancel();
        }
    }
}


