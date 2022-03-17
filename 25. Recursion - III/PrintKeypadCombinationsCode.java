//code
public class solution{
    public static void printKeypad(int input){
        printKeypadHelper(input, "");
    }
    
    private static void printKeypadHelper(int input, String stringSoFar){
        //base case
        if (input == 0){ //when array becomes empty, print all the combinations 
            System.out.println(stringSoFar);
            return;
        }
        
        int lastDigit = input % 10;
        int smallInput = input / 10;
        for(int i = 0; i < getOptions(lastDigit).length(); ++i){ //to obtain 'stringSoFar' the loop has to be iterated as many times as there are alphabets in the last digit 
            printKeypadHelper(smallInput, getOptions(lastDigit).charAt(i) + stringSoFar); //then those alphabets of the lastDigit are appended towards the end of the 'stringSoFar'
            /*it may appear that the order of parameters in the method should be : printKeypadHelper(smallInput, stringSoFar + getOptions(lastDigit).charAt(i));
              but that's not how it actually should be. dry running will help realise why the order of parameters is in the way that is mentioned.
            */
        }
        
    }
    
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
    
}
