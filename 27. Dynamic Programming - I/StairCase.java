/*
Stair Case
Send Feedback
A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to 
count and return all possible ways in which the child can run-up to the stairs.
Input format :
The first and the only line of input contains an integer value, 'n', denoting the total number of steps.
Output format :
Print the total possible number of ways.
 Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7
Sample Input 2:
10
Sample Output 2:
274
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//1. Recursion 
// public class Solution {

// 	public static long staircase(int n) {
        
		//edge case
		//if(n == 0){
			//return 1;
		//}

// 		//base case
//      	if(n == 1 || n == 2){
//             return n;
//         }
        
//         if(n == 3){
//             return 4;
//         }
        
//         //induction hypothesis
//         long ans1 = staircase(n - 1);
//         long ans2 = staircase(n - 2);
//         long ans3 = staircase(n - 3);
        
//         // induction step
//         return  ans1 + ans2 + ans3;
        
// 	}

// }



/*
algo (for Recursion) -
1. edge case
   for 0 steps, we have no. of ways = 1 

2. base case - 
   i. for 1 step, we have no. of ways = 1
   ii. for 2 steps, we have no. of ways = 2
   iii. for 3 steps, we have no. of ways = 4
   
3. induction hypothesis - 
   in order to reach the nth step, the child can either take a jump from
   i. the (n - 1)th step, or
   ii. the (n - 2)th step, or
   iii. the (n - 3)th step; as per the question
   
   hence we find staircase(n - 1), staircase(n - 2) and staircase(n - 3)
   (and store these in ans1, ans2 and ans3 respectively).
   
4. induction step -
   in order to find the total number of ways to reach the nth step,
   if we take the sum of the
   i. number of ways to reach the (n - 1)th step, and
   ii. number of ways to reach the (n - 2)th step, and
   iii. number of ways to reach the (n - 1)th step;
   it will give us the total possible 'number of ways to reach the nth step'.
   
   
NOTE - don't confuse with having to find the 'number of steps' to reach the nth step. If one does so,
       one may argue that we need to add "further steps" from (n - 1), and/or (n - 2), and/or (n - 3) step(s)
       to the nth step. However, our concern is to find the "NUMBER OF WAYS" to reach the nth step & not the 
       "number of steps!" . Hence, no "further addition of steps is required" here.
*/


//2. Recursion + Memoization
// public class Solution {
    
//     public static long staircase(int n){
//         long[] dp = new long[n + 1];
//         for(int i = 0; i < n + 1; ++i){
//             dp[i] = -1;
//         }
//         return staircase(n, dp);
//     }

// 	private static long staircase(int n, long[] dp) {
        
//      //edge case
//         if(n == 0){
// 			return 1;
// 		}
        
// 		//base case
//      	if(n == 1 || n == 2){
//             return n;
//         }
        
//         if(n == 3){
//             return 4;
//         }
        
        
//         //memoization & induction hypothesis
//         long ans1, ans2, ans3;
//         if(dp[n - 1] == -1){
//             ans1 = staircase(n - 1, dp);     //induction hypothesis
//             dp[n - 1] = ans1;                //memoization
//         }else{
//             ans1 = dp[n - 1];
//         }
        
//         if(dp[n - 2] == -1){
//             ans2 = staircase(n - 2, dp);     //induction hypothesis
//             dp[n - 2] = ans2;                //memoization
//         }else{
//             ans2 = dp[n - 2];
//         }
        
//         if(dp[n - 3] == -1){
//             ans3 = staircase(n - 3, dp);     //induction hypothesis
//             dp[n - 3] = ans3;                //memoization
//         }else{
//             ans3 = dp[n - 3];
//         }
        
        
//         // induction step
//         return  ans1 + ans2 + ans3;
        
// 	}

// }



