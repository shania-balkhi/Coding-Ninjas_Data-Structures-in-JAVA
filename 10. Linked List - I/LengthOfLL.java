public class Solution {
	public static int length(LinkedListNode<Integer> head){
		LinkedListNode<Integer> temp = head;
        int len = 0;
        while (temp != null){
            ++len;
            temp = temp.next;
        }
        return len;
	}
}
