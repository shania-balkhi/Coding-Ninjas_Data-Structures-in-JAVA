import java.util.Stack;
class Solution {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		Integer initialSize = input.size();
    
        if(input.size() == 0 || input.size() == 1){
            return;
        }
		
        Integer firstElem = input.pop();
        
        reverseStack(input, extra);

        int delElem = 0;
        while(!input.isEmpty()){
            delElem = input.pop();
            extra.push(delElem);
        }

        input.push(firstElem);
        int delElem2 = 0;
        while(!extra.isEmpty()){
            // input.push(firstElem);

            delElem2 = extra.pop();
            input.push(delElem2);

        }
	}
}