/* algo (for  Recursion + Memoization) -
1. we have two methods in the 'Solution' class, namely,
   i. public static long staircase(int n), and
   ii. private static long staircase(int n, long[] dp)
   
2. in the 'public static long staircase(int n)' method,
   2.1 we create an array named dp[] of size (n + 1) and initialize all it's indices with value '-1'.
  
   note - array size is taken as 'n + 1' since, suppose given value of n = 6. then we must have the 6th index with us.
   array index values start from 0 and go till n - 1. so, if we take array size as just 'n', then we will have the following 
   indices in our example of n = 6 :
                                    0, 1, 2, 3, 4, 5.
   We see that in this case the array is devoid of the 6th index (without which we can never aarive at the output).
   Hence, we take array size as 'n + 1'
  
  2.2 then, we call this 'staircase(n, dp)' method.
  
3. Inside the 'private static long staircase(int n, long[] dp)' method -
    This is the core recursive code/method that solves this problem.
    
    3.1 edge case
   		for 0 steps, we have no. of ways = 1 

	3.2 base case - 
   		i. for 1 step, we have no. of ways = 1
   		ii. for 2 steps, we have no. of ways = 2
   		iii. for 3 steps, we have no. of ways = 4
        
    3.3 memoization & induction hypothesis - 
    	3.3.1. we decalre 3 'long' type variables, namely, 'ans1', 'ans2' and 'ans3'
        
        3.3.2. we check whether the (n - 1)th index in the dp[] array priorly contains a value or not.
        	   no value is indicated by '-1'.
               		   
               3.3.2.1 So if the concerned index is filled with value '1', then it can be infered that that index does
               		   	not hold a prior value, hence we have to make a recursive call to 'staircase(n - 1, dp)' method and
               		   	store in the variable 'ans1'. (line 125)
                       
               3.3.2.2 now that we have made the recursive call mentioned in the previous step 3.3.2.1., we have to store 
                        the value returned by this function call in the (n - 1)th index of the dp[] array. (line 126)
                                  
               3.3.2.3 if the concerned cell was not filled by the value '-1' in the first place, one can infer that the 
                        index concerned did hold a valid value priorly; and that value is the required value. Hence, we store 
                        that value in the 'ans1' variable. (line 128)
                        
        3.3.3 repeat step no. 3.3.2 for (n - 2)th as well as (n - 3)th index in the dp[] array.
        
    3.4 induction step -
        sum up the values stored in 'ans1', 'ans2' and 'ans3' variables.
        
    3.5 return the sun calculated in step 3.4
                                  
    
    
NOTE - it is advised to look at the algo for the recursive code above (without memoization) for better understading of the code 
       involving recursion with memoization.
*/




//3. Iterative DP
public class Solution {

	public static long staircase(int n) {
		//edge case
        if(n == 0){
			return 1;
		}
        
		//base case
     	if(n == 1 || n == 2){
            return n;
        }
        
        if(n == 3){
            return 4;
        }
        
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i = 4; i < n + 1; ++i){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[n];
        
	}

}



/*algo (for Iterative DP) -
1. edge case
   for 0 steps, we have no. of ways = 1 

2. base case - (note - this is not a recursive method but iterative)
   i. for 1 step, we have no. of ways = 1
   ii. for 2 steps, we have no. of ways = 2
   iii. for 3 steps, we have no. of ways = 4

3. we create an array named dp[] of size (n + 1).
  
   array size is taken as 'n + 1' since, suppose given value of n = 6. then we must have the 6th index with us.
   array index values start from 0 and go till n - 1. so, if we take array size as just 'n', then we will have the following 
   indices in our example of n = 6 :
                                    0, 1, 2, 3, 4, 5.
   We see that in this case the array is devoid of the 6th index (without which we can never aarive at the output).
   Hence, we take array size as 'n + 1'
   
4. then, corresponding to the base case values, we fill the index values with their respective values (lines 235 to 238)

5. for the remainind indices till (n +1), we employ a for loop in which the ith index stores the sum of the values corresponding
   to the indices (i - 1), (i - 2) and (i - 3).
   
6. we return dp[n] meaning that the nth index of the dp[] arrray stores the desired output.



NOTE - it is advised to look at the algo for the recursive code above (without memoization) for better understading of the ierative DP 
       method.
       
/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
