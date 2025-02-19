
public class Forquilla {
    private final int id;
    private boolean use = false;
    private static final int LLIURE = -1;

    public Forquilla(int id) {
        this.id = id;
        
    }

    public synchronized boolean get(int IdFilosof, boolean isRigth) {
        if (!use) {
            use = true;
            System.out.println("Filosof: fil" + IdFilosof + " agafa la forquilla " + (isRigth ? "dreta" : "esquerra") + " " + id);
            return true;
        }
        return false;
    }

    public synchronized void leave() {
        use = false;
    }

    public int getId() {
        return id;
    }
}