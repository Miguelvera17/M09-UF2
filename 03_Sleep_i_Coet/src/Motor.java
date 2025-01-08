import java.util.Random;

public class Motor extends Thread {
    private int potenciaActual;
    private int potenciaObjectiu;
    private boolean enFuncionament;
    private int id;

    public Motor(int id) {
        this.potenciaActual = 0;
        this.potenciaObjectiu = 0;
        this.enFuncionament = true;
        this.id = id;
    }

    public synchronized void setPotencia(int potenciaObjectiu) {
        this.potenciaObjectiu = potenciaObjectiu;
        notify(); // Despierta el hilo si está esperando
    }

    @Override
    public void run() {
        Random random = new Random();

        while (enFuncionament) {
            synchronized (this) {
                while (potenciaActual == potenciaObjectiu) {
                    try {
                        // Si la potencia es 0 y objetivo es 0, termina
                        if (potenciaObjectiu == 0 && potenciaActual == 0) {
                            enFuncionament = false;
                            System.out.printf("Motor %d: FerRes Objectiu: 0 Actual: 0\n", id);
                            return;
                        }
                        wait(); // Espera hasta que se cambie la potencia objetivo
                    } catch (InterruptedException e) {
                        System.out.println("Motor interromput!");
                        return;
                    }
                }
            }

            // Ajusta la potencia actual hacia la potencia objetivo
            if (potenciaActual < potenciaObjectiu) {
                potenciaActual++;
                System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d\n", id, potenciaObjectiu, potenciaActual);
            } else if (potenciaActual > potenciaObjectiu) {
                potenciaActual--;
                System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d\n", id, potenciaObjectiu, potenciaActual);
            }

            // Simula el retraso aleatorio entre 0 y 2 segundos
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                System.out.println("Motor interromput durant el retard!");
                return;
            }
        }
    }
}
