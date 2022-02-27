class Solution{
    public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos){
        if(head == null){
            return head;
        }
        if (pos == 0){
            head = head.next;
            return head;
        }else{
            LinkedListNode<Integer> previousNode = head;
            int j = 0;
            while ( j < pos - 1 && previousNode != null){
                previousNode = previousNode.next;
                ++j;
            }
            if (previousNode != null && previousNode.next != null){
                previousNode.next = previousNode.next.next;
            }
        }
        return head;
    }
}
