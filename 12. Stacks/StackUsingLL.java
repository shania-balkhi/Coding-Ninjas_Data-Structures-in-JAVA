public class Stack {

    private Node head;
    private int size;


    public Stack() {
        head = null;
        size = 0;
    }



//     /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        return size;
    }

    public boolean isEmpty() {
        if (head == null){
        	return true;
        }
        else{
        return false;
        }
    }

    public void push(int element) {
         Node newNode = new Node(element);
         newNode.next = head;
         head = newNode;
         
         ++size;
    }

    public int pop() {
       if(isEmpty()){
       return -1;
       }
       
       int delElem = head.data;
       head = head.next;
       
       --size;
       return delElem;
    }

    public int top() {
        if(isEmpty()){
        	return - 1;
        }
        return head.data;
    }
}
