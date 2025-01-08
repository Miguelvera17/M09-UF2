import java.util.Scanner;

public class Coet {
    private final Motor[] motors;

    public Coet() {
        motors = new Motor[4];
        for (int i = 0; i < 4; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < 0 || p > 100) { // Supongamos que la potencia está entre 0 y 100
            System.out.println("Potència no vàlida. Introdueix un valor entre 0 i 100.");
            return;
        }
        System.out.printf("Passant a potència %d\n", p);
        for (Motor motor : motors) {
            motor.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor motor : motors) {
            motor.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        try (Scanner scanner = new Scanner(System.in)) {
            int potencia;
            do {
                System.out.print("Introdueix la potència objectiu (0 per sortir): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Si us plau, introdueix un número enter.");
                    scanner.next();
                }
                potencia = scanner.nextInt();
                coet.passaAPotencia(potencia);
            } while (potencia != 0);
        }

        System.out.println("Fi del programa. Tots els motors estan aturats.");
    }
}
