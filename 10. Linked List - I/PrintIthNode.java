public class Solution {
	public static void printIthNode(LinkedListNode<Integer> head, int i){
		LinkedListNode<Integer> temp = head;
        int j = 0;
        while (temp != null && j < i){
            temp = temp.next;
            ++j;
        }
        
        if (temp != null)      
        	System.out.println(temp.data);
	}
}
