class Solution{
    public static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2){
        
        if(head1 == null){
            return head2;
        }
        
        if(head2 == null){
            return head1;
        }
        
        LinkedListNode<Integer> t1 = head1, t2 = head2;
        LinkedListNode<Integer> grandHead = null, grandTail = null;

         if(t1.data <= t2.data){
                grandHead = head1;
                grandTail = t1;
                t1 = t1.next;
         }else{
                grandHead = head2;
                grandTail = t2;
                t2 = t2.next;
         }
        
        
        
         while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                grandTail.next = t1;
                grandTail = t1;
                t1 = t1.next;
            }else{
                grandTail.next = t2;
                grandTail = t2;
                t2 = t2.next;
            }
         }
        
        

        if(t2 != null){
            grandTail.next = t2;
        }
        if(t1 != null){
            grandTail.next = t1;
        }

        return grandHead;

    }
}
