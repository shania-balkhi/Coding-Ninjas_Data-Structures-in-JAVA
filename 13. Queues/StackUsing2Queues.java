import java.util.LinkedList;
import java.util.Queue;

public class Stack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;


    public Stack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        return q1.size();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public void push(int element) {
        q1.add(element);
    }

    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size() != 1){
            q2.add(q1.poll());
        }
        Integer delElem = q1.poll();
        
        while(q2.size() != 0){
            q1.add(q2.poll());
        }
        return delElem;
    }

    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        while(q1.size() != 1){
            q2.add(q1.poll());
        }
        
        Integer topElem = q1.poll();
        q2.add(topElem);
        
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return topElem;
    }
}
