import java.util.Random;

public class Filosof extends Thread {

    private final String name;

    private long iniciGana;
    private long fiGana;
    private long gana;

    private final Forquilla forquillaEsquerra;
    private final Forquilla forquillaDreta;

    private Random random;

    public Filosof(String name, Forquilla forquillaEsquerra, Forquilla forquillaDreta) {
        this.name = name;
        this.forquillaEsquerra = forquillaEsquerra;
        this.forquillaDreta = forquillaDreta;
        this.gana = 0;
        this.random = new Random();
    }

    public void agafarForquilles() {
        forquillaEsquerra.agafar();
        forquillaDreta.agafar();
        System.out.println(
            name + " té forquilles esq(" + forquillaEsquerra.getNum() + ") dreta(" + forquillaDreta.getNum() + ")");

    }

    public void deixarForquilles() {
        forquillaDreta.deixar();
        forquillaEsquerra.deixar();
        System.out.println(name + " deixa les forquilles");

    }

    public void menjar() throws InterruptedException {
        agafarForquilles();
        calcularGana();
        System.out.println(name + " menja amb gana " + gana + " segons");
        Thread.sleep(1000 + random.nextInt(1000));
        System.out.println(name + " ha acabat de menjar");
        resetGana();
        deixarForquilles();
    }

    public void pensar() throws InterruptedException {
        iniciGana = System.currentTimeMillis(); 
        System.out.println(name + " està pensant");
        Thread.sleep(1000 + random.nextInt(1000));
    }


    public void calcularGana() {
        fiGana = System.currentTimeMillis();
        gana = (fiGana - iniciGana) / 1000;
    }

    public void resetGana() {
        iniciGana = System.currentTimeMillis();
        gana = 0;
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