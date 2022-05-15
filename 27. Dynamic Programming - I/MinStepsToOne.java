/*
Min Steps To One

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - 1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Write brute-force recursive solution for this.
Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.
Constraints :
1 <= n <= 200

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

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

public class Solution {

	public static int countMinStepsToOne(int n) {
		
        //base case
        if(n == 1){
            return 0;
        }
        
        //induction hypothesis
        int ans1 = countMinStepsToOne(n - 1);
        int ans2 = Integer.MAX_VALUE;
        int ans3 = Integer.MAX_VALUE;
        if(n % 2 == 0){
            ans2 = countMinStepsToOne(n/2);
        }
        if(n % 3 == 0){
            ans3 = countMinStepsToOne(n/3);
        }
        
        //induction step
        return Math.min(ans1, Math.min(ans2, ans3)) + 1;
        
	}

}



/*
algo - (simple recursion, DP not employed)
1. Here, Greedy Technique will not work !!!!!!! And so the technique we have to use here is to explore
   all the paths -
   i. (n - 1), 
   ii. (n / 2) if n % 2 is true, and/or 
   iii. (n / 3) if n % 3 is true.
2. we have to write brute-force recursive solution for this problem.
   2.1 so, 
   	   base case is -
       
    	if(n == 1){
            return 0;
    	}
    
    2.2 In induction hypothesis -
    	 we initialise 'ans2' and 'ans3' with 'Integer.MAX_VALUE' becuase its initialisation
         is needed to avoid compilation error wrt non-initialized variables, 'ans2' and 'ans3'.
        
    2.3 induction step -
    	 we take the minimum of all "paths" so explored and add 1 to it!
*/

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

