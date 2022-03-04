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

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

    
    /* algo -
    1. if isEmpty(), throw exception.
    2. if not, then store minimumElement for it to be returned at the end
    3. replace that minimumElement with the last lastElement of the PQ using ArrayList.set()
    4. remove the last element of the PQ now that it has been re-placed to the top of PQ where initially minimumElement was.
    5. perform the up-heapify process as follows
    6. iterate over loop till leftChildExists i.e, leftChildIndex < size()
    7. find the most minimumElement's index amongst parentElement, leftChildElement & rightChildElement.
    8. if most minimumIndex == parentIndex, means parentElement was the most minimumELement amongst the 3. so break; and come out of the loop as there's no need to traverse further.
    9. if not, then swap the minimumMostElement with the parentElement.
    10. update values of parentIndex, leftChildIndex, rightChildIndex for while loop to continue.
    11. return the minimumMostElement stored earlier in step 2.
    */
    
  //code
	int removeMin() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }

        int removedElement = heap.get(0);  //this value is to be returned
        heap.set(0, heap.get(size() - 1)); 
        heap.remove(size() - 1);

        int parentIndex = 0;
        int leftChildIndex = (2 * parentIndex) + 1;
        int rightChildIndex = (2 * parentIndex) + 2;

        //up-heapify
        while(leftChildIndex < size()){
            int minIndex = parentIndex; //Assume
            if(heap.get(leftChildIndex) < heap.get(minIndex)){ //be it minIndex or parentIndex, both are same here
                minIndex = leftChildIndex;
            }

            if(rightChildIndex < size() /*this checks whether rightChild is even present or not*/ && heap.get(rightChildIndex) < heap.get(minIndex)){
                minIndex = rightChildIndex;
            }

            if(minIndex == parentIndex){
                break;
            }

            swapForRemoveMinMethod(heap.get(minIndex), heap.get(parentIndex), minIndex, parentIndex);
            
            parentIndex = minIndex;
            leftChildIndex = (2 * parentIndex) + 1;
            rightChildIndex = (2 * parentIndex) + 2;

        }

        return removedElement;
        
	}
    
    private void swapForRemoveMinMethod(int minPriorityElement, int parentElement, int minIndex, int parentIndex){
        int temp = parentElement;
        heap.set(parentIndex, minPriorityElement);
        heap.set(minIndex, temp);
    }
    
}

class PriorityQueueException extends Exception {

}
