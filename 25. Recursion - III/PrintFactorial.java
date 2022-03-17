import java.util.Scanner;

class Solution{
    public static void factorial(int input, int answer){
        if(input == 0){
            System.out.println(answer);
            return;
        }

        answer = answer * input;
        factorial(input - 1, answer);
    }
}

public class PrintFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution.factorial(n, 1);
    }
}
