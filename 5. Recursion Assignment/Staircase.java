public class Solution {
     public static int staircase(int n){
         
		    if (n == 1){     //since, if n = 1, W = 1
            return 1;
        }
         
        if (n == 2){     // since, if n = 2, W = 2
            return 2;
        }
         
        if (n == 3){     // since, if n = 3, W = 4
            return 4;
        }
         
        return staircase(n - 1) + staircase(n - 2) + staircase(n - 3);
       
	}
}
