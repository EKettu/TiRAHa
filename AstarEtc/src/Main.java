
import algorithms.Astar;
import algorithms.IDAstar;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Astar astar = new Astar();
        long timestamp = System.currentTimeMillis();
        System.out.println("A*");
        astar.astar();
        System.out.println("Aikaa kului " +(System.currentTimeMillis()-timestamp) + " ms");
        System.out.println("");
//        System.out.println("IDA*");
//        IDAstar idastar = new IDAstar();
//        idastar.idastar(10, 0, 0, 9, 9);
    }
}
