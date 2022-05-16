/*
Minimum Number Of Squares
Send Feedback
Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1,
as 1 is the minimum count of numbers required to represent N as sum of squares.
Input format :
The first and the only line of input contains an integer value, 'N'.
 Output format :
Print the minimum count of numbers required.
Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)

B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)  + (2 ^ 2)

C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.
Sample Input 2 :
9
Sample Output 2 :
1
*/

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//2. Recursive DP (Recusrion + memoization)
//Time Complexity : O(n * root n) where 'n' = no. of unique calls and 'root n' = time each call takes
// public class Solution {
    
//     public static int minCount(int n){
//         int[] dp = new int[n + 1];
//         for(int i = 0; i < dp.length; ++i){
//             dp[i] = -1;
//         }
//         return minCount(n, dp);
//     }

// 	private static int minCount(int n, int[] dp) {
		
//         //base case
//         if(n == 0){
//             return 0;
//         }
        
//         //induction hypothesis and memoization
//         int minAns = Integer.MAX_VALUE;
//         for(int i = 1; i * i <= n; ++i){
//             int ans;
//             if(dp[n - (i * i)] == -1){
//                 ans = minCount(n - (i * i), dp);
//                 dp[n - (i * i)] = ans;
//             }else{
//                 ans = dp[n - (i * i)];
//             }
            
//             if(ans < minAns){
//                 minAns = ans;
//             }
//         }
        
//         //induction step
//         return minAns + 1;
        
// 	}

// }





/*
algo (Recursive DP (Recusrion + memoization))
1. we have two methods in the 'Solution' class, namely,
   i. public static int minCount(int n), and
   ii. private static int minCount(int n, int[] dp)
   
2. in the 'public static int minCount(int n)' method,
   2.1 we create an array named dp[] of size (n + 1) and initialize all it's indices with value '-1'.
  
   note - array size is taken as 'n + 1' since, suppose given value of n = 6. then we must have the 6th index with us.
   array index values start from 0 and go till n - 1. so, if we take array size as just 'n', then we will have the following 
   indices in our example of n = 6 :
                                    0, 1, 2, 3, 4, 5.
   We see that in this case the array is devoid of the 6th index (without which we can never aarive at the output).
   Hence, we take array size as 'n + 1'
   
   2.2 then, we call this 'private static int minCount(int n, int[] dp))' method.
  
3. Inside the 'private static int minCount(int n, int[] dp))' method -
    This is the core recursive code/method that solves this problem.
    
    3.1 base case -
         when n becomes equal to 0, return 0 since n becoming 0 indicates that our hypothesis which is
         'minCount(n - (i * i))' has become 'minCount(0)' which is when we have to return the base case
         value ('0') to the method that called it.
         
    3.2 memoization & induction hypothesis - 
        we have to explore all the "paths" starting from i = 1 till i * i <= n.
   		along each path, we have to determine the minCount of sqaures needed.
   		then of all these paths, we have to find the minimum of those minCOunts so calculated.
   
    	3.2.1. we decalre 1 'int' type variable, namely, 'minAns' and initialise it with 'Integer.MAX_VALUE'
        
        	   note - we initialise 'minAns' in order to avoid this error -
                      "
                      Compilation Failed
					  ./Solution.java:99: error: variable minAns might not have been initialized
            															if(ans < minAns){
                     														 ^
					  ./Solution.java:105: error: variable minAns might not have been initialized
        															  return minAns + 1;
               															  ^
					  2 errors
                      "
               
    	3.3.2. we check whether the (n - (i * i))th index in the dp[] array priorly contains a value or not.
        	   no value is indicated by '-1'.
               
               3.3.2.1 So if the concerned index is filled with value '1', then it can be infered that that index does
               		   	not hold a prior value, hence we have to make a recursive call to 'minCount(n - (i * i), dp)' method and
               		   	store in the variable 'ans'. (line 62)
                        
               3.3.2.2 now that we have made the recursive call mentioned in the previous step 3.3.2.1., we have to store 
                       the value returned by this function call in the (n - (i * i))th index of the dp[] array. (line 63)
                       
               3.3.2.3 if the concerned cell was not filled by the value '-1' in the first place, one can infer that the 
                        index concerned did hold a valid value priorly; and that value is the required value. Hence, we store 
                        that value in the 'ans' variable. (line 65)
                        
               3.3.2.4 the loop continues till the nth index of the dp[] array.
               
4. induction step
   we have to add 1 to the min value calculated in step 2.
   1 is being added because recursion only returns us the value till minCount(n - (i * i)), so after that, naturally a plus one is need
   to get to the final answer. (dry run for more clarity on this)
   
5. return the answer calculated in step 4.
*/








