class Solution {

	public static int power(int x, int n) {
        //base case
        if (n==0)
            return 1;
        
        int smallOutput = power(x,n-1);
        
        int Output = smallOutput * x;
        
        return Output;
	}
}
