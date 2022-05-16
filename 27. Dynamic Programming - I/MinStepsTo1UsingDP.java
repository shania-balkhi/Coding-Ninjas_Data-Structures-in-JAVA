/*
Min Steps To 1 Using DP

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - 1) ,
2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 10 ^ 6
Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 
Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 - 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
//Iterative DP -
public class Solution {

	public static int countMinStepsToOne(int n) {
        
        //corner case
        if(n == 1){
            return 0;
        }
        if(n == 2 || n == 3){
            return 1;
        }
		
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        for(int i = 4; i < n + 1; ++i){
            
            int ans1, ans2 = Integer.MAX_VALUE, ans3 = Integer.MAX_VALUE;
            
            ans1 = dp[i - 1];
            
            if(i % 2 == 0){
                ans2 = dp[i / 2];
            }
            
            if(i % 3 == 0){
                ans3 = dp[i / 3];
            }
            
            dp[i] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
        }
        
        return dp[n];
        
	}

}






/*algo (for Iterative DP) -
1. corner case - 
   i. for n = 1, no. of steps to reduce it to 1 = 0
   ii. for n = 2, no. of steps to reduce it to 1 = 1
   iii. for n = 3, no. of steps to reduce it to 1 = 1
   
2. we create an array named dp[] of size (n + 1).
  
   array size is taken as 'n + 1' since, suppose given value of n = 6. then we must have the 6th index with us.
   array index values start from 0 and go till n - 1. so, if we take array size as just 'n', then we will have the following 
   indices in our example of n = 6 :
                                    0, 1, 2, 3, 4, 5.
   We see that in this case the array is devoid of the 6th index (without which we can never aarive at the output).
   Hence, we take array size as 'n + 1'
   
3. then, corresponding to the base case values, we fill the index values with their respective values (lines 49 to 51)

4. for the remaining indices till (n + 1), we employ a 'for loop' and the steps below -
  
   4.1 we decalre 3 'int' type variables, namely, 'ans1', 'ans2' and 'ans3'.
       'ans2' and 'ans3' are initialised with the value 'Integer.MAX_VALUE' since it's not
       certain whether we will arrive at a definite value for 'ans2' and 'ans3' respectively;
       since it may happen that no number is divisible by 2 and/or 3 respectievly.
               
       'ans1' may or may not be initialised with the value 'Integer.MAX_VALUE' since it is certain
       that we will arrive at a definite value for 'ans1'; since subtracting a no. > 1(base case) is 
       always allowed in this question.
       
   4.2 we store the value correspoding to the index dp[i - 1] in the variable 'ans1' (line 57)
               
   4.3 we check whether the ith value is divisible by 2. if it is, then we
       store the value correspoding to the index dp[i / 2] in the variable 'ans2' (line 60)
       
   4.4 we check whether the ith value is divisible by 3. if it is, then we
       store the value correspoding to the index dp[i / 3] in the variable 'ans3' (line 64)
       
   4.5 we have to fill each ith index of the 'for loop' till (n + 1)th index.
       so, we fill the index dp[i] with this value :
       												 minimum of all "paths" so explored (i.e., minimum of 'ans1', 'ans2' and 'ans3')
                                                     and add 1 to it.
                                                     
5. we return dp[n] meaning that the nth index of the dp[] arrray stores the desired output.
*/

/*--------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
