import java.util.*;

public class GetPath {

    private static ArrayList<Integer> getPathBFS(int[][] mat, int v, int sv, int ev) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        queue.add(sv);
        visited[sv] = true;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(!queue.isEmpty()) {
            int curr = queue.remove();

            if(curr == ev) {
                break;
            }

            for(int i=0; i<v; i++) {
                if(mat[curr][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    map.put(i, curr);
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        
        path.add(ev);

        while(sv != ev) {
            if(map.containsKey(ev)) {
                path.add(map.get(ev));
                ev = map.get(ev);
            }
            else {
                path = null;
                break;
            }
            
        }

        return path;
    }

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

        System.out.println("1.DFS method \n2.BFS method");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                ArrayList<Integer> pathDFS = getPathDFS(mat, V, sv, ev);
                if(pathDFS == null) {
                    System.out.println("Sorry!!! No path found.");
                }
                else {
                    System.out.println(pathDFS.toString());
                }
            break;

            case 2:
                ArrayList<Integer> pathBFS = getPathBFS(mat, V, sv, ev);
                if(pathBFS == null) {
                    System.out.println("Sorry!!! No path found.");
                }
                else {
                    System.out.println(pathBFS.toString());
                }
            break;
        
            default:
                break;
        }

        sc.close();
    }

}
