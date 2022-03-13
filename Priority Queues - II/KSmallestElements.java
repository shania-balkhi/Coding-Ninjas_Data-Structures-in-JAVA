/*note -
1. code is exactly similar to k largest elements problem except changes in the two lines : line 15 and line 28
2. in order to make use of max PQ, write 'PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());'
3. in line 37, write < instead of > 
*/

//code
import java.util.ArrayList;
import java.util.*; //necessary to import in order to use Collections.reverseOrder()
// import java.util.PriorityQueue;
public class Solution {
	public static ArrayList<Integer> kSmallest(int n, int input[], int k) {
        
        //1. create object of inbuilt PQ
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //2. add first k elements of the input array to the inbuilt PQ (assuming them to be the smallest k elements)
        //adding the elements to this inbuilt PQ will automatically bring the elements in the required CBT form(obviously!!)
        for(int i = 0; i < k; ++i){
            pq.add(input[i]);
        }
        
        //3. check for the rest of the (n - k) elements whether they are less than or more than the peek of the PQ.
        //the peek of the PQ returns the minimum-most element of the PQ since by fault, the inbuilt PQ is a min-PQ.
        //hence, use Collections.reverseOrder() to make use of max PQ.
        //if the ith element here in the input array is less than the peek of the PQ, then poll() the peek and add that ith element in the PQ.
        //all the elements in the PQ will be internally adjusted in the CBT (max-heap) format; [here containing the k smallest elements in this PQ]. 
        for(int i = k; i < input.length; ++i){
            if(input[i] < pq.peek()){
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
