/*
Get Path - BFS

Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
Note:
1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
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

import java.util.*;;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
	
	public static ArrayList<Integer> getPathBFS(int[][] adjMatrix, int source, int destination, boolean[] visited){
        
        //no need to check for disconnected components 'cause obviosly path won't exist in case of disconnected components
        
        Queue<Integer> pendingVertices = new LinkedList<>(); // for implementing BFS
        HashMap<Integer, Integer> map = new HashMap<>(); //to keep the mapping for node and its parent
        
        pendingVertices.add(source);
        visited[source] = true;
        map.put(source, -1); //because we're assuming that parentNode of source is -1
        boolean hasPath = false;
        
        while(!pendingVertices.isEmpty()){
            int firstElem = pendingVertices.poll();
        
        	for(int i = 0; i < adjMatrix.length; ++i){  // visit all the neighbors of currentVertex i.e., firstElem 
            	if(adjMatrix[firstElem][i] == 1 && !visited[i]){
                	pendingVertices.add(i);
                    map.put(i, firstElem);     //parent of neighbour will be the currentVertex (firstElem) i.e., map.put(currentVertex, parent) where currentVertex is key and parent is value.
                    visited[i] = true;
                    
                    if(i == destination){
                        //path found
                        //hence, break;
                        hasPath = true;
                        break;
                    }
                    
                  
            	}
     		}
        }
        
        
        //NOW SIMPLY PRINT THE PATH IF, IT EXISTS.
        if(hasPath){ //then, getPath i.e., print the path (here, put it in ArrayList)
            ArrayList<Integer> pathAns = new ArrayList<>();
            int currentVertex = destination;
            while(currentVertex != -1){
                pathAns.add(currentVertex);
                int parent = map.get(currentVertex);   //currentVertex is the key for which value (parent) will be returned
            	currentVertex = parent;
            }
            return pathAns;
        }else{
            return null;
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
    	
            
        int source = sc.nextInt();
        int destination = sc.nextInt();
            
        ArrayList<Integer> pathAns = new ArrayList<>();
        boolean[] visited = new boolean[adjMatrix.length];
        pathAns = getPathBFS(adjMatrix, source, destination, visited);
            
        if(pathAns != null){
        	for(int i = 0; i < pathAns.size(); ++i){
            	System.out.print(pathAns.get(i) + " ");
        	}
        }
    }
}
