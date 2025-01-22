
public class Compte {
    private static Compte instancia;
    private float saldo;

    private Compte() {
        this.saldo = 0.0f;
    }

    public static synchronized Compte getInstance() {
        if (instancia == null) {
            instancia = new Compte();
        }
        return instancia;
    }

    public synchronized float getSaldo() {
        return saldo;
    }

    public synchronized void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public synchronized void ingresa(float quantitat) {
        this.saldo += quantitat;
    }

    public synchronized void treu(float quantitat) {
        this.saldo -= quantitat;
    }
}

