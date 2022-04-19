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

//code 1 -
// public class Solution {

// 	public static boolean ratInAMaze(int maze[][]){
// 		int[][] path = new int[maze.length][maze.length];
// 		return  ratInAMaze(maze, 0, 0, path);
// 	}
    
//     private static boolean ratInAMaze(int[][] maze, int i, int j, int[][] path){
//         int n = maze.length;
//         //if i,j values are invalid || path[i][j] has been visited before || maze[i][j] is blocked
//         if(i < 0 || i >= n || j < 0 || j >= n || path[i][j] == 1 || maze[i][j] == 0){
//             return false;
//         }
        
//         //mark the current cell as visited
//         path[i][j] = 1;
        
//         //if destination is reached
//         if(i ==n - 1 && j ==n - 1){
//             return true;
//         }
        
//         //traverse in all 4 directions - top, right, down, left
//         //top
//         if(ratInAMaze(maze, i - 1, j, path)){
//  			      return true;
//         }
        
//         //right
//         if(ratInAMaze(maze, i, j + 1, path)){
//    			    return true;
//         }
        
//         //downward
//         if(ratInAMaze(maze, i + 1, j, path)){
//    			    return true;
//         }
        
//         //left
//         if(ratInAMaze(maze, i, j - 1, path)){
//     		    return true;
//         }
//         return false;
//     }
    
// }

/* algo (for code 1) -
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






/******************************************************************************************************************************************************************/
/******************************************************************************************************************************************************************/


//code 2 - easier to comprehend 
public class Solution {

	public static boolean ratInAMaze(int maze[][]){
        
        //if the source cell itselfis blocked
        if(maze[0][0] == 0){
            return false;
        }
        
	int[][] visited = new int[maze.length][maze.length];
        return solveMaze(maze, 0, 0, visited);

	}
    
    private static boolean solveMaze(int[][] maze, int i, int j, int[][] visited){
        
        int n = maze.length;
        //base case
        if (i == n - 1 && j == n - 1){
            visited[i][j] = 1;
            return true;
        }
        
        
        visited[i][j] = 1;
        
        
        boolean d = false, l = false, r = false, u = false;
        //Explore in all the directions - down, left, right, up 
        //(i chose this format since it's lexographically sorted which isn't mandatory as per the question here)
        //down
        if(isAllowedToTravel(maze, i + 1, j, visited)){
            d = solveMaze(maze, i + 1, j, visited);
        } 
        
        //left
        if(isAllowedToTravel(maze, i, j - 1, visited)){
            l = solveMaze(maze, i, j - 1, visited);
        }
        
        //right
        if(isAllowedToTravel(maze, i, j + 1, visited)){
            r = solveMaze(maze, i, j + 1, visited);
        }
        
        //up
        if(isAllowedToTravel(maze, i - 1, j, visited)){
            u = solveMaze(maze, i - 1, j, visited);
        }
        
        return d || l || r || u;
        
    }
    
    
    private static boolean isAllowedToTravel(int[][] maze, int i, int j, int[][] visited){
        int n = maze.length;
        if (i >= 0 && i < n && j >= 0 && j < n && maze[i][j] == 1 && visited[i][j] == 0){
            return true;
        }
        return false;
    }
    
    
}



/*
algo (for code 2) -
1. it's a backtracking problem (use recursion to solve)
2. the class 'Solution' has 3 methods, namely, 
   (a) ratInAMaze(int[][] maze)
   (b) solveMaze(int[][] maze, int i, int j, int[][] visited)
   (c) isAllowedToTravel(int[][] maze, int i, int j, int[][] visited)

   2.1 'ratInAMaze(int[][] maze)' creates and initialises a 'visited' array with zero
        to keep track of the cells that have or haven't been visited. Value '1' denotes
        'visited' whereas '0' denotes 'not visited'.

	 This method also checks/takes care of an edge case - when the source cell itself is blocked.
       If the source cell itself is blocked, we return false. 

   2.2 'solveMaze(int[][] maze, int i, int j, int[][] visited)' is the core code/method that 
        solves this problem. we'll explore it in later steps.

   2.3 'isAllowedToTravel(int[][] maze, int i, int j, int[][] visited)' is the function that returns true
        is the cell (position in the matrix) concerned is allowedToTravelTo, otherwise returns false.

        we return 'true' in these three conditions are fulfilled -
   	   (a) if both of the i and j coordinates are valid i.e., they are valid when they are greater or equal 
            to zero and less than n (length of the matrix) i.e.,
            (i >= 0 && i < n && j >= 0 && j < n) then return true


	   (b) if the (i,j) cell is not blocked (i.e., maze[i][j] == 1)

   	   (c) if the (i,j) cell has not been visited before (i.e., visited[i][j] == 0)

3. Inside the 'solveMaze(int[][] maze, int i, int j, int[][] visited)' method -
   3.1 we calculate the length of the maze, denoted by n.
   
   
   3.2 base case - if we have reached the cell[n - 1][n - 1], we 
       return whilst marking the visited array as visited (1).
   
   
   3.2 if our code reaches beyond step 3.2, that means we haven't 
       struck the base case yet. So whichever cell (position in the matrix)
       we are currently at, we mark it as visited (line 129).
       
       
   3.3 now, we initailse 4 boolean variables corresponding to each 
       direction that we have to traverse to :- 
       (a) d (down) corresponds to the downward direction.
       (b) l (left) corresponds to the leftward direction.
       (c) r (right) corresponds to the rightward direction.
       (d) u (up) corresponds to the upward direction.
      All these boolean variables are initialsed with value as 'false'.
      
      
   3.4 now, we explore all the 4 directions - down, left, right, up 
       (we can follow whatever sequence we like, I followed this 
       since this format is in lexographical order - which
       isn't mandatory as per the problem statement here.)
       
       
   3.5 the '(isAllowedToTravel(maze, i, j, visited)' method tells us where 
       we can travel in the concerned direction or not. 
       (a) if we are "allowed", recursive calls for 'solveMaze(maze, i, j, visited)' method 
           take place. (lines 137, 142, 147, 152).
           the concerned variable (d, l, r, u) is assigned value 'true'.
         
       (b) if we are not "allowed", then we are left with the default value of the 
           variables d, l, r, u which is 'false'.


   3.6 finally d || l || r || u is returned.
*/
