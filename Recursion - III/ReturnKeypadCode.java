public class solution {
    private static String getOptions(int digit){
         if(digit == 2){
            return "abc";
        }
         if(digit == 3){
            return "def";
        }
         if(digit == 4){
            return "ghi";
        }
         if(digit == 5){
            return "jkl";
        }
         if(digit == 6){
            return "mno";
        }
         if(digit == 7){
            return "pqrs";
        }
         if(digit == 8){
            return "tuv";
        }
         if(digit == 9){
            return "wxyz";
        }
        
        return "";
    }
    
	public static String[] keypad(int n){
		if(n == 0){
            String[] baseOutput = new String[1];
            baseOutput[0] = "";
            return baseOutput;
        }
        
        String[] smallOutput = keypad(n/10);
        
        int lastDigit = n % 10;
        String lastDigitOptions = getOptions(lastDigit);
        String[] output = new String[smallOutput.length * lastDigitOptions.length()];
        
        int k = 0;
        for(int i = 0; i < smallOutput.length; ++i){
            for(int j = 0; j < lastDigitOptions.length(); ++j){
                output[k] = smallOutput[i] + lastDigitOptions.charAt(j);
                ++k;
            }
        }
        return output;
	}
}
