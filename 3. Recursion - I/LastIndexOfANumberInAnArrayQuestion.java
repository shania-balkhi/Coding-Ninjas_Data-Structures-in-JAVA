
public class Solution {

	// public static int lastIndex(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
	// }
	
     public static int lastIndex(int input[], int x){
        int finalAns = lastIndexSolution(input, x, 0);
        return finalAns;
    }
    
    public static int lastIndexSolution(int input[], int x,int startIndex){
        
        if(startIndex == input.length)
            return -1;

        int ans1 = lastIndexSolution(input, x, startIndex + 1);
        if (ans1 == -1){
            if (input[startIndex] == x)
                return 0;
            else
                return -1;
        }
        else
            return ans1 + 1;    

    }
    
}
