import java.util.ArrayList;
import java.util.Scanner;

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

    private static void buildMST(ArrayList<Edge> edgeList, int e, int[][] mat, int v) {
        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] mat = new int[V][V];

        ArrayList<Edge> edgeList = new ArrayList<>();

        for(int i=0; i<E; i++) {
            int sv = sc.nextInt();
            int ev = sc.nextInt();
            int wt = sc.nextInt();

            mat[sv][ev] = mat[ev][sv] = wt;
            Edge edge = new Edge(sv, ev, wt);
            
            edgeList.add(edge);
        }
        sc.close();

        buildMST(edgeList, E, mat, V);
    }
}
