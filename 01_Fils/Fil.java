public class Fil extends Thread {
    private String nom;
    private int comptador;
    private boolean alternar;

    public Fil(String nom) {
        this.nom = nom;
        this.comptador = 1;
        this.alternar = false;
    }

    public void setAlternar(boolean alternar) {
        this.alternar = alternar;
    }

    @Override
    public void run() {
        while (comptador <= 9) {
            if (!alternar) {
                System.out.println(nom + " " + comptador++);
                try {
                    Thread.sleep((int) Math.random());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Termina el fil " + nom);
    }
}

