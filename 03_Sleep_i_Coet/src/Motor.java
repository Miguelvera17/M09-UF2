import java.util.Random;

public class Motor implements Runnable {

    private int id;
    private int potaActual;
    private int potObjectiu;

    public Motor(int id) {
        this.id = id;
        this.potaActual = 0;
        this.potObjectiu = 0;
    }

    public int getPotenciaObjectiu() {
        return this.potObjectiu;
    }
    public void setPotencia(int potencia) {
        this.potObjectiu = potencia;
    }

    @Override
    public void run() {
        if (this.potaActual != this.potObjectiu) {
            String action = (this.potObjectiu > this.potaActual) ? "Incre." : "Decre.";
            while (this.potaActual != this.potObjectiu) {
                try {
                    Thread.sleep(new Random().nextInt(2001));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.potObjectiu > this.potaActual) {
                    this.potaActual++;
                } else {
                    this.potaActual--;
                }
                if (this.potaActual == this.potObjectiu) {
                    System.out.printf("Motor %d: FerRes Objectiu: %d Actual: %d%n", this.id, this.potObjectiu, this.potaActual);
                    break;
                }
                System.out.printf("Motor %d: %s Objectiu: %d Actual: %d%n", this.id, action, this.potObjectiu, this.potaActual);
            }
        }
    }
}
