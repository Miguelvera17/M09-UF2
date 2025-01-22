import java.util.Random;

public class Soci implements Runnable {
    private static final float APORTACIO = 10.0f;
    private static final int ESPERA_MAX = 100;
    private static final int MAX_ANY = 10;
    private final Compte compte;
    private final Random random;

    public Soci() {
        this.compte = Compte.getInstance();
        this.random = new Random();
    }

    public Compte getCompte() {
        return compte;
    }

    @Override
    public void run() {
        for (int any = 1; any <= MAX_ANY; any++) {
            for (int mes = 1; mes <= 12; mes++) {
                if (mes % 2 == 0) {
                    compte.ingresa(APORTACIO);
                } else {
                    compte.treu(APORTACIO);
                }

                try {
                    Thread.sleep(random.nextInt(ESPERA_MAX));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
