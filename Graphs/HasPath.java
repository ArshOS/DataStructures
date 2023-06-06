import java.util.Scanner;

public class HasPath {

    private static boolean hasPathHelper(int[][] mat, int v, int sv, int ev, int src, boolean[] visited) {
        
        if(src == ev) {
            return true;
        }

        visited[src] = true;

        for(int i=0; i<v; i++) {
            if(mat[src][i] == 1 && !visited[i]) {  
                if(hasPathHelper(mat, v, sv, ev, i, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(int[][] mat, int v, int sv, int ev, int src) {
        boolean[] visited = new boolean[v];

        return hasPathHelper(mat, v, sv, ev, src, visited);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int mat[][] = new int[V][V];

        for(int i=0; i<E; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            mat[row][col] = mat[col][row] = 1;
        }

        int sv = sc.nextInt();
        int ev = sc.nextInt();

        sc.close();

        System.out.println(hasPath(mat, V, sv, ev, sv));
    }
}