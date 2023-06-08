import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class weightComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        if(o1.wt > o2.wt) {
            return 1;
        }
        else if(o1.wt < o2.wt) {
            return -1;
        }
        else {
            return 0;
        }
    }

}

class Edge {
    int sv;
    int ev;
    int wt;

    public Edge(int sv, int ev, int wt) {
        this.sv = sv;
        this.ev = ev;
        this.wt = wt;
    }
}


public class MST {

    private static boolean hasPathHelper(int[][] mat, int sv, int ev, boolean[] visited) {

        if(sv == ev) {
            return true;
        }

        visited[sv] = true;

        for(int i=0; i<mat.length; i++) {
            if(mat[sv][i] > 0 && !visited[i]) {
                if(hasPathHelper(mat, i, ev, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPath(int[][] mat, int v, int sv, int ev) {

        boolean[] visited = new boolean[v];

        return hasPathHelper(mat, sv, ev, visited);
    }

    private static ArrayList<Edge> buildMST(ArrayList<Edge> edgeList, int e, int v) {

        int[][] mat = new int[v][v];
       
        Collections.sort(edgeList, new weightComparator());

        ArrayList<Edge> MST = new ArrayList<>();

        for(int i=0; i<e; i++) {

            Edge curr = edgeList.get(i);

            if(!hasPath(mat, v, curr.sv, curr.ev)) {
                mat[curr.sv][curr.ev] = curr.wt;
                MST.add(curr);
            }

            if(MST.size() == e-1) {
                break;
            }
        }

        return MST;

    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<Edge> edgeList = new ArrayList<>();

        for(int i=0; i<E; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int wt = sc.nextInt();

            Edge edge = new Edge(sv, ev, wt);
            
            edgeList.add(edge);
        }
        sc.close();

        ArrayList<Edge> MST = buildMST(edgeList, E, V);

        for(Edge edge : MST) {
            System.out.println(edge.sv + " " + edge.ev + " " + edge.wt);
        }
    }
}
