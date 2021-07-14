package threads;

import objects.Team;
import java.util.concurrent.*;

public class Relay {
    Team firstTeam, secondTeam;
    Team relayWinner;

    public Relay(Team firstTeam, Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    private static void printLine() {
        System.out.println("-".repeat(21));
    }

    public void run() {
        System.out.println("Эстафета началась!");
        printLine();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Long> firstTeamThread = executorService.submit(firstTeam);
        Future<Long> secondTeamThread = executorService.submit(secondTeam);

        try {
            relayWinner = (firstTeamThread.get() < secondTeamThread.get()) ? firstTeam : (
                          (secondTeamThread.get() < firstTeamThread.get()) ? secondTeam : null
                    );
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }

        executorService.shutdown();

        printLine();
        System.out.println("Эстафета закончилась!");

        if (relayWinner != null) {
            System.out.println("Победила команда: " + relayWinner.getName());
        } else {
            System.out.println("Ничья!");
        }
    }
}
