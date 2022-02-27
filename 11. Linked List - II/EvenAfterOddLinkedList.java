public class Solution {
	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
        if(head == null){
            return null;
        }
		LinkedListNode<Integer> OddH = null, OddT = null, EvenH = null, EvenT = null;
        while(head != null){
            if((head.data) % 2 == 0){ //even
                if(EvenH == null){
                    EvenH = head;
                    EvenT = head;
                }else{
                    EvenT.next = head;
                    EvenT = head;
                }   
            }else{   //odd
                if(OddH == null){
                    OddH = head;
                    OddT = head;
                }else{
                    OddT.next = head;
                    OddT = head;
                }
            }
            head = head.next;
        }
        
        if(OddH != null && EvenH != null){
            OddT.next = EvenH;
        }
        
        if(EvenH != null){
        	EvenT.next = null;
        }
        
        
        if(OddH != null){
        	return OddH;
        }else{
            return EvenH;
        }
        
	}
}
