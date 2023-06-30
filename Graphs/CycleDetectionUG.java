import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class CycleDetectionUG {

    public static boolean isCysclicDisjointSets(int[][] mat, int V, int E) {

        // TO DO

        return false;
    }

    private static boolean isCyclicBFSHelper(int[][] mat, int v, int src, boolean[] visited) {

        class Pair{
            int curr;
            int parent;

            Pair(int curr, int parent) {this.curr = curr; this.parent = parent;}
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(src, -1));

        visited[src] = true;

        while(!queue.isEmpty()) {
            Pair front = queue.remove();

            for(int i=0; i<v; i++) {

                // Cycle detection step
                if(mat[front.curr][i] == 1 && visited[i] && i != front.parent) {
                    return true;
                }

                if(mat[front.curr][i] == 1 && !visited[i]) {
                    queue.add(new Pair(i, front.curr));
                    visited[i] = true;
                }
            }
        }

        return false;
    }

    /**
     * @param mat
     * @param v
     * @param e
     * @return
     */
    public static boolean isCyclicBFS(int[][] mat, int v, int e) {

        boolean[] visited = new boolean[v];

        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                return isCyclicBFSHelper(mat, v, i, visited);
            }
        }

        return false;
    }

    private static boolean isCyclicDFSHelper(int[][] mat, int v, int src, boolean[] visited, int parent) {

        visited[src] = true;

        for(int i=0; i<v; i++) {

            // Cycle detection step
            if(mat[src][i] == 1 && visited[i] && i != parent) {
                return true;
            }
            if(mat[src][i] == 1 && !visited[i]) {
                return isCyclicDFSHelper(mat, v, i, visited, src);
            }
        }

        return false;
    }

    /**
     * @param mat
     * @param v
     * @param e
     * @return
     */
    public static boolean isCyclicDFS(int[][] mat, int v, int e) {

        boolean[] visited = new boolean[v];

        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                if(isCyclicDFSHelper(mat, v, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
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

        System.out.println(isCyclicDFS(mat, V, E));
        System.out.println(isCyclicBFS(mat, V, E));
        System.out.println(isCysclicDisjointSets(mat, V, E));

    }
}
