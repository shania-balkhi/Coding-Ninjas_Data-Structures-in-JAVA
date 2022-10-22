/*
Get Path - DFS

Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using DFS and print the first path that you encountered.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex 'a' and 'b'.
The following line contain two integers, that denote the value of v1 and v2.
Output Format :
Print the path from v1 to v2 in reverse order.
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
*/

import java.util.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {

	public static ArrayList<Integer> getPathDFS(int adjMatrix[][], int source, int destination, boolean[] visited){
     
        //edge case 1
        if(destination >= adjMatrix.length || destination < 0 || source >= adjMatrix.length || source < 0){   //checks if destination vertex and source vertex is valid or not i.e., if they are greater than the highest-numbered vertex that is already present or less than 0
            return null;
        }
        
        //base case
        if(source == destination){
            ArrayList<Integer> path = new ArrayList<>();
            path.add(source);
            return path;
        }
        
		//Note :- you dont have to check for disconnented components here! Obviously path will not exist in case of disconnected components!
        visited[source] = true;
        for (int i = 0; i < adjMatrix.length; ++i) { // visit all the neighbors of currentVertex
            if (adjMatrix[source][i] == 1 && source!= i && visited[i] != true) { //if i is a neighbour, then go inside this if block
                
                // visited[i] = true; //mark this neighbour as visited
                
                ArrayList<Integer> smallPath = getPathDFS(adjMatrix, i, destination, visited);  //check is if path exist between this neighbour and destination
	
                if(smallPath==null){
                    continue;
                }
                else{
                    smallPath.add(source);   //it's impp. to remeber that you have to add source here, and not i. it was because I was doing the latter that my code failed test cases and did not work!!!
                    return smallPath;
                }
                
            }
        }
        
        return null;
        
    }
            
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        //taking input of the adjMatrix
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
        
        //taking input of source and destination
        int source = sc.nextInt();
        int destination = sc.nextInt();
        
        
        ArrayList<Integer> pathAns = new ArrayList<>();
        boolean[] visited = new boolean[adjMatrix.length];
        pathAns = getPathDFS(adjMatrix, source, destination, visited);
        
        //printing the path
        if(pathAns != null){  //imp to check otherwise test cases will fail
        	for(int i = 0; i < pathAns.size(); ++i){
            	System.out.print(pathAns.get(i) + " ");
        	}
        }
        
	}
}
