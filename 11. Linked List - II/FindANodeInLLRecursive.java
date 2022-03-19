public class Solution {
	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
    	return findNodeRecHelper(head, n, 0);
	}

    private static int findNodeRecHelper(LinkedListNode<Integer> head, int n, int index){
        LinkedListNode<Integer> temp = head;
        if(temp == null){
            return -1;
        }
        
        if(temp.data == n){
            return index;
        }
        
        return findNodeRecHelper(temp.next, n, index + 1);
    }
}
