import java.util.Random;

public class Treballador extends Thread{
    
    private int sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    private float sou_acumulat;
    private Random rnd;

    public Treballador(String nom, int sou_anual_brut, int edat_inici_treball, int edat_fi_treball){
        super(nom);
        this.edat_actual = 0;
        this.sou_acumulat = 0.0f;
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.rnd = new Random();
    }

    private void cobra() {
        sou_acumulat += (sou_anual_brut / 12.0f); 
    }

    private void pagaImpostos() {
        sou_acumulat -= (sou_anual_brut / 12.0f) * 0.24f;
    }

    @Override
    public void run() {
        while (edat_actual < edat_fi_treball) { 
            if (edat_actual >= edat_inici_treball) { 
                for (int k = 0; k < 12; k++) { 
                    cobra();
                    pagaImpostos();
                }
            }
            edat_actual++; 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                System.err.println(getName() + " interrumpido.");
            }
        }
    }

    public float getCobrat() {
        return sou_acumulat;
    }

    public int getEdat() {
        return edat_actual;
    }


}