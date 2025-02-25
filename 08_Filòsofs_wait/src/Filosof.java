import java.util.Random;

public class Filosof extends Thread {
    private final Random random = new Random();
    private final int id;
    private int gana = 0;
    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;
    
    public Filosof(int id, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.id = id;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filòsof: fil" + id + " pensant");
        Thread.sleep(random.nextInt(1000) + 1000);
    }

    private synchronized void agafarForquilla(Forquilla forquilla) throws InterruptedException {
        while (!forquilla.estaLliure()) {
            wait();
        }
        System.out.println("Filòsof: fil" + id + " agafa la forquilla " + forquilla.getId());
    }

    private synchronized void deixarForquilla(Forquilla forquilla) {
        System.out.println("Filòsof: fil" + id + " deixa la forquilla " + forquilla.getId());
        notifyAll();
    }

    private boolean agafarForquilles() throws InterruptedException {
        agafarForquilla(forquillaEsquerra);
        
        if (!forquillaDreta.estaLliure()) {  
            System.out.println("Filòsof: fil" + id + " deixa l'esquerra (" + forquillaEsquerra.getId() + ") i espera (dreta ocupada)");
            deixarForquilla(forquillaEsquerra);
            gana++;
            System.out.println("Filòsof: fil" + id + " gana=" + gana);
            Thread.sleep(random.nextInt(500) + 500);
            return false;
        }

        agafarForquilla(forquillaDreta);
        return true;
    }

    private void deixarForquilles() {
        deixarForquilla(forquillaEsquerra);
        deixarForquilla(forquillaDreta);
    }

    private void menjar() throws InterruptedException {
        while (true) {
            if (agafarForquilles()) {
                System.out.println("Filòsof: fil" + id + " menja");
                Thread.sleep(random.nextInt(1000) + 1000);
                System.out.println("Filòsof: fil" + id + " ha acabat de menjar");
                deixarForquilles();
                gana = 0;
                return;
            }
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                menjar();
                pensar();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
