class Solution {
    public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
        if (head == null) {
            return null;
        }

        LinkedListNode<Integer> temp = head;
        while (temp != null) {
            if (temp.next != null && temp.data.equals(temp.next.data)) {
                LinkedListNode<Integer> temp2 = temp.next.next;
                temp.next = temp2;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
