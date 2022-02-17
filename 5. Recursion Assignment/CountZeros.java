class solution{
    public static int countZerosRec(int input) {
        int count = 0;
        if (String.valueOf(input).length() == 1){
            if (input % 10 == 0){
                count++;
            }
            return count;
        }

        int smallOutput = countZerosRec(input/10);

        if (input % 10 == 0)
            count++;
        int Output = smallOutput + count;
        return Output;
    }
}
