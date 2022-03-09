class Solution {
	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
		if (head == null || head.next == null){
            return head;
        }else{
            LinkedListNode<Integer> reversedHead = reverseLinkedListRec(head.next);
            LinkedListNode<Integer> tail = reversedHead;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = head;
            head.next = null;
            return reversedHead;
        }
	}
}
