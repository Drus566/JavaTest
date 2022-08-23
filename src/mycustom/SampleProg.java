package mycustom;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SampleProg {
    Timer timer;

    SampleProg() {
        new Timer().schedule(new TaskTimer(), 0, 500);
    }

    public static void main(String ...args) {
        SampleProg prog = new SampleProg();
    }
}

class TaskTimer extends TimerTask {
    Random r;

    TaskTimer() {
        r = new Random();
    }

    @Override
    public void run() {
        char a = (char) (r.nextInt(26) + 'a');
        char b = (char) (r.nextInt(26) + 'a');
        char c = (char) (r.nextInt(26) + 'a');
        char d = (char) (r.nextInt(26) + 'a');
        char e = (char) (r.nextInt(26) + 'a');

        System.out.println(a + " " + b + " " + c + " " + d + " " + e);
    }
}
