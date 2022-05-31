/*
Min Cost Path Problem

An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.
 Input format :
The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. 
They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

The second line onwards, the next 'M' lines or rows represent the ith row values.

Each of the ith row constitutes 'N' column values separated by a single space.
Output format :
Print the minimum cost to reach the destination.
Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2

Time Limit: 1 sec
Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13
Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76
Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18
*/
/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
//1. Brute - force recursive solution
// public class Solution {

// 	public static int minCostPath(int[][] input) {
// 		return minCostPath(input, 0, 0);
// 	}
    
// 	private static int minCostPath(int[][] input, int i, int j){
        
//         //base case
//         if (i == input.length - 1 && j == input[0].length - 1){
//             return input[i][j];
//         }
        
//         //induction hypothesis
//         int down = Integer.MAX_VALUE;
//         int right = Integer.MAX_VALUE;
//         int diagonal = Integer.MAX_VALUE;
//         if(isSafeToTravel(input, i + 1, j)){
//             down = minCostPath(input, i + 1, j);
//         }
//         if(isSafeToTravel(input, i, j + 1)){
//             right = minCostPath(input, i, j + 1);
//         }
//         if(isSafeToTravel(input, i + 1, j + 1)){
//             diagonal = minCostPath(input, i + 1, j + 1);
//         }
        
//         //induction step
//         return input[i][j] + Math.min(down, Math.min(right, diagonal));
        
//     }
    
//     private static boolean isSafeToTravel(int[][] input, int i, int j){
//         if(i >= input.length || j >= input[0].length){
//             return false;
//         }
//         return true;
//     }
    
// }





/*algo (1. Brute - force recursive solution) - 
1. we have three methods in the 'Solution' class, namely,
   i. public static int minCostPath(int[][] input),
   ii. private static int minCostPath(int[][] input, int i, int j), and
   iii. private static boolean isSafeToTravel(int[][] input, int i, int j)
   
	1.1. about the 'public static int minCostPath(int[][] input)' method -
    	 we just call the helperFuction 'private static int minCostPath(int[][] input, int i, int j)' 
    	 (this helperFuction will be explored in later steps) and return it.
    
    1.2 about the 'private static int minCostPath(int[][] input, int i, int j)' method -
        This is the core recursive code/method that solves this problem. We'll explore 
        this method in later steps.
        
    1.3 about the 'private static boolean isSafeToTravel(int[][] input, int i, int j)' method -
        This is the method that returns true if the cell (position in the matrix) concerned is 
        safeToTravelTo, otherwise returns false.

        we return 'false' if 'i' and/or 'j' exceed the boundaries of the matrix, otherwise 
        we return true (line 83).
        [
          'i' and 'j' are the coordinates/indexPositions of the matrix. 
          'i' = num of rows, and
          'j' = num of columns
        ]


2. inside the 'private static int minCostPath(int[][] input, int i, int j)' method- 	

	2.1 base case -
    	if i and j both reach the ultimate (last) cell of the matrix, then return the 
    	value present in that cell.
        
    2.2 we decalre 3 'int' type variables, namely, 'down', 'right' and 'diagonal';
        and initialise them with infinity i.e., 'Integer.MAX_VALUE', in order to avoid 
        the following error -
        
        Compilation Failed
		./Solution.java:81: error: variable down might not have been initialized
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
                                      ^
		./Solution.java:81: error: variable right might not have been initialized
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
                                                     ^
		./Solution.java:81: error: variable diagonal might not have been initialized
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
                                                            ^
		3 errors
        
    2.3 induction hypothesis -
         we explore the 3 directions - down, right, and diagonal.
         if the current cell is input[i][j] then,
         downward cell coordinates = [i + 1][j],
         rightward cell coordinates = [i][j + 1] and,
         diagonal cell coordinates = [i + 1][j + 1].
       
       
   		2.3.1 the 'private static int minCostPath(int[][] input, int i, int j)' method tells us whether 
       		  we can travel to the concerned cell or not. 
       			(a) if we are "allowed", recursive calls for 'minCostPath(input, i + 1, j)' method 
            		take place. (lines 68, 71, 74) and store the value returned by these recursiveFunctionCalls
                    in the variables 'down', 'right' and 'diagonal' respectively.
         
       			(b) if we are not "allowed", then we are left with the default values of the 
           			variables 'down', 'right' and 'diagonal' respectively which is 'infinity' (Integer.MAX_VALUE) .


    2.4 induction step -
         we take the minimum of all "paths" so explored (i.e., minimum of 'down', 'right' and 'diagonal') and 
         add the value corresponding to the current cell of the matrix (i.e., input[i][j]).
         
    2.5 finally, we return the value calculated in step 2.4
*/

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//2. Recursive DP Solution
//Time Complexity : O(m*n) where m = no. of rows and n = no. of columns
public class Solution {

