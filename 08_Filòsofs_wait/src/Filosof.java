import java.util.Random;

public class Filosof extends Thread {

    private final int id;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    private final Random random = new Random();
    private int gana = 0;

    public Filosof(int id, Forquilla left, Forquilla right) {
        this.id = id;
        this.forquillaEsquerra = left;
        this.forquillaDreta = right;
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (forquillaEsquerra.get(id, false)) {
                if (forquillaDreta.get(id, true)) {
                    System.out.println("Filosof: fil" + id + " menja");
                    Thread.sleep(random.nextInt(1000) + 1000); 
                    System.out.println("Filosof: fil" + id + " ha acabat de menjar");
                    forquillaDreta.leave();
                    forquillaEsquerra.leave();
                    gana = 0;
                    return;
                } else {
                    forquillaEsquerra.leave();
                    gana++;
                    System.out.println("Filosof: fil" + id + " deixa l'esquerra(" + forquillaEsquerra.getId() + ") i espera (dreta ocupada)");
                    System.out.println("Filosof: fil" + id + " gana=" + gana);
                }
            } else {
                gana++;
                System.out.println("Filosof: fil" + id + " no pot agafar l'esquerra(" + forquillaEsquerra.getId() + "), espera");
                System.out.println("Filosof: fil" + id + " gana=" + gana);
            }
            Thread.sleep(random.nextInt(500) + 500); 
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filosof: fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000); 
    }

    private void agafarForquilles() {
        
    }

    private void deixarForquilles() {

    }

    private void agafaForquillaEsquerra() {

    }

    private void agafaForquillaDreta() {

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
