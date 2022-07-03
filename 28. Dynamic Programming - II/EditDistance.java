/*Edit Distance

You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.
 Input format :
The first line of input contains the string S of length M.

The second line of the input contains the String T of length N.
Output format :
Print the minimum 'Edit Distance' between the strings.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 1
//brute force recursive approach
public class Solution {

	public static int editDistance(String s, String t) {
		return editDistanceHelper(s,t,0,0);
    }
    
    private static int editDistanceHelper(String s, String t, int siS, int siT){ //siS == startIndexOfStringS, siT == startIndexOfStringT
		
        //base case
        if ( siS == s.length() ){
            return t.length() - siT;
        }else if( siT == t.length() ){
            return s.length() - siS;
        }
        
        // int smallAns;
        int smallAns1, smallAns2, smallAns3;
        
        //if first characters of both Strings match
        if(s.charAt(siS) == t.charAt(siT)){
            
        	return editDistanceHelper(s, t, siS + 1, siT + 1);
            
        }

        smallAns1 = editDistanceHelper(s, t, siS + 1, siT);         //delete
        smallAns2 = editDistanceHelper(s, t, siS, siT + 1);        //insert
        smallAns3 = editDistanceHelper(s, t, siS + 1, siT + 1);   //replace
    
        return 1 + Math.min(smallAns1, Math.min(smallAns2, smallAns3));
        
    }

}



/*documentation (for brute force recursive code) -
  1. we have 2 methods in the 'Solution' class, namely,
   i. public static int editDistance(String s, String t), and
   ii. private static int editDistanceHelper(String s, String t, int siS, int siT)
   
	1.1. about the 'public static int editDistance(String s, String t)' method -
    	 we just call the helperFuction 'private static int minCostPath(int[][] input, int i, int j)' 
    	 (this helperFuction will be explored in later steps) and return it.
    
    1.2 about the 'private static int minCostPath(int[][] input, int i, int j)' method -
        This is the core recursive code/method that solves this problem. We'll explore 
        this method in later steps.
        
  2. Inside the helper method 'private static int minCostPath(int[][] input, int i, int j)' -
     2.1 base case -
         when length of any one of the Strings becomes zero, then return the length of the other String.
         i.e., when the startIndex of any one of the Strings becomes equal to the length of the respective String, 
         return the "current" length of the other String (i.e., return OtherString.length() - startIndexOfOtherString) 
         
     2.2 induction hypothesis and induction step-
         2.2.1 there are two situations. 
               one : present character of one String "matches" with the present character of the Other String.
               two : present character of one String "does not match" with the present character of the Other String.
                     sitaution two, itself gives rise to 3 measures that we can take :
                     measure 1 : delete character (line 69)
                     measure 2 : insert character (line 70)
                     measure 3 : replace character (line 71)
                     
                     
        2.2.2 in situation one :  we skip the current character of both Strings and move on to the next adjacent character 
                                  of both Strings; by incrementing the StartIndices of both String by 1.
              in situation two :  we take the minimum after performing the 3 "measures" mentioned in the above step and add a 'plus 1'.
                                  (induction step)
              
              
        2.2.3 to delete, increase si of 1st string, leave the si of other String unchanged.
              to insert, leave the si of 1st string unchanged, increase the si of the other string.
              to replace, increase the si of both the strings.
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 2
//memoization
public class Solution {

	public static int editDistance(String s, String t) {
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 0; i < dp.length; ++i){
            for(int j = 0; j < dp[i].length; ++j){
                dp[i][j] = -1;
            }
        }
        
		return editDistanceHelper(s,t,0,0,dp);
    }
    
    private static int editDistanceHelper(String s, String t, int siS, int siT, int[][] dp){ //siS == startIndexOfStringS, siT == startIndexOfStringT
		
        //base case
        if ( siS == s.length() ){
            return t.length() - siT;
        }else if( siT == t.length() ){
            return s.length() - siS;
        }
        
        int smallAns;
        
        
        //if first characters of both Strings match
        if(s.charAt(siS) == t.charAt(siT)){
            
            if(dp[siS][siT] == -1){
                smallAns = editDistanceHelper(s, t, siS + 1, siT + 1, dp);
                dp[siS][siT] = smallAns;
            }else{
                smallAns = dp[siS][siT];
            }
            
        }
        // else{
            
        	int smallAns1, smallAns2, smallAns3;
        

                smallAns1 = editDistanceHelper(s, t, siS + 1, siT, dp);       //delete
                smallAns2 = editDistanceHelper(s, t, siS, siT + 1, dp);      //insert
                smallAns3 = editDistanceHelper(s, t, siS + 1, siT + 1, dp); //replace
        
        
         
        	if(dp[siS][siT] == -1){
                smallAns = 1 + Math.min(smallAns1, Math.min(smallAns2, smallAns3));
                dp[siS][siT] = smallAns;
            }else{
                smallAns = dp[siS][siT];
            }
    
    	// }

        return smallAns;
        
    }

}



/*
documentation - (for Memoization)
1. we have 2 methods in the 'Solution' class, namely,
   i. public static int editDistance(String s, String t), and
   ii. private static int editDistanceHelper(String s, String t, int siS, int siT)
   
	1.1. about the 'public static int editDistance(String s, String t)' method -
    	 we just call the helperFuction 'private static int minCostPath(int[][] input, int i, int j)' 
    	 (this helperFuction will be explored in later steps) and return it.
    
    1.2 about the 'private static int minCostPath(int[][] input, int i, int j)' method -
        This is the core recursive code/method that solves this problem. We'll explore 
        this method in later steps.


2. in the 'public static int minCostPath(int[][] input)' method,
   2.1 we create an array named dp[][] of rowSize (m + 1) and columnSize (n + 1) and initialize all 
   	   it's indices with value '-1'.   (m = no. of rows in input[][] and n = no. of columns in input[][])
  
   note1 - array rowSize and columnSize are taken as (m + '1') and (n + '1') respectively in order to create one
   extra row and one extra column in order to dodge the 'ArrayIndexOutOfBoundsException' which is certain to get 
   triggered if we take the respective values as just 'm' and 'n' only! (watch 4. MinCost Memoization @00:09:33 for more clarity)
   
   note2 - instead of incrementing the rowSize and columnSize with 1, we could have written separate lines of code to
   keep a check that no the recursive function call, does not inflict 'ArrayIndexOutOfBoundsException' error (like the method we have
   written for the input[][] matrix - private static boolean isSafeToTravel(int[][] input, int i, int j)). Hence, the programmar could
   chose any of the 2 above mentioned ways to dodge the 'ArrayIndexOutOfBoundsException' error.
  
  2.2 then, we call this 'private static int editDistanceHelper(String s, String t, int siS, int siT)' method.
   
  
3. Inside the helper method 'private static int minCostPath(int[][] input, int i, int j)' -
     3.1 base case -
         when length of any one of the Strings becomes zero, then return the length of the other String.
         i.e., when the startIndex of any one of the Strings becomes equal to the length of the respective String, 
         return the "current" length of the other String (i.e., return OtherString.length() - startIndexOfOtherString) 
         
         
    3.2 Now, the logic used between lines 149 to 179 is :
      	
        logic - 
           a. there are two situations. 
               one : present character of one String "matches" with the present character of the Other String.
               two : present character of one String "does not match" with the present character of the Other String.
                     sitaution two, itself gives rise to 3 measures that we can take :
                     measure 1 : delete character 
                     measure 2 : insert character 
                     measure 3 : replace character 
                     
                     
           b. in situation one : we store the value of the next diagonal cell in the current cell i.e., dp[i][j] = dp[i + 1][j + 1];  
              in situation two :  we take the minimum after performing the 3 "measures" mentioned in the above step and add a 'plus 1'.
              
              
           c. to delete, increase si of 1st string, leave the si of other String unchanged.
               to insert, leave the si of 1st string unchanged, increase the si of the other string.
               to replace, increase the si of both the strings.
         
         		|STEPS| -
				
                3.2.1 we decalre & initialise 3 'int' type variables, namely, 'smallAns1', 'smallAns2' and 'smallAns3';
                      we make three recursive calls respectively for "all 3 measures" mentioned above & store the value in these variables.
         
    			3.2.2 memoization & induction hypothesis - 
    			      3.2.2.1. we check whether the [i][j]th index in the dp[][] matrix (here, i == siS, j = siT) 
                               priorly contains a value or not. no value is indicated by '-1'.
               
                      3.2.2.2 So if the concerned index is filled with value '-1', then it can be infered that that index does
               		   	      not hold a prior value, hence store the value '1 + Math.min(smallAns1, Math.min(smallAns2, smallAns3));'
                              in a variable 'smallAns' declared earlier (line 175)
                         
                      3.3.1.2 now, we store the above value in the [i][j]th index of the dp[] array. (line 176)
                       
                      3.3.1.3 if the concerned cell was not filled by the value '-1' in the first place, one can infer that the 
                              index concerned did hold a valid value priorly; and that value is the required value. Hence, we store 
                              that value in the 'smallAns' variable. (line 178)
        
4. return the variable 'smallAns'
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//code 3
//Tabulation
public class Solution {

	public static int editDistance(String s, String t) {
		
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        //base cases
        
        //for filling last row
        for(int i = t.length(); i >= 0; --i){
            dp[s.length()][i] = t.length() - i;
        }
        
        //for filling last column
        for(int i = s.length(); i >= 0; --i){
            dp[i][t.length()] = s.length() - i;
        }
        
        for(int i = dp.length - 2; i >= 0; --i){
            for(int j = dp[i].length - 2; j >= 0; --j){
                
                if(s.charAt(i) == t.charAt(j)){
                	dp[i][j] = dp[i + 1][j + 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
                
            }
        }
        
        return dp[0][0];
        
    }

}

/*documentation - 
	1. we create an array named dp[][] of rowSize (m + 1) and columnSize (n + 1) and initialize all 
   	   it's indices with value '0'.
       (m = size of String s and n = size of String t)
  
   note1 - array rowSize and columnSize are taken as (m + '1') and (n + '1') respectively in order to create one
   extra row and one extra column in order to dodge the 'ArrayIndexOutOfBoundsException' which is certain to get 
   triggered if we take the respective values as just 'm' and 'n' only! (watch 4. MinCost Memoization @00:09:33 for more clarity)
   
   note2 - instead of incrementing the rowSize and columnSize with 1, we could have written separate lines of code to
   keep a check that the recursive function call, does not inflict 'ArrayIndexOutOfBoundsException' error. Hence, the programmar could
   chose any of the 2 above mentioned ways to dodge the 'ArrayIndexOutOfBoundsException' error.
   
   
   2. write base cases to fill the last row & last column with "base values".
   		2.1 for last row : length of String s has exhausted, so write the current length of String t. (lines 284 to 286)
        2.2 for last column : length of String t has exhausted, so write the current length of String s. (lines 289 to 291)
   
   3. Now, in this dp[][] matrix, we start traversing from the penultimate diagonal cell (dp[i = dp.length - 2][j = dp[i].length - 2],
      backwards till the [0,0] index. (line 293 & 294)
      
      Now, the logic used between lines 296 to 300 is :
      	
        logic - 
           3.1 there are two situations. 
               one : present character of one String "matches" with the present character of the Other String.
               two : present character of one String "does not match" with the present character of the Other String.
                     sitaution two, itself gives rise to 3 measures that we can take :
                     measure 1 : delete character
                     measure 2 : insert character
                     measure 3 : replace character 
                     
                     
           3.2 in situation one : we store the value of the next diagonal cell in the current cell i.e., dp[i][j] = dp[i + 1][j + 1];  
              in situation two :  we take the minimum after performing the 3 "measures" mentioned in the above step and add a 'plus 1'.
              
              
           3.3 to delete, increase si of 1st string, leave the si of other String unchanged.
               to insert, leave the si of 1st string unchanged, increase the si of the other string.
               to replace, increase the si of both the strings.
          
  3. we return dp[0][0] meaning that the [0][0]th index of the dp[][] matrix stores the desired output.
*/

/*-------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
