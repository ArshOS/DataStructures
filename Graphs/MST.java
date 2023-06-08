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
     * The idea is to build MST using the concept of Sets. Initially, all vertices belong to different set.
     * Here, to denote this a set array is used which initially store 0 for all the verticies stating all the vertices 
     * belong to different set. 
     * 
     * When an edge is pulled from edgeList, we check if sv and ev both belong to same set. If set value for both vertices 
     * is same and 0. It means none of the vertices of the current edge is part of the current MST. We put both vertices in 
     * the same set and increment set number (setGroupFlag++).
     * 
     * If the set number for both the vertices are same and not 0, assign set number of vertices which is non-zero 
     * to the set number of 0 set vertex.
     * 
     * If non of the set number of current pair of vertices is zero, we assing set number of ev to all the vertices that 
     * belong to the set of vertex sv. This step can be done other way around as well.
     * 
     * Basically, this approach is an eased version of Union Find algorithm, which detects cycle in a given graph.
     * 
     * @param edgeList
     * @param e
     * @param v
     * @return
     */
    private static ArrayList<Edge> buildMST(ArrayList<Edge> edgeList, int e, int v) {

        int[] sets = new int[v];
        int setsGroupFlag = 1;
       
        Collections.sort(edgeList, new weightComparator());

        ArrayList<Edge> MST = new ArrayList<>();

        for(int i=0; i<e; i++) {

            Edge curr = edgeList.get(i);

            if(sets[curr.sv] != sets[curr.ev] || (sets[curr.sv] == 0 && sets[curr.ev] == 0)) {
              
                if(sets[curr.sv] == 0 && sets[curr.ev] == 0) {
                    sets[curr.sv] = sets[curr.ev] = setsGroupFlag++;
                }
                else if(sets[curr.sv] == 0 && sets[curr.ev] != 0) {
                    sets[curr.sv] = sets[curr.ev];
                }
                else if(sets[curr.sv] != 0 && sets[curr.ev] == 0) {
                    sets[curr.ev] = sets[curr.sv];
                }
                else{
                    for(int j=0; j<v; j++) {
                        int currSet = sets[curr.ev];
                        if(sets[j] == sets[currSet]) {
                            sets[j] = sets[curr.sv];
                        }
                    }
                }
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

        System.out.println("Required MST is: ");
        for(Edge edge : MST) {
            System.out.println(edge.sv + " " + edge.ev + " " + edge.wt);
        }
    }
}
