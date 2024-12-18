public class MainDemoFil {

    public static void main(String[] args) {
        // Capturem el fil actual
        Thread fil = Thread.currentThread();
        
        // Mostrem la informació sobre el fil
        System.out.println(fil.getName() + ".main:");
        System.out.println("Prioritat -> " + fil.getPriority());
        System.out.println("Nom -> " + fil.getName());
        System.out.println("toString() -> " + fil.toString());
    }
}

