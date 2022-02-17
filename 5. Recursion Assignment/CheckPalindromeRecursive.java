class solution{
    public static boolean isStringPalindrome(String input){
        boolean ans = isStringPalindromeHelper(input,0,input.length()-1);
        return ans;
    }

    public static boolean isStringPalindromeHelper(String input, int si, int ei){
        //si - startIndex 
        //ei - endIndex
        if (si > ei){
            return true;
        }

        if (input.charAt(si) != input.charAt(ei)){
            return false;
        }
        
        boolean output = isStringPalindromeHelper(input, si + 1, ei - 1);
        
        return output;
        
    }
}
