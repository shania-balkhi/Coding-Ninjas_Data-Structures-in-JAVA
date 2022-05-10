/*Code: N Queens

You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :
1<=N<=10
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 
*/

public class Solution {
	
		
	public static void placeNQueens(int n){
		
		int[][] board = new int[n][n];
    	solve(board,n,0);

	}
    
    private static void solve(int[][] board, int n, int rowNum){
        //base case
        if(rowNum == n){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            return;
        }
        
        //look out for the 1st row, rest of the rows will be taken care of by recursion
        for(int colNum = 0; colNum < n; ++colNum){
            if(isSafeToPlace(board, n, rowNum, colNum)){
                board[rowNum][colNum] = 1;
                solve(board, n, rowNum + 1);
                //backtrack marking the concerned cell as 0
                board[rowNum][colNum] = 0;
            }
        }
        
    }
    
    private static boolean isSafeToPlace(int[][] board, int n, int rowNum, int colNum){
        //have to check for safety column-wise and diagonal-wise
        
        //check for same column (in upward direction){
        int r = rowNum;
        int c = colNum;
        while(r >= 0){
            if(board[r][c] == 1){
                return false;
            }
            --r;
        }
        
        //check for same diagonal
        
        //for diagonal in upward-right direction
        r = rowNum;
        c = colNum;
        while(r >= 0 && c < n){
            if(board[r][c] == 1){
                return false;
            }
            --r;
            ++c;
        }
        
        //for diagonal in upward-left direction
        r = rowNum;
        c = colNum;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 1){
                return false;
            }
            --r;
            --c;
        }
        
        return true;
        
    }
    
}

/*
algo -
1. typical backtracking problem


2. the class 'Solution' has 3 methods, namely, 
   (a) placeNQueens(int n)
   (b) solve(int[][] board, int n, int rowNum)
   (c) isSafeToPlace(int[][] board, int n, int rowNum, int colNum)
   
   2.1 'placeNQueens(int n)' creates a matrix called 'board' (chessboard) with dimension n*n.
   		then it calls the 'solve(int[][] board, int n, int rowNum)' method which we will 
        explore in later steps.
        
   2.2 'solve(int[][] board, int n, int rowNum)' is the principle recursive method that
   		implements the 'backtracking' portion here.
        we'll explore it in later steps.
        
   2.3 'isSafeToPlace(int[][] board, int n, int rowNum, int colNum)' is the method that returns true
        if the cell (position in the matrix) concerned is "safeForTheQueenToBePlaced", otherwise returns false.

        we make scans in the following three directions :
        	i. column wise - (upwards)
            ii. diagonally - (upwards-right)
            iii. diagonally - (upwards-left)
            
        if a cell is already filled with '1' (indicating the presence of a queen. likewise '0' indicates
        absence of queen), in either of the above 3 directions, 'false' is returned. Otherwise 'true'
        is returned meaning that the queen can be safely placed in the concerned cell.
        
        NOTE - in this method, make sure to create (and initialise) two variables (say, 'r' for rowNum and 'c' for colNum)
               and then initailse these vaiables as 
               "r = rowNum;
                c = colNum;"
                before beginning scanning in the 3 aforementioned directions.
                This is because if we keep on operating on the 'rowNum' & 'colNum' variables passed as parameters,
                then their respective required-original values will be changed as we go down the lines of code which will
                hamper the performance of the code and thus will result in wrong output being produced.
                
        
3. Inside the 'solve(int[][] board, int n, int rowNum)' method -
   
   3.1 base case - if rowNumber becomes equal to the given dimension 'n', 
   					we print the 'board[][]' matrix and then return.
                    
       note - it is essential to write the return statement (line 139)
              failing which only the first line of the required output
              will be printed (and the rest of the output lines won't get printed).
              
    3.2 in the induction step (lines 142 to 150), our object is to fill the first row correctly;
        since the filling of the rest of the rows correctly will be taken care of by recursion.
        
        Hence, for the filling of the first row, we need to scan/traverse all the columns of the 
        given row (hence the line 143)
        
        then, we call the 'isSafeToPlace(int[][] board, int n, int rowNum, int colNum)' method. if it returns 
        'false', the loop on line 143 is incremented to reach and check safety for the next available column of the
        current row in the board.
        
        if it returns 'true', 
        	i. fill the current cell with '1'
            ii. call 'solve(board, n, rowNum + 1)' method recursively. with "row-number = previous-row-number + 1" 
                to go the next row for scanning/traversal.
            iii. again, fill that current cell with '0'. this is necessary for backtracking. 
      
*/
