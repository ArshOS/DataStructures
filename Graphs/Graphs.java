import java.util.*;

public class Graphs {

    private static void printBFSHelper(int[][] mat, int src, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            System.out.print(curr + " ");

            for(int i=0; i<v; i++) {
                if(mat[curr][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    /**
     * Prints Breadth First Search (traversal) of the Graph mat
     * @param mat
     * @param v
     */
    private static void printBFS(int[][] mat, int v) {
        System.out.println("BFS");
        boolean[] visited = new boolean[v];

        for(int i=0; i<v; i++) {
            if(!visited[i]) {
                printBFSHelper(mat, i, visited, v);
            }
        }
    }

    private static void printDFSHepler(int[][] mat, int V, int src, boolean[] visited) {
        System.out.print(src + " ");
        visited[src] = true;

        for(int i=0; i<V; i++) {
            if(mat[src][i] == 1 && !visited[i]) {
                printDFSHepler(mat, V, i, visited);
            }
        }
    }

    /**
     * Prints Depth First Search (traversal) of the Graph mat.
     * @param mat
     * @param V
     */
    private static void printDFS(int[][] mat, int V) {
        System.out.println("DFS");

        boolean[] visited = new boolean[V];

        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                printDFSHepler(mat, V, i, visited);
            }
        }
        System.out.println();    
    }

    /**
     * Prints Adjacency matrix representation of the graph
     * @param mat
     * @param V
     */
    public static void printMat(int[][] mat, int V) {
        System.out.println("Adj. Mat");

        for(int i=0; i<V; i++) {
            for(int j=0; j<V; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
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

        System.out.println("1. Adjacency Matrix \n2. Depth First Traversal \n3. Breadth First Traversal");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                printMat(mat, V);
                break;

            case 2:
                printDFS(mat, V);
                break;

            case 3:
                printBFS(mat, V);
                break;

            default:
                break;
        }

        sc.close();
    }

}