import java.util.Scanner;

public class Coet {

    private Motor[] motores;

    public Coet() {
        motores = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motores[i] = new Motor(i);
        }
    }

    public void passaPotencia(int p) {
        System.out.println("Passant a potència " + p);

        for (int i = 0; i < 4; i++) {
            motores[i].setPotencia(p);
        }

        Thread[] hilos = new Thread[4];
        for (int i = 0; i < 4; i++) {
            hilos[i] = new Thread(motores[i]);
            hilos[i].start();
        }

        try {
            for (Thread hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        for (int i = 0; i < 4; i++) {
            motores[i].setPotencia(motores[i].getPotenciaObjectiu());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coet coet = new Coet();
        while (true) {
            System.out.print(">>> ");
            int pot = sc.nextInt();
            coet.passaPotencia(pot);

            if (pot == 0) {
                break;
            }
        }
        sc.close();
    }
}