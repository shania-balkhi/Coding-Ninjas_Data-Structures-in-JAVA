/*Code: Rat In a Maze All Paths

You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
Input Format
The first line of input contains an integer 'N' representing 
the dimension of the maze.
The next N lines of input contain N space-separated 
integers representing the type of the cell.
Output Format :
For each test case, print the path from start position to destination position and only cells that are part of the solution path should be 1, rest all cells should be 0.

Output for every test case will be printed in a separate line.
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format.
*/

public class Solution {


	public static void ratInAMaze(int maze[][], int n) {
        
        //if the source cell itselfis blocked
        if(maze[0][0] == 0){
            return;
        }
		
        int[][] visited = new int[n][n];
        solveMaze(maze, n, 0, 0, visited);

	}
    
    private static void solveMaze(int[][] maze, int n, int i, int j, int[][] visited){
        //base case
        if (i == n - 1 && j == n - 1){
            
            visited[i][j] = 1;
            
            for(int row = 0; row < n; ++row){
                for(int column = 0; column < n; ++column){
                    System.out.print(visited[row][column] + " ");
                }
            }
            System.out.println();
            
            visited[i][j] = 0;
            
        }
        
        visited[i][j] = 1;
        
        //Explore in all the directions - top, down, left, right
        //top
        if(isAllowedToTravel(maze, n, i - 1, j, visited)){
            solveMaze(maze, n, i - 1, j, visited);
        }
        //down
        if(isAllowedToTravel(maze, n, i + 1, j, visited)){
            solveMaze(maze, n, i + 1, j, visited);
        }
        //left
        if(isAllowedToTravel(maze, n, i, j - 1, visited)){
            solveMaze(maze, n, i, j - 1, visited);
        }
        //right
        if(isAllowedToTravel(maze, n, i, j + 1, visited)){
            solveMaze(maze, n, i, j + 1, visited);
        }
        
        visited[i][j] = 0;
        
    }
    
    private static boolean isAllowedToTravel(int[][] maze, int n, int i, int j, int[][] visited){
        if (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && visited[i][j] == 0){
            return true;
        }
        return false;
    }
    

}

/*
algo -
1. it's a backtracking problem (use recursion to solve)
2. the class 'Solution' has 3 methods, namely, 
   (a) ratInAMaze(int[][] maze, int n)
   (b) solveMaze(int[][] maze, int n, int i, int j, int[][] visited)
   (c) isAllowedToTravel(int[][] maze, int n int i, int j, int[][] visited)

   2.1 'ratInAMaze(int[][] maze, int n)' creates and initialises a 'visited' array with zero
        to keep track of the cells that have or haven't been visited. Value '1' denotes
        'visited' whereas '0' denotes 'not visited'.

	    This method also checks/takes care of an edge case - when the source cell itself is blocked.
        If the source cell itself is blocked, we return false. 

   2.2 'solveMaze(int[][] maze, int n, int i, int j, int[][] visited)' is the core code/method that 
        solves this problem. we'll explore it in later steps.

   2.3 'isAllowedToTravel(int[][] maze, int n, int i, int j, int[][] visited)' is the function that returns true
        if the cell (position in the matrix) concerned is allowedToTravelTo, otherwise returns false.

        we return 'true' in these three conditions are fulfilled -
   	   (a) if both of the i and j coordinates are valid i.e., they are valid when they are greater or equal 
            to zero and less than n (length of the matrix) i.e.,
            (i >= 0 && i < n && j >= 0 && j < n) then return true


	   (b) if the (i,j) cell is not blocked (i.e., maze[i][j] == 1)

   	   (c) if the (i,j) cell has not been visited before (i.e., visited[i][j] == 0)

3. Inside the 'solveMaze(int[][] maze, int n, int i, int j, int[][] visited)' method -
   
   
   3.1 base case - if we have reached the cell[n - 1][n - 1], 
       i. we mark that cell as visited (1) in the visitedMatrix[].
       ii. print the visitedMatrix[].
       iii. again, mark the cell as unvisited (0) in the visitedMatrix[].
       
       note - (iii) is required because in the given problem, we are to print 
       all possible paths. And we have to make sure that the current route/path
       is not being hampered because of a previously existing path (or, a path that
       may have existed previously). Hence, unmarking that cell becomes necessary.
   
   
   3.2 if our code reaches beyond step 3.2, that means we haven't 
       struck the base case yet. So whichever cell (position in the matrix)
       we are currently at, we mark it as visited (line 79).
      
      
   3.3 now, we explore all the 4 directions - top, down, left, right
       
       
   	   3.3.1 the '(isAllowedToTravel(maze, i, j, visited)' method tells us where 
              we can travel in the concerned direction or not. 
       3.3.2 if we are "allowed", recursive calls for 'solveMaze(maze, i, j, visited)' method 
            take place. (lines 84, 88, 92, 96)


   3.4 lastly, we unmark (assign 0) the concenred cell in the visitedMatrix[] 
       for the same reason stated in step 3->3.1->(iii) (line 99)
*/