	public static int minCostPath(int[][] input) {
        int rowLen = input.length;
        int colLen = input[0].length;
        int[][] dp = new int[rowLen + 1][colLen + 1];
        for(int i = 0; i < rowLen; ++i){
            for(int j = 0; j < colLen; ++j){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
		return minCostPath(input, dp, 0, 0);
	}
    
	private static int minCostPath(int[][] input, int[][] dp, int i, int j){
        
        //base case
        if (i == input.length - 1 && j == input[0].length - 1){
            return input[i][j];
        }
        
        //induction hypothesis
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int diagonal = Integer.MAX_VALUE;
        if(isSafeToTravel(input, i + 1, j)){
        	if(dp[i + 1][j] == Integer.MIN_VALUE){
            	down = minCostPath(input, dp, i + 1, j);
                dp[i + 1][j] = down;
        	}else{
                down = dp[i + 1][j];
            }
        }
        
        if(isSafeToTravel(input, i, j + 1)){
        	if(dp[i][j + 1] == Integer.MIN_VALUE){            
            	right = minCostPath(input, dp, i, j + 1);
                dp[i][j + 1] = right;
        	}else{
                right = dp[i][j + 1];
            }
        }
        
        if(isSafeToTravel(input, i + 1, j + 1)){
        	if(dp[i + 1][j + 1] == Integer.MIN_VALUE){
            	diagonal = minCostPath(input, dp, i + 1, j + 1);
                dp[i + 1][j + 1] = diagonal;
        	}else{
                diagonal = dp[i + 1][j + 1];
            }
        }
        
        
        //induction step
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
        
    }
    
    private static boolean isSafeToTravel(int[][] input, int i, int j){
        if(i >= input.length || j >= input[0].length){
            return false;
        }
        return true;
    }
    
}





/*
algo - (for Recursive DP)
1. we have three methods in the 'Solution' class, namely,
   i. public static int minCostPath(int[][] input),
   ii. private static int minCostPath(int[][] input, int i, int j), and
   iii. private static boolean isSafeToTravel(int[][] input, int i, int j)
   
    
	1.1. about the 'public static int minCostPath(int[][] input)' method -
    	 see step 2 for complete explanation of this method.
    
    
    1.2 about the 'private static int minCostPath(int[][] input, int i, int j)' method -
        This is the core recursive code/method that solves this problem. We'll explore 
        this method in later steps.
        
        
    1.3 about the 'private static boolean isSafeToTravel(int[][] input, int i, int j)' method -
        This is the method that returns true if the cell (position in the matrix) concerned is 
        safeToTravelTo, otherwise returns false.

        we return 'false' if 'i' and/or 'j' exceed the boundaries of the matrix, otherwise 
        we return true (lines 231 to 234).
        [
          'i' and 'j' are the coordinates/indexPositions of the matrix. 
          'i' = num of rows, and
          'j' = num of columns
        ]


2. in the 'public static int minCostPath(int[][] input)' method,
   2.1 we create an array named dp[][] of rowSize (m + 1) and columnSize (n + 1) and initialize all 
   	   it's indices with value 'Integer.MIN_VALUE'.   (m = no. of rows in input[][] and n = no. of columns in input[][])
  
   note1 - array rowSize and columnSize are taken as (m + '1') and (n + '1') respectively in order to create one
   extra row and one extra column in order to dodge the 'ArrayIndexOutOfBoundsException' which is certain to get 
   triggered if we take the respective values as just 'm' and 'n' only! (watch MinCost Memoization @00:09:33 for more clarity) 
   
   note2 - instead of incrementing the rowSize and columnSize with 1, we could have written separate lines of code to
   keep a check that no the recursive function call, does not inflict 'ArrayIndexOutOfBoundsException' error (like the method we have
   written for the input[][] matrix - private static boolean isSafeToTravel(int[][] input, int i, int j)). Hence, the programmar could
   chose any of the 2 above mentioned ways to dodge the 'ArrayIndexOutOfBoundsException' error.
   
   note3 - 'Integer.MIN_VALUE' is chosen as the appropriate value for the empty indices of the matrix since 'Integer.MIN_VALUE' 
   is most likely to not in the set of "input values" for the input[][] matrix. The input[][] matrix can contain input values :
   'any +ve integer, any -ve integer, +ve infinity' but not '-ve infinity'.
  
  2.2 then, we call this 'private static int minCostPath(int[][] input, int i, int j)' method.
   
  
3. Inside the 'private static int minCostPath(int[][] input, int i, int j)' method -
    This is the core recursive code/method that solves this problem.
    
    3.1 base case - 
   		 if i and j both reach the ultimate (last) cell of the matrix, then return the 
    	 value present in that cell.
         
    3.2 we decalre 3 'int' type variables, namely, 'down', 'right' and 'diagonal';
        and initialise them with infinity i.e., 'Integer.MAX_VALUE', in order to avoid 
        the following error -
        
        Compilation Failed
		./Solution.java:81: error: variable down might not have been initialized
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
                                      ^
		./Solution.java:81: error: variable right might not have been initialized
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
                                                     ^
		./Solution.java:81: error: variable diagonal might not have been initialized
        return input[i][j] + Math.min(down, Math.min(right, diagonal));
                                                            ^
		3 errors
         
    3.3 memoization & induction hypothesis - 
    	3.3.1. we check whether the [i + 1][j]th index in the dp[][] matrix priorly contains a value or not.
        	   no value is indicated by 'Integer.MIN_VALUE'.
               
               3.3.1.1 So if the concerned index is filled with value 'Integer.MIN_VALUE', then it can be infered that that index does
               		   	not hold a prior value, hence we have to make a recursive call to 'minCostPath(input, dp, i + 1, j)' method and
               		   	store in the variable 'down'. (line 199)
                        
               3.3.1.2 now that we have made the recursive call mentioned in the previous step 3.3.1.1., we have to store 
                       the value returned by this function call in the [i + 1][j]th index of the dp[] array. (line 200)
                       
               3.3.1.3 if the concerned cell was not filled by the value 'Integer.MIN_VALUE' in the first place, one can infer that the 
                        index concerned did hold a valid value priorly; and that value is the required value. Hence, we store 
                        that value in the 'down' variable. (line 202)
                        
        3.3.2 repeat step no. 3.3.1 for [i][j + 1]th index as well as [i + 1][j + 1]th index of the dp[] array.
               
4. induction step - 
    we take the minimum of all "paths" so explored (i.e., minimum of 'down', 'right' and 'diagonal') and 
    add the value corresponding to the current cell of the matrix (i.e., input[i][j]).
        
5. return the value calculated in step 4
*/

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

