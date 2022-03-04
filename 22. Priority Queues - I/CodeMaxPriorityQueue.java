/* formula - 
1. if parentIndex = i, 
   then, leftChildIndex = 2*i + 1;
   and, rightChildIndex = 2*i + 2;
2. if childIndex = i,
   then, parentIndex = (i - 1)/2;
*/

//code
import java.util.ArrayList;
public class PQ {
	ArrayList<Integer> maxHeap;
    
    public PQ(){
        maxHeap = new ArrayList<>();
    }
    
	boolean isEmpty() {
		return maxHeap.size() == 0;
	}

	int getSize() {
		return maxHeap.size();
	}

	int getMax() {
		if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return maxHeap.get(0);
	}
    
    /* algo - insert() -
    1. add the element to the end of heap
    2. set the childIndex = index of element added i.e, lastIndex of the ArrayList; and parentIndex acc. to the formula
    3. perform the up-heapify process as follows
    4. iterate over loop till childIndex has no parentIndex, i.e, childIndex reaches the top i.e, childIndex > 0.
    5. if childElement > parentElement, swap.
    6. and if not, then return;.
    */

	void insert(int element) {
		maxHeap.add(element);
        int childIndex = maxHeap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        
        while(childIndex > 0){
            if(maxHeap.get(childIndex) > maxHeap.get(parentIndex)){
                swap(maxHeap.get(childIndex), maxHeap.get(parentIndex), childIndex, parentIndex);
                
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            }
            else{
                return;
            }
        }
	}
    
    private void swap(int childElement, int parentElement, int childIndex, int parentIndex){ //childElemement == maximumElement in case of removeMax()
		int temp = parentElement;
        maxHeap.set(parentIndex, childElement);
        maxHeap.set(childIndex, temp);
    }
    
    
    /* algo - removeMax() -
    1. if isEmpty(), return -infinity
    2. if not, then store maximumElement for it to be returned at the end
    3. replace that maximumElement with the lastElement of the PQ using ArrayList.set()
    4. remove the last element of the PQ now that it has been re-placed to the top of PQ where initially minimumElement was.
    5. perform the down-heapify process as follows
    6. iterate over loop till leftChildExists i.e, leftChildIndex < size()
    7. find the most maximumElement's index amongst parentElement, leftChildElement & rightChildElement.
    8. if most maximumIndex == parentIndex, means parentElement was the most maximumELement amongst the 3. so break; and come out of the loop as there's no need to traverse further.
    9. if not, then swap the maximumMostElement with the parentElement.
    10. update values of parentIndex, leftChildIndex, rightChildIndex for while loop to continue.
    11. return the maximumMostElement stored earlier in step 2.
    */

	int removeMax() {
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        
		int removedElement = maxHeap.get(0); //this element will be returned by this method
        maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
        maxHeap.remove(maxHeap.size() - 1);
        
        int parentIndex = 0;
        int leftChildIndex = (2 * parentIndex) + 1;
        int rightChildIndex = (2 * parentIndex) + 2;
        
        while(leftChildIndex < maxHeap.size()){
            int maxIndex = parentIndex; //Assume
            if(maxHeap.get(leftChildIndex) > maxHeap.get(maxIndex)){
                maxIndex = leftChildIndex;
            }
            
            if(rightChildIndex < maxHeap.size() && maxHeap.get(rightChildIndex) > maxHeap.get(maxIndex)){
                maxIndex = rightChildIndex;
            }
            
            if(maxIndex == parentIndex){
                break;
            }
            swap(maxHeap.get(maxIndex), maxHeap.get(parentIndex), maxIndex, parentIndex);
            
            parentIndex = maxIndex;
            leftChildIndex = (2 * parentIndex) + 1;
            rightChildIndex = (2 * parentIndex) + 2;
            
        } 
        
        return removedElement;
	}
}
