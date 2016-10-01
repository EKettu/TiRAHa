
import algorithms.Astar;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Astar astar = new Astar();
        long timestamp = System.currentTimeMillis();
        astar.astar(15, 0, 0, 9, 9);
        System.out.println("Aikaa kului " +(System.currentTimeMillis()-timestamp) + " ms");
    }
}
