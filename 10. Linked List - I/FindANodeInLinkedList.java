public class Solution {
	public static int findNode(LinkedListNode<Integer> head, int n) {
        
        if(head == null){
            return -1;
        }
    
        int count = 0;
		LinkedListNode<Integer> temp = head;
        while(temp != null){
        	if (temp.data == n){
                return count;
        	}
            ++count;
            temp = temp.next;
        }
        return -1;
	}
}
