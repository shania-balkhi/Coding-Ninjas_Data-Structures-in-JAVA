import java.util.Scanner;

class Solution{
    public static void printSubsequences(String input, String stringSoFar){
        if(input.length() == 0){
            System.out.println(stringSoFar);
            return;
        }

        printSubsequences(input.substring(1), stringSoFar);
        printSubsequences(input.substring(1), stringSoFar + input.charAt(0));
    }
}

public class PrintSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Solution.printSubsequences(input, "");
    }
}
