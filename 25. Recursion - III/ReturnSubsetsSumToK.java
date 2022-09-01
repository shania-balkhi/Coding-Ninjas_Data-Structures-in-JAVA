/*
Return subsets sum to K

Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20
Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1
*/

/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/

public class solution {

    
	public static int[][] subsetsSumK(int input[], int k) {
        
		return subsetsSumKHelper(input, k, 0);  //0 is the startIndex if input[] array
        
	}
    
    
    public static int[][] subsetsSumKHelper(int input[], int k, int si) { //si == startIndex
			
        //base case
        if (si >= input.length){
            
            int[][] arr;
            
            if(k == 0){
                
                arr = new int[1][0];    //matrix with 1 cell
                
            }else{
                
                arr = new int[0][0];   //empty matrix. matrix with zero cell.
                
            }
            
            return arr;
            
        }	
        
        //initialise two smallOutput arrays, one for exclude and other for include
        int[][] so1 = subsetsSumKHelper(input, k, si + 1); //exclude //so1 == smallOutput1
        int[][] so2 = subsetsSumKHelper(input, k - input[si], si + 1); //include //so2 == smallOutput2
            
        //initialise output array with size as given below
        int[][] output = new int[so1.length + so2.length][];   //column coordinate has not been defined as yet since the output[][] matrix will be a jagged matrix
            
        //copy exclude smallOutput i.e., so1 to output[][] matrix directly
        for(int i = 0; i < so1.length; ++i){
            
            output[i] = new int[so1[i].length]; //defining size of column coordinate since we know output[][] matix is a jagged matrix
            
            for(int j = 0; j < so1[i].length; ++j){
                output[i][j] = so1[i][j];
            }
            
        }
        
        //now copy include smallOutput after adding input[si] to its front, in output[][] matrix
        for(int i = 0; i < so2.length; ++i){
            
            output[i + so1.length] = new int[so2[i].length + 1]; //defining size of column coordinate since we know output[][] matix is a jagged matrix
            													  // +1 because the apprarent "0th index" is booked by input[startIndex]. so need to do a plus 1 inorder to accomodate the rest of the elements.
            
            output[i + so1.length][0] = input[si];  //adding input[si] to the front of output[][]
            
            for(int j = 0; j < so2[i].length; ++j){
                output[i + so1.length][j + 1] = so2[i][j];   //j is starting from 1, and not 0, because because the "0th index" is booked by input[startIndex]. see line 79.
            }
            
        }
        
        return output;
        
	}
    
    
}

