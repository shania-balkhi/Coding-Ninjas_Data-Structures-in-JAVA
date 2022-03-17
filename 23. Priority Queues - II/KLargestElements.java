import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution {
	public static ArrayList<Integer> kLargest(int input[], int k) {
        
        //1. create object of inbuilt PQ
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        //2. add first k elements of the input array to the inbuilt PQ (assuming them to be the largest k elements)
        //adding the elements to this inbuilt PQ will automatically bring the elements in the required CBT form(obviously!!)
        for(int i = 0; i < k; ++i){
            pq.add(input[i]);
        }
        
        //3. check for the rest of the (n - k) elements whether they are less than or more than the peek of the PQ.
        //the peek os the PQ returns the minimum-most element of the PQ since by fault, the inbuilt PQ is a min-PQ.
        //if the ith element here in the input array is greater than the peek of the PQ, then poll() the peek and add that ith element in the PQ.
        //all the elements in the PQ will be internally adjusted in the CBT (min-heap) format; [here containing the k largest elements in this PQ]. 
        for(int i = k; i < input.length; ++i){
            if(input[i] > pq.peek()){
                pq.poll();
                pq.add(input[i]);
            }
        }
        
        
        //4. copy the output of the PQ to an ArrayList since the return type of the method is ArrayList.
        //then return the ArrayList.
        ArrayList<Integer> al = new ArrayList<>();
        while(!pq.isEmpty()){
            al.add(pq.poll());
        }
        
        return al;
	}
}
