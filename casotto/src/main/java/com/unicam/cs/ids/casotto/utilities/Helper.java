package com.unicam.cs.ids.casotto.utilities;
import java.util.Timer;
import java.util.TimerTask;

public class Helper extends TimerTask {
    public static int i = 0;

    public void run()
    {
        System.out.println("Timer ran " +i);
        Timer timer = new Timer();
        TimerTask task = new Helper();
        timer.schedule(task, 2000, 5000);

    }

}

