public class Forquilla {

    private final int id;
    public static final int LLIURE = -1;
    private int propietari;
    

    public Forquilla(int id) {
        this.id = id;
        this.propietari = LLIURE;
    }

    public int getId() {
        return id;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public synchronized void agafar(int filosofId) throws InterruptedException {
        while (propietari != LLIURE) {
            wait();
        }
        propietari = filosofId;
        System.out.println("Filòsof: fil" + filosofId + " agafa la forquilla " + id);
    }

    public synchronized void deixar(int filosofId) {
        propietari = LLIURE;
        notifyAll();
        System.out.println("Filòsof: fil" + filosofId + " deixa la forquilla " + id);
    }
}