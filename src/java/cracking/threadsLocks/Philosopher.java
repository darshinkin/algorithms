package cracking.threadsLocks;

public class Philosopher extends Thread {

    private int bites = 10;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
    }

    public void eat() {
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    private void putDown() {
        left.putDown();
        right.putDown();
    }

    private void chew() {
        System.out.println("Eating!");
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }*/
    }

    private boolean pickUp() {
        if (!left.pickUp()) {
            System.out.println("pickUp is false");
            return false;
        }
        if (right.pickUp()) {
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public static void main(String[] args) {
        Chopstick left = new Chopstick();
        Chopstick right = new Chopstick();
        new Philosopher(left, right).start();
    }
}
