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

    public synchronized boolean estaLliure() {
        return propietari == -1;
    }
}