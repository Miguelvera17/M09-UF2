import java.util.Random;

public class Filosof extends Thread {

    private final int id;
    private final Forquilla left;
    private final Forquilla right;
    private final Random random = new Random();
    private int win = 0;

    public Filosof(int id, Forquilla left, Forquilla right) {
        this.id = id;
        this.left = left;
        this.right = right;
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (left.get(id, false)) {
                if (right.get(id, true)) {
                    System.out.println("Filosof: fil" + id + " menja");
                    Thread.sleep(random.nextInt(1000) + 1000); 
                    System.out.println("Filosof: fil" + id + " ha acabat de menjar");
                    right.leave();
                    left.leave();
                    win = 0;
                    return;
                } else {
                    left.leave();
                    win++;
                    System.out.println("Filosof: fil" + id + " deixa l'esquerra(" + left.getId() + ") i espera (dreta ocupada)");
                    System.out.println("Filosof: fil" + id + " gana=" + win);
                }
            } else {
                win++;
                System.out.println("Filosof: fil" + id + " no pot agafar l'esquerra(" + left.getId() + "), espera");
                System.out.println("Filosof: fil" + id + " gana=" + win);
            }
            Thread.sleep(random.nextInt(500) + 500); 
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosof: fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); 
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                menjar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
