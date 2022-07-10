/*
Subset Sum

You are given a set of N integers. You have to return true if there exists a subset that sum up to K, otherwise return false.
Input Format
The first line of the test case contains an integer 'N' representing the total elements in the set.

The second line of the input contains N integers separated by a single space.    

The third line of the input contains a single integer, denoting the value of K.
Output Format
Output Yes if there exists a subset whose sum is k, else output No.
Constraints :
1 <= N <= 10^3
1 <= a[i] <= 10^3, where a[i] denotes an element of the set 
1 <= K <= 10^3

Time Limit: 1 sec
Sample Input 1 :
4
4 3 5 2
13
Sample Output 1 :
No
Sample Input 2 :
5
4 2 5 6 7
14
Sample Output 2 :
Yes
*/

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 1
//brute force recursive approach - hence, gives TLE!
public class Solution {

	static boolean isSubsetPresent(int[] arr, int n, int sum) {
		
        return isSubsetPresentHelper(arr, 0, sum);
        
	}
    
    private static boolean isSubsetPresentHelper(int[] arr, int i, int sum) {  //i represents ith element
        
        //base cases
        if(sum == 0){
            return true;
        }
        
        if(i >= arr.length){
            return false;
        }
        
        boolean ans;
            
        if(arr[i] > sum){
                
            ans = isSubsetPresentHelper(arr, i + 1, sum);
                
        }
        // else{
                
        boolean ans1, ans2;
        ans1 = isSubsetPresentHelper(arr, i + 1, sum);   //exclude 
        ans2 = isSubsetPresentHelper(arr, i + 1, sum - arr[i]);  //include
                
        ans = ans1 || ans2;
                
        
        return ans;
        
    }

}

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 2
//memoization
public class Solution {

	static boolean isSubsetPresent(int[] arr, int n, int sum) {
		
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        return isSubsetPresentHelper(arr, 0, sum, dp);
        
	}
    
    private static boolean isSubsetPresentHelper(int[] arr, int i, int sum, boolean[][] dp) {  //i represents ith element
        
        //base cases
        if(sum == 0){
            return true;
        }
        
        if(i >= arr.length){
            return false;
        }
        
        if (dp[i][sum] != false){
            return dp[i][sum];
        }
        
        boolean ans;
            
        if(arr[i] > sum){
                
            return dp[i][sum] = isSubsetPresentHelper(arr, i + 1, sum, dp);
                
        }
        // else{
                
        boolean ans1, ans2;
        ans1 = isSubsetPresentHelper(arr, i + 1, sum, dp);   //exclude 
        ans2 = isSubsetPresentHelper(arr, i + 1, sum - arr[i], dp);  //include
                
        return dp[i][sum] = ans1 || ans2;
                
    }

}

/*---------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
