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
public class Solution {

	public static int minCostPath(int[][] input) {
		return minCostPath(input, 0, 0);
	}
    
	private static int minCostPath(int[][] input, int i, int j){
        
        //base case
        if (i == input.length - 1 && j == input[0].length - 1){
            return input[i][j];
        }
        
        //induction hypothesis
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int diagonal = Integer.MAX_VALUE;
        if(isSafeToTravel(input, i + 1, j)){
            down = minCostPath(input, i + 1, j);
        }
        if(isSafeToTravel(input, i, j + 1)){
            right = minCostPath(input, i, j + 1);
        }
        if(isSafeToTravel(input, i + 1, j + 1)){
            diagonal = minCostPath(input, i + 1, j + 1);
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
