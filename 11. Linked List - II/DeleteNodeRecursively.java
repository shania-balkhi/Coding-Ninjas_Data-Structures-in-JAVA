public class Solution {
	public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
    	if (head == null){  
            return head;
        }
        
        if (pos == 0){
            head = head.next;
            return head;
        }else{
            LinkedListNode<Integer> smallHead = deleteNodeRec(head.next, pos - 1);
            head.next = smallHead;
            return head;
        }
	}
}
