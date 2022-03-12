public class Solution {
	public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
        LinkedListNode<Integer> curr = head, prev = null, fwd = null;
        while(curr != null){
            fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
	}
}
