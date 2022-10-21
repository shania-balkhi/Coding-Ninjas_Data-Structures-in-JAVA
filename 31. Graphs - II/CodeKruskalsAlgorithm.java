/*
Code : Kruskal's Algorithm

Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Kruskal's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format - 
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1  <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
Print the MST, as described in the task.
Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
1 2 1
0 1 3
0 3 5
*/

import java.util.*;

class EdgeClass implements Comparable<EdgeClass>{
    
    int v1;
    int v2;
    int wt;
    
    EdgeClass(int v1, int v2, int wt){
        
        this.v1 = v1;
        this.v2 = v2;
        this.wt = wt;
        
    }
    
    public int compareTo(EdgeClass obj){
        return (this.wt - obj.wt);
    }
    
}

public class Solution {

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		EdgeClass[] edgeList = new EdgeClass[E];
        
        for(int i = 0; i < E; ++i){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int wt = sc.nextInt();
            
            EdgeClass edgeObject = new EdgeClass(v1, v2, wt);
            edgeList[i] = edgeObject;
        }
        
        //printing mst
        EdgeClass[] outputEdgeList = new EdgeClass[V - 1];
        outputEdgeList = Kruskal(edgeList, V);
        for(int i = 0; i < outputEdgeList.length; ++i){
            if(outputEdgeList[i].v1 < outputEdgeList[i].v2){
                System.out.println(outputEdgeList[i].v1 + " " + outputEdgeList[i].v2 + " " + outputEdgeList[i].wt);
            }else{
                System.out.println(outputEdgeList[i].v2 + " " + outputEdgeList[i].v1 + " " + outputEdgeList[i].wt);
            }
        }
        
	}
    
    
    public static EdgeClass[] Kruskal(EdgeClass[] edgeList, int V){
        //sort edgeList
        Arrays.sort(edgeList);
        
        //create output[] list for storing mst
        EdgeClass[] output = new EdgeClass[V - 1];
        
        //create and initialise parent[] array
        int[] parent = new int[V];
        for(int i = 0; i < parent.length; ++i){
            parent[i] = i;
        }
        
        int count = 0, i = 0;
        while(count < V - 1){
            //pick the currentEdge
            EdgeClass currentEdge = edgeList[i++];
            
            //get parents of both vertices of the currentEdge you picked
            int PV1 = getParent(currentEdge.v1, parent); //PV1 = parent of V1
            int PV2 = getParent(currentEdge.v2, parent); //PV2 = parent of V2
            
            //if they are not equal, add the earlier picked-out currentEdge to the mst output[] list
            if(PV1 != PV2){
                output[count] = currentEdge;
                ++count;
                
                //update parent
                parent[PV1] = PV2;
            }
        }
        
        return output;
        
    } 
    
    
    //this is a recursive method
    public static int getParent(int v, int[] parent){
        if(v == parent[v]){
            return v;
        }
        return getParent(parent[v], parent);
    }
    
    
}
