public class Asociacio {
    private static final int NUM_SOCIS = 1000;
    private final Soci[] socis;

    public Asociacio() {
        this.socis = new Soci[NUM_SOCIS];
        for (int i = 0; i < NUM_SOCIS; i++) {
            this.socis[i] = new Soci();
        }
    }

    public void iniciaCompteTempsSocis() {
        Thread[] fils = new Thread[NUM_SOCIS];
        for (int i = 0; i < NUM_SOCIS; i++) {
            fils[i] = new Thread(socis[i]);
            fils[i].start();
        }

        for (Thread fil : fils) {
            try {
                fil.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void mostraBalancComptes() {
        float saldoFinal = Compte.getInstance().getSaldo();
        System.out.printf("Saldo: %.2f%n", saldoFinal);
    }

    public static void main(String[] args) {
        Asociacio associacio = new Asociacio();
        associacio.iniciaCompteTempsSocis();
        associacio.mostraBalancComptes();
    }
}