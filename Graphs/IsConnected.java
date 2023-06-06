import java.util.*;

public class IsConnected {

    private static void isConnectedHelper(int[][] mat, int v, int src, boolean[] visited) {

        visited[src] = true;

        for(int i=0; i<v; i++) {
            if(mat[src][i] == 1 && !visited[i]) {
                isConnectedHelper(mat, v, i, visited);
            }
        }

    }

    private static boolean isConnected(int[][] mat, int v) {
        boolean[] visited = new boolean[v];

        isConnectedHelper(mat, v, 0, visited);

        for(boolean b : visited) {
            if(!b) {
                return false;
            }
        }

        return true;
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

        System.out.println(isConnected(mat, V));
    }

}
