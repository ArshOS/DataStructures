import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

    private static void DFS(int[][] mat, int v, int src, boolean[] visited, Stack<Integer> stk) {

        visited[src] = true;

        for(int i=0; i<v; i++) {
            if(mat[src][i] == 1 && !visited[i]) {
                DFS(mat, v, i, visited, stk);
            }
        }

        stk.push(src);

    }

    /**
     * @param mat
     * @param v
     * @param e
     * @return
     * Topological sort using DFS
     */
    public static Stack<Integer> topologicalSort(int[][] mat, int v, int e) {
        
        Stack<Integer> stk = new Stack<>();

        boolean[] visited = new boolean[v];

        for(int i=0;i<v; i++) {
            if(!visited[i]) {
                DFS(mat, v, i, visited, stk);
            }
        }

        return stk;
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
            // mat[ev][sv] = 1;
        }
        s.close();

        System.out.println(topologicalSort(mat, V, E).toString());
    }
}
