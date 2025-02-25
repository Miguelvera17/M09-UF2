public class Taula {
    
    private final Filosof[] filosofs; 
    private final Forquilla[] forquilles;

    public Taula(int quantity) {
        filosofs = new Filosof[quantity];
        forquilles = new Forquilla[quantity];

        for (int i = 0; i < quantity; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < quantity; i++) {
            filosofs[i] = new Filosof(i, forquilles[i], forquilles[(i + 1) % quantity]);
        }
    }

    public static void main(String[] args) {
        Taula table = new Taula(4); 
        table.showTaula();
        table.cridarATaula(); 
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Filosof " + i + " ForquillaEsq:" + forquilles[i].getId() + " Forquilladret:" + forquilles[(i + 1) % forquilles.length].getId());
        }
        System.out.println("------------------------------");
    }

    public void cridarATaula() {
        for (Filosof f : filosofs) {
            f.start();
        }
    }

    
}