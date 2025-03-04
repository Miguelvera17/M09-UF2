public class Taula {

    private final Forquilla[] forquilles;
    private final Filosof[] filosofs;

    public Taula(int num) {
        
        forquilles = new Forquilla[num];
        filosofs = new Filosof[num];

        for (int i = 0; i < num; i++) {
            forquilles[i] = new Forquilla(i);
        }

        for (int i = 0; i < num; i++) {
            Forquilla forquillaEsquerra = forquilles[i];
            Forquilla forquillaDreta = forquilles[(i + 1) % num];
            filosofs[i] = new Filosof("Fil" + i, forquillaEsquerra, forquillaDreta);
        }
    }

    public static void main(String[] args) {
        Taula taula = new Taula(4);
        taula.showTaula();
        taula.cridarATaula();
    }

    public void showTaula() {
        for (int i = 0; i < filosofs.length; i++) {
            System.out.println("Comensal:" + filosofs[i].getName() + " esq:" + forquilles[i].getNum() + " dret:"
                    + forquilles[(i + 1) % filosofs.length].getNum());
        }
        System.out.println("-----------------------------");
    }

    public void cridarATaula() {
        for (Filosof filos : filosofs) {
            filos.start();
        }
    }
}