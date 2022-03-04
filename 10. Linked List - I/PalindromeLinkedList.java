class Solution {
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		if(head == null || head.next == null){  //if head is null || if there is only one element in the linked list
            return true;
        }
        
        //finding length of LL inorder to calculate mid of LL so as to reach to the centre of LL, split it, reverse the second part of LL and then compare the two LLs
       LinkedListNode<Integer> fast = head, slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        LinkedListNode<Integer> firstHead = head;
        LinkedListNode<Integer> secondHead = slow.next; //assigning next of midNode of original LL to secondHeadNode 
        slow.next = null; //temp2 is the supposed tail of the 1st splitted LL. so connecting it's next to null in order to make it so.
        
        
        //calling reverse() on secondHeadNode
        LinkedListNode<Integer> reversedSecondHead = reverseLinkedListRecursively(secondHead);
        
        //comapring the two splitted LLs
        while(reversedSecondHead != null){ //becuase if input LL is even-lengthed, both splitted LLs will have same length only. //and if input LL is odd-lengthed, then the 2nd splitted LL will have larger length acc. to the code we have written
        	if (!reversedSecondHead.data.equals(firstHead.data)){
                return false;
            }                                   
            reversedSecondHead = reversedSecondHead.next;
            firstHead = firstHead.next;
        }
        
        //rejoining the two splitted LLs to restore the input LL to its original form
//         firstHead = head;
//         secondHead = reverseLinkedListRecursively(reversedSecondHead); //obviously reversing the reversedSecondHead bcz in this step we are reforming the oringinal LL
		
//         while(firstHead.next != null){
//             firstHead = firstHead.next;
//         }
        
//         firstHead.next = secondHead;
        
        return true;
	}
    
    private static LinkedListNode<Integer> reverseLinkedListRecursively(LinkedListNode<Integer> head) {
		if (head == null || head.next == null){
            return head;
        }else{
            LinkedListNode<Integer> reversedHead = reverseLinkedListRecursively(head.next);
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
