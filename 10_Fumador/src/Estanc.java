import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc {
    
    private final List<String> tabac = new ArrayList<>();
    private final List<String> paper = new ArrayList<>();
    private final List<String> llumi = new ArrayList<>();
    private boolean tancat = false;
    private final Random random = new Random();

    public synchronized void nouSubministrament() {
        if (tancat) return;

        int producte = random.nextInt(3);
        switch (producte) {
            case 0:
                addTabac();
                break;
            case 1:
                addPaper();
                break;
            case 2:
                addLlumi();
                break;
        }
        notifyAll();
    }

    public synchronized void addTabac() {
        tabac.add("Tabac");
        System.out.println("Afegint Tabac");
    }

    public synchronized void addPaper() {
        paper.add("Paper");
        System.out.println("Afegint Paper");
    }

    public synchronized void addLlumi() {
        llumi.add("Llumí");
        System.out.println("Afegint Llumí");
    }

    public synchronized boolean venTabac() {
        if (!tabac.isEmpty()) {
            tabac.remove(0);
            return true;
        }
        return false;
    }

    public synchronized boolean venPaper() {
        if (!paper.isEmpty()) {
            paper.remove(0);
            return true;
        }
        return false;
    }

    public synchronized boolean venLlumi() {
        if (!llumi.isEmpty()) {
            llumi.remove(0);
            return true;
        }
        return false;
    }

    public synchronized void tancarEstanc() {
        tancat = true;
        notifyAll();
        System.out.println("Estanc tancat");
    }

    public void executar() {
        System.out.println("Estanc obert");
        while (!tancat) {
            try {
                Thread.sleep(500 + random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nouSubministrament();
        }
    }
}