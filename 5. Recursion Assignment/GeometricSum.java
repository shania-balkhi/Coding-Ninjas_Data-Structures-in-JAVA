class solution{
    public static double findGeometricSum(int k){
        if ( k == 0)
            return 1;

        double smallOutput = findGeometricSum(k - 1);

        double Output = smallOutput + (1/(Math.pow(2,k)));
        return Output;

    } 
}
