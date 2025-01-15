public class Treballador {
    private int nou_anual_salari;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private int edat_actual;
    double cobrat;

    public Treballador(int nou_anual_salari, int edat_inici_treball, int edat_fi_treball){
        this.nou_anual_salari = nou_anual_salari;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        edat_actual = 0;
        cobrat = cobrat + nou_anual_salari;
    }


}
