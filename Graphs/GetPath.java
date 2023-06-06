import java.util.*;

public class GetPath {

    private static ArrayList<Integer> getPathDFSHelper(int[][] mat, int v, int sv, int ev, boolean[] visited) {
        
        if(sv == ev) {
            ArrayList<Integer> baseAns = new ArrayList<>();
            baseAns.add(sv);
            return baseAns;
        }

        visited[sv] = true;
        
        for(int i=0; i<v; i++) {
            if(mat[sv][i] == 1 && !visited[i]) {
                ArrayList<Integer> smallAns = getPathDFSHelper(mat, v, i, ev, visited);

                if(smallAns != null) {
                    smallAns.add(sv);
                    return smallAns;
                }
            }
            
        }
        return null;
    }

    private static ArrayList<Integer> getPathDFS(int[][] mat, int v, int sv, int ev) {

        boolean[] visited = new boolean[v];

        return getPathDFSHelper(mat, v, sv, ev, visited);
        
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

        ArrayList<Integer> path = getPathDFS(mat, V, sv, ev);
        
        if(path == null) {
            System.out.println("Sorry!!! No path found.");
        }
        else {
            System.out.println(path.toString());
        }
    }

}
