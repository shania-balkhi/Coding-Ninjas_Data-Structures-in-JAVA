/*LCS - Problem

Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Input format :
The first line of input contains the string 'S' of length 'M'.

The second line of the input contains the string 'T' of length 'N'.
Output format :
Return the length of the Longest Common Subsequence.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
*/

//1. Brute-force recursive solution
//gives TLE (obviously!) since it's a DP problem which we have first solved using just brute-force recursion here.
public class Solution {
    
    public static int lcs(String s, String t) {
        return lcs(s,t,0,0);
    }

	public static int lcs(String s, String t, int i, int j) {
		
        if(i >= s.length() || j >= t.length()){
            return 0;
        }
        

        int ans = 0;
            if( s.charAt(i) == t.charAt(j) ){
                ans += 1 + lcs(s, t,  i + 1, j + 1);
            }else{
                ans += Math.max( lcs(s, t,  i, j + 1), lcs(s, t,  i + 1, j) );
            }

        return ans;
    }

}

/*documentation -
1. logic - 1.1 if the first char of both Strings is same, add 1 to answer plus make recursive calls to for the rest of the characters 
           		present in both strings s and t.
           1.2 if the char of both Strings is not same, then make recursive calls in "seesaw mannner" ('''my lingo XD'''); meaning
           		that, first, include 'all chars of the first string' and 'all chars of second string except the present char'; 
                secondly, include 'all chars of first string except the present char' and 'all chars of the second string'. Then take the
                max of these two (line 62). 
           1.3 store values so calculated by lines 1.1 and 1.2 and store them in a variable. namely, 'ans' and return it.
*/

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//2. Recursive DP Solution
//Time Complexity : O(m*n)
public class Solution {

	public static int lcs(String s, String t) {
		
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[i].length; ++j){
                dp[i][j] = -1;
            }
        }
        
        return lcs(s,t,0,0,dp);
        
    }
    
    
    private static int lcs(String s, String t, int i, int j, int[][] dp){
        //base case
        if(i >= s.length() || j >= t.length()){
            return 0;
        }
        
        //memoization
        int ans;
        if(s.charAt(i) == t.charAt(j)){
            int smallAns;
            if(dp[i + 1][j + 1] == -1){
                smallAns = lcs(s, t,  i + 1, j + 1, dp);
                dp[i + 1][j + 1] = smallAns;
            }else{
                smallAns = dp[i + 1][j + 1];
            }
            ans = 1 + smallAns;
        }else{
            int smallAns1, smallAns2;
            
            //for smallAns1
            if(dp[i][j + 1] == -1){
                smallAns1 = lcs(s, t,  i, j + 1, dp);
                dp[i][j + 1] = smallAns1;
            }else{
                smallAns1 = dp[i][j + 1];
            }
            
            //for smallAns2
            if(dp[i + 1][j] == -1){
                smallAns2 = lcs(s, t,  i + 1, j, dp);
                dp[i + 1][j] = smallAns2;
            }else{
                smallAns2 = dp[i + 1][j];
            }
            
            ans = Math.max(smallAns1, smallAns2);
            
        }
        
        return ans;
        
    }
    

}

