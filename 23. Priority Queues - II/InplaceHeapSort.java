/*note -
1. for ascending order, use maxHeap
2. for descending order, use minHeap
*/

/* formula - 
1. if parentIndex = i, 
   then, leftChildIndex = 2*i + 1;
   and, rightChildIndex = 2*i + 2;
2. if childIndex = i,
   then, parentIndex = (i - 1)/2;
*/

/* TC = O(nlogn)
   SC = O(1)
*/

//code

/* algo -
1. build the tree - just make/transform the input array into it's CBT form - (i) rightChild can't come if previous leftChild isn't there. (ii) follows heap order property
2. for this purpose downheapify the array starting from the index of the last non-leaf node till the top(root)(pos = 0) 
3. heapify is done in the downwards direction of the tree. hence the parameters dowmheapify(arr,i,n);
4. now comes the part to sort the CBT
5. for that just follow the algo of removeMin problem.
6. for this, the entire array will be covered. hence, for(int i = n -2; i >= 0; --i). 
*/

public class Solution {
	public static void inplaceHeapSort(int arr[]) {
		//for building the heap - basically inserting into input array in CBT format
        //this process takes place for all non-leaf nodes and we know that no. of NON-LEAF NODES = n/2
        //hence this process takes O(n) time complexity
        int n = arr.length;
        for(int i = n/2 - 1; i >= 0; --i){
            downheapify(arr, i, n);
        }
        
        //for sorting - basically removing in CBT format
        //removing a node from CBT takes logn time, and since there are (n-1 approx n) nodes to be removed
        //the TC of this process is O(nlogn)
		//here, 1st step is to swap the 0th index element with (n-1)th index element as per the regular process followed while removing a node from CBT
        //it is done in order to let us remove the minElement only
        for(int i = n - 1; i >= 0; --i){
            swap(arr, 0, i);
            downheapify(arr, 0, i);
        }
    }
        
    //swap()
    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    /* algo - for downheapify()
    1. if isEmpty(), throw exception.
    2. if not, then store minimumElement for it to be returned at the end
    3. replace that minimumElement with the last lastElement of the PQ using ArrayList.set()
    4. remove the last element of the PQ now that it has been re-placed to the top of PQ where initially minimumElement was.
    5. perform the down-heapify process as follows
    6. iterate over loop till leftChildExists i.e, leftChildIndex < size()
    7. find the most minimumElement's index amongst parentElement, leftChildElement & rightChildElement.
    8. if most minimumIndex == parentIndex, means parentElement was the most minimumELement amongst the 3. so break; and come out of the loop as there's no need to traverse further.
    9. if not, then swap the minimumMostElement with the parentElement.
    10. update values of parentIndex, leftChildIndex, rightChildIndex for while loop to continue.
    11. return the minimumMostElement stored earlier in step 2.
    */
        
    //downheapify()
    private static void downheapify(int[] arr, int initialParentIndex, int performOperationTillThisIndex){
        //pi == parentIndex
        //lci == leftChildIndex
        //rci == rightChildIndex
        int pi = initialParentIndex;
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
            
        while(lci < performOperationTillThisIndex){
            //mi == minIndex
            int mi = pi; //Assume
            if(arr[lci] < arr[mi]){ //be it minIndex or parentIndex, both are same here
                mi = lci;
            }
            if(rci < performOperationTillThisIndex /*this checks whether rightChild is even present or not*/ && arr[rci] < arr[mi]){
                mi = rci;
            }
            if(mi == pi){
                return;
            }
                
            //call swap()
            swap(arr, mi, pi);
                
            //update these values so that this while loop moves forward with the opeartions
            pi = mi;
            lci = 2 * pi + 1;
            rci = 2 * pi + 2;
        }
    }
}
