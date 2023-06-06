import java.util.*;

public class ConnectedComponents {

    /**
     * @param mat
     * @param v
     * @param src
     * @param visited
     * @param list
     */
    private static void getConnectedComponentsHelper(int[][] mat, int v, int src, boolean[] visited, ArrayList<Integer> list) {
        
        visited[src] = true;
        list.add(src);

        for(int i=0; i<v; i++) {
            if(mat[src][i] == 1 && !visited[i]) {
                getConnectedComponentsHelper(mat, v, i, visited, list);

            }
        }
    }

    /**
     * @param mat
     * @param v
     * @return
     */
    private static ArrayList<ArrayList<Integer>> getConnectedComponents(int[][] mat, int v) {
        boolean[] visited = new boolean[v];

        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                ArrayList<Integer> list = new ArrayList<>();
                getConnectedComponentsHelper(mat, v, i, visited, list);
                components.add(list);
            }
        }

        return components;
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

        for(ArrayList<Integer> list : components) {
            System.out.println(list.toString());
        }
    }
    
}
