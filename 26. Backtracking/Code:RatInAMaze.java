/*
Code: Rat In A Maze

You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
Input Format
Line 1: Integer N
Next N Lines: Each line will contain ith row elements (separated by space)
Output Format :
The output line contains true if any path exists for the rat to reach its destination otherwise print false.
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true
Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
 false
*/

//code
public class Solution {

	public static boolean ratInAMaze(int maze[][]){
		int[][] path = new int[maze.length][maze.length];
		return  ratInAMaze(maze, 0, 0, path);
	}
    
    private static boolean ratInAMaze(int[][] maze, int i, int j, int[][] path){
        int n = maze.length;
        //if i,j values are invalid || path[i][j] has been visited before || maze[i][j] is blocked
        if(i < 0 || i >= n || j < 0 || j >= n || path[i][j] == 1 || maze[i][j] == 0){
            return false;
        }
        
        //mark the current cell as visited
        path[i][j] = 1;
        
        //if destination is reached
        if(i ==n - 1 && j ==n - 1){
            return true;
        }
        
        //traverse in all 4 directions - top, right, down, left
        //top
        if(ratInAMaze(maze, i - 1, j, path)){
 			      return true;
        }
        
        //right
        if(ratInAMaze(maze, i, j + 1, path)){
   			    return true;
        }
        
        //downward
        if(ratInAMaze(maze, i + 1, j, path)){
   			    return true;
        }
        
        //left
        if(ratInAMaze(maze, i, j - 1, path)){
    		    return true;
        }
        return false;
    }
    
}

/* algo -
1. it's implemented using backtracking appraoch (recursion)
2. firstly we create a 2d matrix called 'path' to mark the cells that have been traversed/explored/visited. (line 31)
3. we call the helperFunction 'ratInAMAze(maze,i,j,path)' and pass these 4 arguments :- (line 32)
   (a) the 2d matrix 'maze'
   (b) the coordinates (i.e., position) of the rat denoted by (i,j)
       (b.1) i (intially i = 0, since source cell (i,j) == (0,0))
       (b.2) j (intially j = 0, since source cell (i,j) == (0,0))
   (c) the 2d matrix 'path'
   we return this fucntion-call (i.e., return ratInAMaze(maze, i, j, path))
4. in the 'ratInAMaze()' helperFunction, we calculate the length of 'maze' matrix and store it in 'n' (line 36)
5. we return 'false' in these three conditions - (lines 37 to 40)
   (a) if any one or both of the (i,j) coordinates is invalid i.e., (i < 0 || i >= n || j < 0 || j >= n)
   (b) if the (i,j) cell is already visited (i.e., path[i][j] == 1)
   (c) if the (i,j) cell is blocked (i.e., maze[i][j] == 0)
6. if that's not the case, (point no. 5) then mark the current (i,j)th cell as visited (i.e., path[i][j] = 1) (lines 42 - 43)
7. check if the current (i,j)th cell is the destination cell. if it is, return true otherwise go to step 8 (lines 45 to 48)
8. traverse in the 4 directions till the destination cell is reached (if it exists, otherwise, return false). (lines 50 to 70)
*/
