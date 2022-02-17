class solution{
    public static int multiplyTwoIntegers(int m, int n) {
        if (n == 0)
            return 0;

        int smallOutput = multiplyTwoIntegers(m, n - 1);

        int Output = smallOutput + m;
        return Output;
    }
}
