class solution{
    public static String addStars(String s){
        if (s.length() == 1)
            return s;

        String smallOutput = addStars(s.substring(0, s.length() - 1));

        char lasStringChar = s.charAt(s.length() - 1);
        if (lasStringChar == s.charAt(s.length() - 2))
            return smallOutput + "*" + lasStringChar;
        else
            return smallOutput + lasStringChar;
    }
}