//algo - (for Recursive DP)
/*
1. we have three methods in the 'Solution' class, namely,
   i. public static int lcs(String s, String t), and
   ii. private static int lcs(String s, String t, int i, int j, int[][] dp)

		1.1. about the 'public static int lcs(String s, String t)' method -
    	 	 see step 2 for complete explanation of this method.
    
    
    	1.2 about the 'private static int lcs(String s, String t, int i, int j, int[][] dp)' method -
            This is the core recursive code/method that solves this problem. We'll explore 
            this method in later steps.
            
2. in the 'public static int lcs(String s, String t)' method,
   2.1 we create a 2d-matrix named dp[][] of rowSize (m + 1) and columnSize (n + 1) and initialize all 
   	   it's indices with value '-1'.   (m = no. of rows in input[][] and n = no. of columns in input[][])
  
   note1 - array rowSize and columnSize are taken as (m + '1') and (n + '1') respectively in order to create one
   extra row and one extra column in order to dodge the 'ArrayIndexOutOfBoundsException' which is certain to get 
   triggered if we take the respective values as just 'm' and 'n' only! (watch 4. MinCost Memoization @00:09:33 for more clarity)
   
   note2 - instead of incrementing the rowSize and columnSize with 1, we could have written separate lines of code to
   keep a check that the recursive function calls, do not inflict 'ArrayIndexOutOfBoundsException' error. Hence, the programmar could
   chose any of the 2 above mentioned ways to dodge the 'ArrayIndexOutOfBoundsException' error.
  
  2.2 then, we call this 'private static int lcs(String s, String t, int i, int j, int[][] dp))' method.
  
3. Inside the 'private static int lcs(String s, String t, int i, int j, int[][] dp)' method -
    This is the core recursive code/method that solves this problem.
    
    logic - 3.1 if the first char of both Strings is same, add 1 to answer plus make recursive calls for the rest of the characters 
           		present in both strings s and t.
           3.2 if the char of both Strings is not same, then make recursive calls in "seesaw mannner" ('''my lingo XD'''); meaning
           		that, first, include 'all chars of the first string' and 'all chars of second string except the present char'; 
                secondly, include 'all chars of first string except the present char' and 'all chars of the second string'. Then take the
                max of these two (line 62). 
           3.3 store values so calculated by lines 3.1 and 3.2 and store them in a variable. namely, 'ans' and return return the max
               of both.
	       
/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//3. Iterative DP Solution
//Using bottom-up approach
public class Solution {

	public static int lcs(String s, String t) {
        
		int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[i].length; ++j){
                dp[i][j] = 0;
            }
        }
        
        for(int i = dp.length - 2; i >= 0; --i){
            for(int j = dp[i].length - 2; j >= 0; --j){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        
        return dp[0][0];
        
    }

}

/*documentation - 
	1. we create an array named dp[][] of rowSize (m + 1) and columnSize (n + 1) and initialize all 
   	   it's indices with value '0'.
       (m = size of String s and n = size of String t)
  
   note1 - array rowSize and columnSize are taken as (m + '1') and (n + '1') respectively in order to create one
   extra row and one extra column in order to dodge the 'ArrayIndexOutOfBoundsException' which is certain to get 
   triggered if we take the respective values as just 'm' and 'n' only! (watch 4. MinCost Memoization @00:09:33 for more clarity)
   
   note2 - instead of incrementing the rowSize and columnSize with 1, we could have written separate lines of code to
   keep a check that the recursive function call, does not inflict 'ArrayIndexOutOfBoundsException' error. Hence, the programmar could
   chose any of the 2 above mentioned ways to dodge the 'ArrayIndexOutOfBoundsException' error.
   
   
   2. Now, in this dp[][] matrix, we start traversing from the last cell, backwards till the [0,0] index. (line 433 & 434)
      
      Now, the logic used between lines 435 to 439 is :
      	
        logic - 
           2.1  if the first char of both Strings is same, then for the current [i][j]th index od dp[][] matrix,
        			 add 1 and the value in [i + 1][j + 1]th index of dp[][] matrix and store in the current index; i.e.,
        
                                            if(s.charAt(i) == t.charAt(j)){
                                                dp[i][j] = 1 + dp[i + 1][j + 1];
                                            }
        
       
           2.2 if the char of both Strings is not same, then store the required value in the current index
                in "seesaw mannner" ('''my lingo XD'''); meaning that, first, include 'all chars of the first string' and
                'all chars of second string except the present char'; 
                secondly, include 'all chars of first string except the present char' and 'all chars of the second string'. Then take the
                max of these two (line 62). 
                
                In simple words, take the max of dp[i][j + 1] value and dp[i + 1][j] value and store it in the current index; i.e.,
                
                							else{   //if the char of both Strings is not same
                    							dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                							}
          
          
  3. we return dp[0][0] meaning that the [0][0]th index of the dp[][] matrix stores the desired output.
*/

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
