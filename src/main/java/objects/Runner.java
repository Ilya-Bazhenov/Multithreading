package objects;

public class Runner implements Runnable {
    private String name;

    public Runner(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int distance = 0;

        while (distance < 10) {
            distance += (distance == 9 || Math.random() < 0.5) ? 1 : 2;
            System.out.println(String.format("%s пробежал %d метров", name, distance));
        }
    }
}
