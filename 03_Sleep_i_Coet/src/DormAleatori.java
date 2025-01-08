import java.util.Random;

public class DormAleatori extends Thread {
    private long startTime;

    public DormAleatori(String name) {
        super(name);
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) { 

            int intervalAleatori = random.nextInt(1000);
            long tempsTotal = System.currentTimeMillis() - startTime;

            System.out.printf("%s(%d) a dormir %dms total %d\n", getName(), i, intervalAleatori, tempsTotal);

            try {
                Thread.sleep(intervalAleatori);
            } catch (InterruptedException e) {
                System.out.printf("%s interromput!\n", getName());
            }
        }
    }

    public static void main(String[] args) {

        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();
        
        System.out.println("-- Fi de main -----------");

    }
}

