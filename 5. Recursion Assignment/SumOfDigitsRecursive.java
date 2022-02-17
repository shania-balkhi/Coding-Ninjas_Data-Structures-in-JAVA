class solution{
    public static int sumOfDigits(int input){
        if (String.valueOf(input).length() == 1)
            return input;

        int smallOutput = sumOfDigits(input/10);

        int Output = smallOutput + (input%10);
        return Output;
    }
}
