public class Solution {

	public static boolean checkAB(String input) {
		if (input.length() == 0){
            return true;
        }
        
        if(input.charAt(0) == 'a'){
            if (input.substring(1).length() >= 2 && input.substring(1,3).contains("bb")){  //in the substring(), startIndex is inclusive and endIndex is exclusive.
                return checkAB(input.substring(3));                                        
             }else{
                return checkAB(input.substring(1));
            }
        }
        
        return false;

	}
}
