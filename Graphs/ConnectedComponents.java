import java.util.*;

public class ConnectedComponents {

    private static ArrayList<ArrayList<Integer>> getConnectedComponents(int[][] mat, int v) {

        

        return null;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        int[][] mat = new int[V][V];
        for(int i=0; i<E; i++){
            int sv = s.nextInt();
            int ev = s.nextInt();

            mat[sv][ev] = 1;
            mat[ev][sv] = 1;
        }
        s.close();

        ArrayList<ArrayList<Integer>> components = getConnectedComponents(mat, V);
    }
    
}
