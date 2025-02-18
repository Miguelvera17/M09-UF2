public class Taula {
    private final Filosof[] clients;
    private final Forquilla[] forquilles;

    public static void main(String[] args) {
        Taula taula = new Taula(5);
        taula.show();
        taula.call();
    }

    public void show() {
        for (int i = 0; i < clients.length; i++) {
            System.out.println("Comensal: fil" + i + " esq:" + forquilles[i].getId() + " dret:" + forquilles[(i + 1) % forquilles.length].getId());
        }
        System.out.println("------------------------------");
    }

    public void call() {
        for (Filosof f : clients) {
            f.start();
        }
    }

    public Taula(int amount) {
        clients = new Filosof[amount];
        forquilles = new Forquilla[amount];
        
        for (int i = 0; i < amount; i++) {
            forquilles[i] = new Forquilla(i);
        }
        
        for (int i = 0; i < amount; i++) {
            clients[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % amount]);
        }
    }
}
