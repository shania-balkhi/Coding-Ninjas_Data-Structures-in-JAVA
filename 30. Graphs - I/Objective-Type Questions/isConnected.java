/*
isConnected?

Given an undirected graph G(V,E), check if the graph G is connected graph or not.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
Output Format :
The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
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
true
Sample Input 2:
4 3
0 1
1 3 
0 3
Sample Output 2:
false 
Sample Output 2 Explanation
The graph is not connected, even though vertices 0,1 and 3 are connected to each other but there isn’t any path from vertices 0,1,3 to vertex 2. 
*/

//code 1 
// DF Traversal
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    
    public static boolean isConnected(int[][] adjMatrix, boolean[] visited){
        
        //calling dfTraversal function
        dfTraversal(adjMatrix, visited);
        
        // for(int i = 0; i < visited.length; ++i){
        //     System.out.print(visited[i] + " ");
        // }
        
        for(int i = 0; i < visited.length; ++i){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
        
    }
    
    
    
    
    
    public static void dfTraversal(int[][] adjMatrix, boolean[] visited) {

        //this loop checks for disconnected components
        for(int i = 0; i < adjMatrix.length; ++i){
            if(!visited[i]){
                dfTraversalHelper(adjMatrix, 0, visited); // 0 is the source vertex
            }
        } 
        
    }
    
    
    
    

    public static void dfTraversalHelper(int[][] adjMatrix, int currentVertex, boolean[] visited) {
        // System.out.print(currentVertex + " ");
        visited[currentVertex] = true;

        for (int i = 0; i < adjMatrix.length; ++i) { // visit all the neighbors of currentVertex
            if (adjMatrix[currentVertex][i] == 1 && visited[i] != true) {
                dfTraversalHelper(adjMatrix, i, visited);
            }
        }
        
    }
    
    
    
    
       
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
        // dfTraversal(adjMatrix);
        boolean[] visited = new boolean[adjMatrix.length];
        System.out.println(isConnected(adjMatrix, visited));
    }

}

/************************************************************************************************************************************************************/

// code 2 
// BF Traversal
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    
    
    public static boolean isConnected(int[][] adjMatrix, boolean[] visited){
        
        //calling dfTraversal function
        bfTraversal(adjMatrix, visited);
        
        
        for(int i = 0; i < visited.length; ++i){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
        
    }
    
    public static void bfTraversal(int[][] adjMatrix, boolean[] visited){
        // boolean[] visited = new boolean[adjMatrix.length];
        for(int i = 0; i < visited.length; ++i){
            if(!visited[i]){
                bfTraversalHelper(adjMatrix, i, visited);
            }
        }
        
    }
    
    private static void bfTraversalHelper(int[][] adjMatrix, int currentVertex, boolean[] visited){
        Queue<Integer> pendingVertices = new LinkedList<>();
        
        pendingVertices.add(currentVertex);
        
        while(!pendingVertices.isEmpty()){
            int firstElem = pendingVertices.poll();
            // System.out.print(firstElem + " ");
        	// System.out.print(pendingVertices.poll() + " ");
        
        	for(int i = 0; i < adjMatrix.length; ++i){  // visit all the neighbors of currentVertex i.e., firstElem
                if(adjMatrix[firstElem][i] == 1 && !visited[i]){
                	pendingVertices.add(i);
                    visited[i] = true;
            	}
     		}
        }
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();   //n == number of vertices
        int e = sc.nextInt();    //e == number of edges
        
        int[][] adjMatrix = new int[n][n];
        for(int i = 0; i < e; ++i){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        
        
        //edge case (in case of just BFS, not DFS)
        if(e == 0 && n == 1 /* basically, when n <= 1, then answer is true*/){  //when number of edges is zero and number of vertices <= 1, then ans is true 
            System.out.println(true);
            return;
        }
        

        boolean[] visited = new boolean[adjMatrix.length];
        System.out.println(isConnected(adjMatrix, visited));
        
        
	}

}

/************************************************************************************************************************************************************/

// code 3 
// hasPath way - DF Traversal
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class Solution {
    
    public static boolean hasPath(int[][] adjMatrix, int source, int destination){
        
        //if matrix is empty
        // if(adjMatrix.length == 0){
        //     return true;
        // }
        
        //edge case 1
        if(destination >= adjMatrix.length || destination < 0 || source >= adjMatrix.length || source < 0){   //checks if destination vertex and source vertex is valid or not i.e., if they are greater than the highest-numbered vertex that is already present or less than 0
            return false;
        }
        
        
        //if they are directly connected, then return true
        if(adjMatrix[source][destination] == 1  || source == destination /*i.e., if both source and destination are same*/ ){
            return true;
        }
        
        
        
        // boolean ans = false;
        boolean[] visited = new boolean[adjMatrix.length];
    	for(int i = 0; i < adjMatrix.length; ++i){
        	if(!visited[i]){
                // ans = dfTraversal(adjMatrix, source, destination, visited);
        		return dfTraversal(adjMatrix, source, destination, visited); 
        	}
    	}
        
        return false;
        
    }
    

    public static boolean dfTraversal(int[][] adjMatrix, int source, int destination, boolean[] visited) {

        for (int i = 0; i < adjMatrix.length; ++i) { // visit all the neighbors of currentVertex
            if (adjMatrix[source][i] == 1 && source != i && visited[i] != true) {
                visited[i] = true;
                if(adjMatrix[i][destination] == 1){
                    return true;
                }else if ( dfTraversal(adjMatrix, i, destination, visited) ){
                        return true;
                }
            }
        }
        
        return false;
    }
    

	public static void main(String[] args) throws NumberFormatException, IOException {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n == no. of vertices
        int e = sc.nextInt(); //e == no. of edges
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < e; ++i) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        
        //for connecting one node to itself
        for (int i = 0; i < n; ++i) {
        	adjMatrix[i][i] = 1;
        }
       
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(hasPath(adjMatrix, i, j) == false){   //i == source, j == destination
                    System.out.println("false");
                    return;
                }   
            } 
        }
        System.out.print("true");

        

	}

}

