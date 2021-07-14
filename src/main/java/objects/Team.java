package objects;

import java.util.concurrent.Callable;
import java.util.Date;

public class Team implements Callable<Long> {
    private String name;
    private Runner[] runners;

    public Team(String name, Runner[] runners) {
        this.name = name;
        this.runners = runners;
    }

    public String getName() {
        return name;
    }

    @Override
    public Long call() {
        Thread thread;
        Date start = new Date();

        for (Runner runner: runners) {
            thread = new Thread(runner);
            thread.start();

            try {
                thread.join();
                Thread.sleep(((Math.random() < 0.5) ? 1 : 2) * 500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        return new Date().getTime() - start.getTime();
    }
}
