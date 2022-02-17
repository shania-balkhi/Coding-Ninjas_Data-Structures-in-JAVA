class solution{
    public static int convertStringToInt(String input){
        if (input.length() == 1)
            return input.charAt(0) - '0';

        int smallOutput = convertStringToInt(input.substring(0, input.length() - 1)); 

        int lastNum = input.charAt(input.length() - 1) - '0';
        int Output = (smallOutput * 10) + lastNum;
        return Output;
    }
}
