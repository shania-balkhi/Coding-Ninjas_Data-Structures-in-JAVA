public class Solution {

	public static int sum(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
        
        return sumOfArray(input,0);
	}
    
    public static int sumOfArray(int input[], int startIndex) {
        if(input.length == startIndex)
            return 0;
        
        int mySum = sumOfArray(input, startIndex + 1);
        mySum = mySum + input[startIndex];
        return mySum;
	}
}
