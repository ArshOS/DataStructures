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

    /**
     * @param parent
     * @param v
     * @return
     */
    private static int getParent(int[] parent, int v) {
        if(parent[v] == v) {
            return v;
        }

        return getParent(parent, parent[v]);
    }

    /**
     * @param edgeList
     * @param e
     * @param v
     * @return
     */
    private static ArrayList<Edge> buildMST(ArrayList<Edge> edgeList, int e, int v) {

        int[] parent = new int[v];
        for(int i=0; i<v; i++) {
            parent[i] = i;
        }
       
        Collections.sort(edgeList, new weightComparator());

        ArrayList<Edge> MST = new ArrayList<>();

        for(int i=0; i<e; i++) {

            Edge curr = edgeList.get(i);

            int parentSrc = getParent(parent, curr.sv);
            int parentDest = getParent(parent, curr.ev);

            if(parentSrc != parentDest) {
                MST.add(curr);

                parent[parentSrc] = parentDest;
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

        System.out.println("Required MST is: ");
        for(Edge edge : MST) {
            System.out.println(edge.sv + " " + edge.ev + " " + edge.wt);
        }
    }
}
