/*
BFS

Given an undirected and disconnected graph G(V, E), print its BFS traversal.
Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print the BFS Traversal, as described in the task.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2
*/

import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    
    public static void bfTraversal(int[][] adjMatrix){
        boolean[] visited = new boolean[adjMatrix.length];
        for(int i = 0; i < visited.length; ++i){
            if(!visited[i]){
                bfTraversal(adjMatrix, i, visited);
            }
        }
    }
    
    private static void bfTraversal(int[][] adjMatrix, int currentVertex, boolean[] visited){
        Queue<Integer> pendingVertices = new LinkedList<>();
        
        pendingVertices.add(currentVertex);
        visited[currentVertex] = true;
        
        while(!pendingVertices.isEmpty()){
            int firstElem = pendingVertices.poll();
            System.out.print(firstElem + " ");
        	// System.out.print(pendingVertices.poll() + " ");
        
        	for(int i = 0; i < adjMatrix.length; ++i){
            	if(adjMatrix[firstElem][i] == 1 && !visited[i]){
                	pendingVertices.add(i);
                    visited[i] = true;
            	}
     		}
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int e = sc.nextInt();
        
        //edge cases
        if(n == 0){
            return;
        }
        
        if(e == 0){
            for(int i = 0; i < n; ++i){
                System.out.print(i + " ");
            }
			return;
        }
        
        int[][] adjMatrix = new int[n][n];
        for(int i = 0; i < e; ++i){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        bfTraversal(adjMatrix);
        
	}

}

/*------------------------------------------------------------------------------END----------------------------------------------------------------------------------*/
