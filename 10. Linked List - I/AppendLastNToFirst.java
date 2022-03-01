public class Solution{
    public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n){
        if(n == 0){
            return head;
        }
        if(head == null){
            return null;
        }
        
        LinkedListNode<Integer> temp = head;
        int length = 0;
        while(temp.next != null){
            ++length;
            temp = temp.next;
        }
        
        int lengthOfLLToBeAppended = length - n;
        LinkedListNode<Integer> temp2 = head;
        while(lengthOfLLToBeAppended != 0){
            temp2 = temp2.next;
            --lengthOfLLToBeAppended;
        }
        
        LinkedListNode<Integer> newHead = temp2.next;
        temp2.next = null;
        LinkedListNode<Integer> temp3 = newHead;
        while(temp3.next != null){
            temp3 = temp3.next;
        }
        temp3.next = head;
        
        return newHead;
        
    }
}
