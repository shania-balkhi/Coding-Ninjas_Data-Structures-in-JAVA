//code for Depth-First Traversal
import java.util.Scanner;

class Solution {
    public static void dfTraversal(int[][] adjMatrix) {
        boolean[] visited = new boolean[adjMatrix.length];
        dfTraversal(adjMatrix, 0, visited); // 0 is the source vertex
    }

    public static void dfTraversal(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        System.out.print(currentVertex + " ");
        visited[currentVertex] = true;
        for (int i = 0; i < adjMatrix.length; ++i) {
            if (adjMatrix[currentVertex][i] == 1 && visited[i] != true) {
                dfTraversal(adjMatrix, i, visited);
            }
        }
    }

}

public class DF_Code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < e; ++i) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        Solution.dfTraversal(adjMatrix);
        // for (int i = 0; i < n; ++i) {
        // for (int j = 0; j < n; ++j) {
        // System.out.print(adjMatrix[i][j] + " ");
        // }
        // System.out.println();
        // }

    }
}

/*--------------------------------------------------------------------------------END--------------------------------------------------------------------------------*/
