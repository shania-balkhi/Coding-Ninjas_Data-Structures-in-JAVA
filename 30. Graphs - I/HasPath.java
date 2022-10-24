/*
Has Path?

Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
The first and only line of output contains true, if there is a path between v1 and v2 and false otherwise.
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false
*/

//CODE - 1
//USING BFS APPROACH
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
        
        
		// Pre.Script.:- you dont have to check for disconnented components here, but i'm still doing it anyway
        
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
        int n = sc.nextInt();
        int e = sc.nextInt();
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
        
        int source = sc.nextInt();   
        int destination = sc.nextInt();
        System.out.println(hasPath(adjMatrix, source, destination));
        

	}

}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/

//CODE - 2
//USING BFS APPROACH
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
        
        
		// Pre.Script.:- you dont have to check for disconnented components here, but i'm still doing it anyway
        

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
        
        //for connecting one node to itself
        for (int i = 0; i < n; ++i) {
        	adjMatrix[i][i] = 1;
        }
        
        int source = sc.nextInt();   
        int destination = sc.nextInt();
        System.out.println(hasPath(adjMatrix, source, destination));
        

	}

}
