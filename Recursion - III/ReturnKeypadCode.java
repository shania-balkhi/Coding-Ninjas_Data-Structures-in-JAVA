//code
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
        //it's easier to pass the first (n-1) digits since for that /10 would work all fine. but if we decide to pass the last (n-1) digits 
        //then we'll have to figure out the the multiple of 10 by which we will divide the input digit
        
        int lastDigit = n % 10; //to find the last digit
        String lastDigitOptions = getOptions(lastDigit); //to know how many alphabets corresponding to the last digit exists in the keypad. for eg, 4 has 3(d,e,f) & 7 has 4(p,q,r,s)
        String[] output = new String[smallOutput.length * lastDigitOptions.length()]; //delcare the output array of size as mentioned 
        
        int k = 0; //this is the index of the output array where each outputElement needs to be stored
        
        //just append the lastDigit's alphabets to the smallOutputArrayElements to obtain the final output array
        for(int i = 0; i < smallOutput.length; ++i){  
            for(int j = 0; j < lastDigitOptions.length(); ++j){
                output[k] = smallOutput[i] + lastDigitOptions.charAt(j); //since we chose to work on the first (n-1) digits for convenience, we gotta append the laslDigit's corresponding alphabets towards the end. hence it's concatenated second to the smallOutputArray 
                ++k;
            }
        }
        return output;
	}
}
