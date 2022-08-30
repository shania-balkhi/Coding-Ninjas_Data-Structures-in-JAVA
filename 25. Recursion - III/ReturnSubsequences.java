/*
Q. Return all subsequences of a String.

Example - for "xyz", 
          the subsequnces are as follows :
          
      "" (empty string)    
      z
      y
      yz
      x
      xz
      xy
      xyz
*/

/*--------------------------------------------------------------------------------------------------------------------------------------------------------------------*/

import java.util.Scanner;

class Solution{
    public static String[] subsequences(String input){
        if(input.length() == 0){
            String[] outputOfBaseCase = new String[1];
            outputOfBaseCase[0] = "";
            return outputOfBaseCase;
        }

        String[] smallOutput = subsequences(input.substring(1));

        String[] output = new String[smallOutput.length * 2];
        //first, copying as it is
        for(int i = 0; i < smallOutput.length; ++i){
            output[i] = smallOutput[i];
        }
        //then, adding first character at front and then copying smallOutput to output
        for(int i = 0; i < smallOutput.length; ++i){
            output[smallOutput.length + i] = input.charAt(0) + smallOutput[i];
        }
        return output;
    }
}
class Subsequences{
    public static void main(String[] args) {
        System.out.println("Enter string : ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("The subsequnces of " + input + " are : ");
        String[] output = Solution.subsequences(input);
        for(String element : output){
            System.out.println(element);
        }
    }
}