/************************************************************************************************************************************************************/

// code 4 
// hasPath way - BF Traversal
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
public class Solution {
    
    public static boolean hasPath(int[][] adjMatrix, int source, int destination){
        
        //edge case 1
        if(destination >= adjMatrix.length || destination < 0 || source >= adjMatrix.length || source < 0){   //checks if destination vertex and source vertex is valid or not i.e., if they are greater than the highest-numbered vertex that is already present or less than 0
            return false;
        }
        
        
        //if they are directly connected, then return true
        if(adjMatrix[source][destination] == 1  || source == destination /*i.e., if both source and destination are same*/ ){
            return true;
        }
 
        

    	boolean[] visited = new boolean[adjMatrix.length];
    	for(int i = 0; i < adjMatrix.length; ++i){
        	if(!visited[i]){
        		return bfTraversal(adjMatrix, source, destination, visited); 
    		}
    	}
        
        return false;
        
    }
    
     public static boolean bfTraversal(int[][] adjMatrix, int currentVertex, int destination, boolean[] visited){
        Queue<Integer> pendingVertices = new LinkedList<>();
        
        pendingVertices.add(currentVertex);
        visited[currentVertex] = true;
        
        while(!pendingVertices.isEmpty()){
            int firstElem = pendingVertices.poll();
        
        	for(int i = 0; i < adjMatrix.length; ++i){  // visit all the neighbors of currentVertex i.e., firstElem
            	if(adjMatrix[firstElem][i] == 1 && !visited[i]){
                    if(adjMatrix[i][destination] == 1){
                    	return true;
                    }else if( bfTraversal(adjMatrix, i, destination, visited) ){
                        return true;
                    }
                	pendingVertices.add(i);
                    visited[i] = true;
            	}
     		} 
        }
         return false;
    }
    

	public static void main(String[] args) throws NumberFormatException, IOException {
        
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
        
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(hasPath(adjMatrix, i, j) == false){   //i == source, j == destination
                    System.out.println("false");
                    return;
                }   
            } 
        }
        System.out.print("true");
        

	}

}