//2. Iterative DP -
public class Solution {

	public static int minCount(int n) {
		
        //corner case (the lines 196 to 199 is effectively not needed since line 202 takes care of it!)
        // if(n == 0){
        //     return 0;
        // }
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i < dp.length; ++i){
            int minAns = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; ++j){
                int ans = dp[i - (j * j)];
                
                if(ans < minAns){
                    minAns = ans;
                }
            }
            dp[i] = minAns + 1;
        }
        
        return dp[n];
        
	}

}


/*algo (for Iterative DP) -

For filling any ith index of the dp[] array, we need the values of previous ith indices 
(i.e., (i - 1), (i - 2)...(i - 5).... and so on).
In the Recursive-DP code, we were finding the value of each 'n' but here in the Iterative-DP code,
we have to find the value for each 'i' (indices of the array). Hence two 'for loops' will be employed
here. The outer for loop to keep track of each ith index coresponding to whose value, the number of sqaures
is to be found (with the help of another inner for loop); and the inner for-loop for determining
the no. of squares required for the value corresponding to the outer for-loop's current index!

1. corner case - when n becomes equal to 0, return 0 since n becoming 0 indicates that our
			   hypothesis which is 'minCount(n - (i * i))' has become 'minCount(0)' which
               is when we have to return the base case value ('0') to the method that called it.
               
2. we create an array named dp[] of size (n + 1).
  
   array size is taken as 'n + 1' since, suppose given value of n = 6. then we must have the 6th index with us.
   array index values start from 0 and go till n - 1. so, if we take array size as just 'n', then we will have the following 
   indices in our example of n = 6 :
                                    0, 1, 2, 3, 4, 5.
   We see that in this case the array is devoid of the 6th index (without which we can never aarive at the output).
   Hence, we take array size as 'n + 1'
   
3. then, corresponding to the base case value, we fill the index value with its respective value (lines 171)

4. for the remaining indices till (n + 1), we employ a for loop to keep track of each ith index coresponding
   to whose value, the number of sqaures is to be found (with the help of another inner for loop)
   
5. we decalre 1 'int' type variable, namely, 'minAns' and initialise it with 'Integer.MAX_VALUE'
        
        	   note - we initialise 'minAns' in order to avoid this error -
                      "
                      Compilation Failed
					  ./Solution.java:99: error: variable minAns might not have been initialized
            															if(ans < minAns){
                     														 ^
					  ./Solution.java:105: error: variable minAns might not have been initialized
        															  return minAns + 1;
               															  ^
					  2 errors
                      "

6. a second inner for-loop is employed for determining the no. of squares required for the value
   corresponding to the outer for-loop's current index
   
7. inside the inner for-loop, we find the value corresponding to the index 'i - (j * j)' in the dp[] 
   array and store it in a variable, say 'ans' of type 'int' i.e., 
                                                     int ans = dp[i - (j * j)];
   where i is the outer for-loop variable and 'j' is the inner for-loop variable.
   
8. we compare the values of 'ans' and 'minAns' variable. if 'ans' is smaller than 'minAns', then we store 
   the value of 'ans' in 'minAns' since our object is to find the minimum of the "ans's" so calculated.
   (in order to find the minimum-no.-of-squares-required-for-the-value-corresponding-to-the-ith-index-of-outer-forLoop)
   
   
9. after step 8, when the 'minimum-no.-of-squares-required-for-the-value-corresponding-to-the-ith-index-of-outer-forLoop'
   has been found, we add 1 to it and store it in the ith index of the dp[] array.
   
10. finally, we return dp[n] meaning that the nth index of the dp[] arrray stores the desired output.
*/

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------*/
