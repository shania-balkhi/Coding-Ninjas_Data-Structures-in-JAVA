/*Staircase

A child is running up a staircase with N steps, and can hop either 1 step, 2 steps or 3 steps at a time.
Implement a method to count how many possible ways the child can run up to the stairs. 
You need to return number of possible ways W.
Input format :
Integer N
Output Format :
Integer W
Constraints :
1 <= N <= 30
Sample Input 1 :
4
Sample Output 1 :
7
Sample Input 2 :
5
Sample Output 2 :
13
*/

public class Solution {
	
		
     public static int staircase(int n){
         
        //edge case
         if(n == 0){
             return 1;
         }
         
        //base cases 
		if (n == 1){     //since, if n = 1, W = 1 where W = no. of ways
            return n;
        }
         
        if (n == 2){     // since, if n = 2, W = 2
            return 2;
        }
         
        if (n == 3){     // since, if n = 3, W = 4
            return 4;
        }
         
        
        //induction hypothesis and induction step
        return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);

	}
	
}


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
       "number of steps" !!!! . Hence, no "further addition of steps is required" here.
*/
