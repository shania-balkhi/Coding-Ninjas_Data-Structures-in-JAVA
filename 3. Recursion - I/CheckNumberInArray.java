public class Solution {
	
	public static boolean checkNumber(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		
        if(input.length == 0)
            return false;

        int[] smallArray = new int[input.length - 1];
        for(int i = 1; i < input.length; ++i){
            smallArray[i-1] = input[i];
        }
        
        boolean smallAns = checkNumber(smallArray,x);
        if (smallAns == true)
            return true;
        else
            if(input[0]==x)
                return true;
        	else
                return false;
        
	}
}
