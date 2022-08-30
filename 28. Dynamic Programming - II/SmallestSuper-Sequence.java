/*
Smallest Super-Sequence

 Given two strings S and T with lengths M and N. Find and return the length of their shortest 'Super Sequence'.
 The shortest 'Super Sequence' of two strings is defined as the smallest string possible that will have both the given strings as its subsequences.
Note :
If the two strings do not have any common characters, then return the sum of the lengths of the two strings. 
Input Format:
The first only line of input contains a string, that denotes the value of string S. The following line contains a string, that denotes the value of string T.
Output Format:
Length of the smallest super-sequence of given two strings. 
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
ab
ac
Sample Output 1 :
3
Explanation of Sample Output 1 :
Their smallest super sequence can be "abc" which has length = 3.
Sample Input 2 :
pqqrpt
qerepct
Sample Output 2 :
9
*/

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 1
// memoization
class Solution {

	public static int smallestSuperSequence(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[i].length; ++j){
                dp[i][j] = -1;
            }
        }
        
    	return SSShelper(str1, str2, 0, 0, dp); //SSS == smallestSuperSequence.//0, 0 means startIndex 0f str1 is 0, also, startIndex of str2 is 0
        
    }
    
    private static int SSShelper(String str1, String str2, int i, int j, int[][] dp) { //i and j represent startIndex of Strings str1 and str2 respectively

        //base case
        if (i == str1.length()){
            return str2.length() - j;
        }
    	if (j == str2.length()){
            return str1.length() - i;
        }
        
        //memocheck
    	if(dp[i][j] != -1){
            return dp[i][j];
        }
    
    	//induction hypothesis and induction step
    	int ans = 0;
    	if (str1.charAt(i) == str2.charAt(j)){
            dp[i][j] = 1 + SSShelper(str1, str2, i + 1, j + 1, dp);
        }
    	else{
    		dp[i][j] = 1 + Math.min( SSShelper(str1, str2, i + 1, j, dp), SSShelper(str1, str2, i, j + 1, dp));
        }
        
    	
        
    	return dp[i][j];
        
    }

}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 2
//tabulation
//bottom-up approach
public class Solution {

	public static int smallestSuperSequence(String str1, String str2) {

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        //for filling last row
        for(int i = 0; i <= str2.length(); ++i){
            dp[str1.length()][i] = str2.length() - i;
        }
        
         //for filling last column
        for(int i = 0; i <= str1.length(); ++i){
            dp[i][str2.length()] = str1.length() - i;
        }
        
        for(int i = dp.length - 2; i >= 0; --i){
            for(int j = dp[i].length - 2; j >= 0; --j){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return dp[0][0];
        
	}
    
}

/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

