
public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");
        Thread Juan = new Thread(new Fil("Juan"));
        Thread Pepe = new Thread(new Fil("Pepe"));

        Juan.start();
        Pepe.start();    
    }
}      
