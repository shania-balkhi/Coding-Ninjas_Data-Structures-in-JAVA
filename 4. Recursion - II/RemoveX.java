class solution{
    public static String removeX(String input){
        if (input.length() == 0)
            return input;

        String smallString = removeX(input.substring(1));
        if (input.charAt(0) == 'x')
            // return input.replace("x","") + smallString;
            return input.replace("x","");
        else
            return input.charAt(0) + smallString;
    }
}
