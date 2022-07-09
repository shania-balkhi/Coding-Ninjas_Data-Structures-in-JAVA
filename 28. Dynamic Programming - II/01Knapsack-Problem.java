/*
0 1 Knapsack - Problem
Send Feedback
A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.'
What would be the maximum value V, that the thief can steal?
Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
Output Format :
Print the maximum value of V that the thief can steal.
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 1 
//brute force recursive approach - gives RE (StackOverflow Exception since this approach is brute force). 
//Hence, follow this only to learn about the brute force approach. Obviously, this won't pass the test cases. 
public class Solution {

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		
        return knapsackHelper(weights, values, 0, maxWeight);
        
	}
    
    private static int knapsackHelper(int[] weights, int[] values, int n, int maxWeight) {
        
        //base case
        if(n >= weights.length){
            return 0;
        }
        
        int ans;
            
            if(weights[n] > maxWeight){
                
                ans = knapsack(weights, values, n + 1, maxWeight);
                
            }else{
                
                int ans1, ans2;
                ans1 = knapsackHelper(weights, values, n + 1, maxWeight);   //exclude 
                ans2 = values[n] + knapsackHelper(weights, values, n + 1, maxWeight - weights[n]);  //include
                
                ans = Math.max(ans1, ans2);
                
            }
            
        
        return ans;
        
    }

}

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 2
//memoization
public class Solution {

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        
        int[][] dp = new int[n + 1][maxWeight + 1];    //n = number of items
		
        return knapsackHelper(weights, values, 0, maxWeight, dp);
        
	}
    
    private static int knapsackHelper(int[] weights, int[] values, int i, int maxWeight, int[][] dp) {
        
        //base case
        if(i >= weights.length){
            return 0;
        }
        

        if(dp[i][maxWeight] != 0){
            return dp[i][maxWeight];
        }
            
        if(weights[i] > maxWeight){
                
            dp[i][maxWeight] = knapsackHelper(weights, values, i + 1, maxWeight, dp);
                
        }else{
                
            int ans1, ans2;
            ans1 = knapsackHelper(weights, values, i + 1, maxWeight, dp);   //exclude 
            ans2 = values[i] + knapsackHelper(weights, values, i + 1, maxWeight - weights[i], dp);  //include
                
            dp[i][maxWeight] = Math.max(ans1, ans2);
                
        }
            
        return dp[i][maxWeight];
        
    }

}

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 3
//tabulation
public class Solution {

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		
        int[][] dp = new int[n + 1][maxWeight + 1];
        
        for(int i = dp.length - 2; i >= 0; --i){
            for(int j = 0; j <= dp[i].length - 1; ++j){
                
                if (weights[i] > j){
                    
                    dp[i][j] = dp[i + 1][j];
                    
                }else{
                    
                    int ans1, ans2;
                    ans1 = dp[i + 1][j];                          //exclude  
                    ans2 = values[i] + dp[i + 1][j - weights[i]];  //include
                    
                    dp[i][j] = Math.max(ans1, ans2);    
                        
                }
                
                
            }
        }
        
        return dp[0][dp[0].length - 1];
        
	}

}

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
