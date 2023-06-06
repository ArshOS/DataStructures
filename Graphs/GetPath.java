import java.util.*;

public class GetPath {

    private static ArrayList<Integer> getPath(int[][] mat, int v, int sv, int ev) {

        // TO:DO

        return null;
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

        System.out.println(getPath(mat, V, sv, ev).toString());
    }

}
