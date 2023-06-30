import java.util.Scanner;

public class CycleDetectionDG {

    private static boolean isCyclicDFSHelper(int[][] mat, int V, int src, boolean[] visited, boolean[] pathVisited) {

        visited[src] = true;

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                return isCyclicDFSHelper(mat, V, i, visited, pathVisited);
            }
            else {
                if(pathVisited[i]) {
                    return true;
                }
            }
        }

        pathVisited[src] = false;

        return false;
    }

    public static boolean isCyclicDFS(int[][] mat, int V, int E) {

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                if(isCyclicDFSHelper(mat, V, i, visited, pathVisited)) {
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
            // mat[ev][sv] = 1;
        }
        s.close();

        System.out.println(isCyclicDFS(mat, V, E));
        // System.out.println(isCyclicBFS(mat, V, E));
    }
}
