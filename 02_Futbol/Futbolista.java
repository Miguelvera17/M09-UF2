import java.util.Random;

public class Futbolista extends Thread {

    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private int ngols = 0;
    private int ntirades = 0;

    public Futbolista(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (random.nextFloat() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) {
        System.out.println("Inici dels xuts --------------------");
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");

        Futbolista[] jugadors = new Futbolista[NUM_JUGADORS];
        Thread[] fils = new Thread[NUM_JUGADORS];
        String nombres[] = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"};

        for (int i = 0; i < NUM_JUGADORS; i++) {
            jugadors[i] = new Futbolista(nombres[i]);
            fils[i] = jugadors[i];
        }

        for (int i = 0; i < NUM_JUGADORS; i++) {
            fils[i].start();
        }

  
        for (int i = 0; i < NUM_JUGADORS; i++) {
            try {
                fils[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < NUM_JUGADORS; i++) {
            System.out.println(fils[i].getName() + " --> " + jugadors[i].getNgols() + " gols");
        }
    }
}

