import objects.*;
import threads.Relay;

public class Main {
    public static void main(String[] args) {
        Runner[] firstTeamRunners = {
                new Runner("Роман"), new Runner("Владимир"),
                new Runner("Илья"), new Runner("Виктория")
        };

        Runner[] secondTeamRunners = {
                new Runner("Василий"), new Runner("Павел"),
                new Runner("Руслан"), new Runner("Диана")
        };

        Team firstTeam = new Team("Турникмены", firstTeamRunners);
        Team secondTeam = new Team("Качки", secondTeamRunners);

        Relay commonRelay = new Relay(firstTeam, secondTeam);
        commonRelay.run();
    }
}
