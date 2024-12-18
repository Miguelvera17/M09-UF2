
public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");
        Fil pepe = new Fil("Pepe");
        Fil juan = new Fil("Juan");
        
        pepe.start();
        juan.start();
        
        
    }
}      
