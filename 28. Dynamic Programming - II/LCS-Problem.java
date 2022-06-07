/*LCS - Problem

Given two strings, 'S' and 'T' with lengths 'M' and 'N', find the length of the 'Longest Common Subsequence'.
For a string 'str'(per se) of length K, the subsequences are the strings containing characters in the same relative order as they are present in 'str,' but not necessarily contiguous. Subsequences contain all the strings of length varying from 0 to K.
Example :
Subsequences of string "abc" are:  ""(empty string), a, b, c, ab, bc, ac, abc.
Input format :
The first line of input contains the string 'S' of length 'M'.

The second line of the input contains the string 'T' of length 'N'.
Output format :
Return the length of the Longest Common Subsequence.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
adebc
dcadb
Sample Output 1 :
3
Explanation of the Sample Output 1 :
Both the strings contain a common subsequence 'adb', which is the longest common subsequence with length 3. 
Sample Input 2 :
ab
defg
Sample Output 2 :
0
Explanation of the Sample Output 2 :
The only subsequence that is common to both the given strings is an empty string("") of length 0.
*/

//1. Brute-force recursive solution
//gives TLE (obviously!) since it's a DP problem which we have first solved using just brute-force recursion here.
public class Solution {
    
    public static int lcs(String s, String t) {
        return lcs(s,t,0,0);
    }

	public static int lcs(String s, String t, int i, int j) {
		
        if(i >= s.length() || j >= t.length()){
            return 0;
        }
        

        int ans = 0;
            if( s.charAt(i) == t.charAt(j) ){
                ans += 1 + lcs(s, t,  i + 1, j + 1);
            }else{
                ans += Math.max( lcs(s, t,  i, j + 1), lcs(s, t,  i + 1, j) );
            }

        return ans;
    }

}

/*documentation -
1. logic - 1.1 if the first char of both Strings is same, add 1 to answer plus make recursive calls to for the rest of the characters 
           		present in both strings s and t.
           1.2 if the char of both Strings is not same, then make recursive calls in "seesaw mannner" ('''my lingo XD'''); meaning
           		that, first, include 'all chars of the first string' and 'all chars of second string except the present char'; 
                secondly, include 'all chars of first string except the present char' and 'all chars of the second string'. Then take the
                max of these two (line 62). 
           1.3 store values so calculated by lines 1.1 and 1.2 and store them in a variable. namely, 'ans' and return it.
*/

/*------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
